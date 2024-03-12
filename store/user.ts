import { defineStore } from "pinia";
import { verifyToken } from "~/helpers";
import type { RequestPayload, User, Response } from "~/helpers/interface";
import { setUserPayload } from "~/helpers/utils";
import axios from '~~/plugins/axios'
const $axios = axios().provide.axios

interface FetchUserResponse extends Response {
    data : User[]
}

export const useUserStore = defineStore( 'user', () => {
        const user = ref([])
        const users = ref([])
        const totalData = ref<Number>(0)
        const fetchUser = async (payload : RequestPayload): Promise<FetchUserResponse> => {
            try {
                const { whereConditions, page, size } = payload
                const {data} = await $axios({
                    method: 'get',
                    url: '/user',
                    params : {
                        whereConditions,
                        page,
                        size
                    }
                })
                
                if (data.data) {
                    users.value = data.data
                    totalData.value = data.meta.totalData || 10
                }

                return data
            } catch (error) {
                throw error
            }
        }
        const updateUserByAdmin = async (payload : User, userId: string) => {
                try {
                    if (!userId) {
                        throw {}
                    }
    
                    const { data } = await $axios({
                        method : 'put',
                        url : `/user/admin/update/${userId}`,
                        data : payload
                    })

                    if (data.err) {
                        throw {}
                    }

                    return data.data
                } catch (error) {
                    
                }
        }

        const registerUser = async (user: any) => {
            const {data} = await $axios({
                method: 'post',
                url: '/auth/register',
                data: user
            })
            
            if (data.data) {
                return data.data
            }
    
        }

        const loginUser = async (user: any) => {
            const {data} = await $axios({
                method: 'post',
                url: '/auth/login',
                data: user
            })



            
            if (data.data) {
                const userPayload = verifyToken(data.data.token)
                setUserPayload(userPayload)
                return data.data
            }
    
        }

        const getRoles = async () => {
            const {data} = await $axios({
                method: 'get',
                url: '/role',
            })
            
            if (data.data) {
                return data.data
            }
    
        }

        const createRole = async (role:any) => {
            const {data} = await $axios({
                method: 'post',
                url: '/role',
                data: role
            })
            
            if (data.data) {
                return data.data
            }
    
        }
    
        return {
            user,
            fetchUser,
            registerUser,
            loginUser,
            getRoles,
            createRole,
            updateUserByAdmin,
            totalData,
        }
    }   
)