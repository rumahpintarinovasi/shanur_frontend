import { defineStore } from "pinia";
import config from '~/config'
import axios from '~~/plugins/axios'
const $axios = axios().provide.axios

export const useInvoicesStore = defineStore( 'invoices', () => {

    const invoices = ref([])

    const defaultUrl = config.baseUrlBackend

    const fetchInvoices = async () => {
        const {data} = await $axios({
            method: 'get',
            url: '/invoice',
        })
        
        if (data.data) {
            invoices.value = data.data
        }

    }

    return {
        invoices,
        fetchInvoices
    }
})
