import { defineStore } from "pinia";
import { verifyToken } from "~/helpers";
import type { RequestPayload, User, Response } from "~/helpers/interface";
import { setUserPayload } from "~/helpers/utils";
import axios from '~~/plugins/axios'
const $axios = axios().provide.axios

interface FetchUserResponse extends Response {
    data : User[]
}

interface UserInformation {
    id : string
    userName : string
    role : string
    storeId : string
    storeType : string
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

        const loginUser = async (user:any) => {
            try {
              const response = await $axios({
                method: 'post',
                url: '/auth/login',
                data: user
              })
          
              if (response.status === 200 && response.data && response.data.data) {
                const { token } = response.data.data

                console.log('token', token)
          
                const encryptedData: UserInformation  = JSON.parse(verifyToken(token))
                const { id:userId, userName, role, storeId, storeType } = encryptedData
                localStorage.setItem('authorizeToken', token)
                localStorage.setItem('userId', userId)
                localStorage.setItem('userName', userName)
                localStorage.setItem('role', role)
                localStorage.setItem('storeId', storeId)
                localStorage.setItem('storeType', storeType)


          
                return response.data.data
              } else {
                throw new Error('Invalid response format')
              }
            } catch (error) {
              throw new Error(error.response?.data?.message || 'Something went wrong')
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