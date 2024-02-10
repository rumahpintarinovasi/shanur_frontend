import { defineStore } from "pinia";
import axios from '~~/plugins/axios'
import type { Invoice } from '../helpers/interface';
const $axios = axios().provide.axios

export const useInvoicesStore = defineStore( 'invoices', () => {
    // State
    const invoices = ref([])

    // Action
    const fetchInvoices = async (): Promise<Invoice[]> => {
        try {
            const {data} = await $axios({
                method: 'get',
                url: '/invoice',
            })
            
            if (data.data) {
                invoices.value = data.data
            }

            return invoices.value
        } catch (error) {
            throw error
        }
    }

    const addInvoices = async (payload:any) => {
        try {
            const { data } = await $axios({
                method: 'post',
                url: 'invoice',
                data: payload
            })

            return true

        } catch (error) {
            throw error
        }
    }

    return {
        invoices,
        fetchInvoices,
        addInvoices
    }
})
