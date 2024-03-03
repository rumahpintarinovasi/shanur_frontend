import { defineStore } from 'pinia'
import type { RequestPayload, Role } from "~/helpers/interface";
import axios from '~~/plugins/axios'
const $axios = axios().provide.axios

export const useRoleStore = defineStore('role', () => {
    const roles = ref<Role[]>([])

    const fetchRoles = async (options : RequestPayload) => {
        try {
            const { whereConditions } = options
            const { data } = await $axios({
                method: 'get',
                url: '/role',
            })
            
            if (data.data)  {
                roles.value = data.data
            }

            return roles.value
        } catch (error) {
            throw error
        }
    }
    return {
        roles,
        fetchRoles
    }
})