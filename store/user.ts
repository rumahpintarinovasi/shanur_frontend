import { defineStore } from "pinia";
import config from '~/config'
import axios from '~~/plugins/axios'
const $axios = axios().provide.axios

export const useUserStore = defineStore( 'user', () => {
    
        const user = ref([])
    
        const defaultUrl = config.baseUrlBackend
    
        const fetchUser = async () => {
            const {data} = await $axios({
                method: 'get',
                url: '/user',
            })
            
            if (data.data) {
                user.value = data.data
            }
    
        }

        const registerUser = async (user) => {
            const {data} = await $axios({
                method: 'post',
                url: '/auth/register',
                data: user
            })
            
            if (data.data) {
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

        const createRole = async (role) => {
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
            getRoles,
            createRole
        }
    }   
)