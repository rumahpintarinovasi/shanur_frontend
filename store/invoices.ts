import { defineStore } from "pinia";
import axios from '~~/plugins/axios'
import Swal from "sweetalert2";
import type { DeleteInvoiceItemsPayload, Invoice, RequestPayload } from '../helpers/interface';
const $axios = axios().provide.axios

export const useInvoicesStore = defineStore( 'invoices', () => {
    // State
    const invoices = ref([])
    const isLoading = ref(false)

    // Action
    const fetchInvoices = async (options:RequestPayload = {}): Promise<Invoice[]> => {
        try {
            isLoading.value = true
            const { whereConditions, page, size, storeId } = options
            const {data} = await $axios({
                method: 'get',
                url: '/invoice',
                params: {
                    whereConditions : whereConditions || '',
                    page,
                    size,
                    storeId
                }
            })
            
            if (data.data) {
                invoices.value = data
            }
            isLoading.value = false
            return invoices.value
        } catch (error) {
            isLoading.value = false
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

            Swal.fire({
                icon: 'success',
                title: 'Success',
                text: 'Invoice has been added'
            })

            return true
            

        } catch (error) {
            Swal.fire({
                icon: 'error',
                title: 'Error',
                text: error?.response?.data?.message || 'Something wrong'
            })
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

    const updateInvoice = async (payload: any, invoiceNumber: string) => {
        try {
            const { data } = await $axios({
                method : 'PUT',
                url :  `/invoice/${invoiceNumber}`,
                data: payload
            })

            return data
        } catch (error) {
            console.log(error)
        }
    }

    const addInvoiceItems = async (payload:any) => {
        try {
            const { data } = await $axios({
                method : 'POST',
                url : `/invoiceItems`,
                data : payload
            })
            Swal.fire({
                icon: 'success',
                title: 'Success',
                text: 'Invoice Berhasil Diperbarui'
            })
            return data
        } catch (error:any) {
            Swal.fire({
                icon: 'error',
                title: 'Error',
                text: error?.response.data?.message || 'Something wrong'
            })
        }
    }



    const deleteInvoiceItems = async (payload:DeleteInvoiceItemsPayload) => {
        try {
            await $axios({
                method : 'DELETE',
                url : '/invoiceItems',
                data : payload
            })


        } catch (error:any) {
            console.log(error, '<< ini error')
            Swal.fire({
                icon: 'error',
                title: 'Error',
                text: error?.response.data?.message || 'Something wrong'
            })
        }
    }

    return {
        invoices,
        isLoading,
        fetchInvoices,
        addInvoices,
        fetchInvoiceDetail,
        updateInvoice,
        addInvoiceItems,
        deleteInvoiceItems
    }
})
