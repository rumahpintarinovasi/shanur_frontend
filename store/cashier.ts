import { defineStore } from "pinia";
import axios from '~~/plugins/axios'
const $axios = axios().provide.axios

export const useCashierStore = defineStore( 'cashier', () => {
    // State
    // Action
    const checkDiscount = async (payload:any) => {
        try {
            const {data} = await $axios({
                method: 'get',
                url: '/cashier/checkDiscount',
                data: payload
            })
            
            if (data.data) {
                return data.data
            }

            return false

        } catch (error) {
            throw error
        }
    }

    const createTransaction = async (payload:any) => {
        try {
            const { data } = await $axios({
                method: 'post',
                url: 'cashier',
                data: payload
            })

            return true

        } catch (error) {
            throw error
        }
    }



    return {
        checkDiscount,
        createTransaction,
    }
})
