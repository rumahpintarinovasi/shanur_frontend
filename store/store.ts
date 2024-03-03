import { defineStore } from "pinia";
import type { RequestPayload, Store, Error } from "~/helpers/interface";
import axios from '~~/plugins/axios'
const $axios = axios().provide.axios


export const useStoresStore = defineStore('store', () => {
    const stores = ref<Store[]>([])

    const fetchStore = async ( options : RequestPayload) : Promise<Store[] > => {
        try {
            const { whereConditions } = options
            const { data } = await $axios({
                method : 'get',
                url : '/store',
                params : {
                    whereConditions
                }
            })

            if (data.data) {
                stores.value = data.data
            }

            return stores.value

        } catch (error: any) {

            return []
        }
    }

        
    return {
        fetchStore
    }
})