import { defineStore } from "pinia";
import axios from '~~/plugins/axios'
import type { Invoice, RequestPayload } from '../helpers/interface';
const $axios = axios().provide.axios

export const useInvoicesStore = defineStore( 'invoices', () => {
    // State
    const invoices = ref([])

    // Action
    const fetchInvoices = async (options:RequestPayload = {}): Promise<Invoice[]> => {
        try {
            const { whereConditions } = options
            const {data} = await $axios({
                method: 'get',
                url: '/invoice',
                params: {
                    whereConditions : whereConditions || ''
                }
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

    const fetchInvoiceDetail = async (invoiceId : string) : Promise<Invoice> => {
        try {
            const { data } = await $axios({
                method : 'get',
                url : `/invoice/${invoiceId}`
            })

            if (data.data) {
                invoices.value = data.data
            }

            return data.data

        } catch (error) {
            throw error
        }
    }

    return {
        invoices,
        fetchInvoices,
        addInvoices,
        fetchInvoiceDetail
    }
})
