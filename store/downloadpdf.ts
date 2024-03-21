import { defineStore } from "pinia";
import axios from '~~/plugins/axios'
import Swal from "sweetalert2";
const $axios = axios().provide.axios


export const useDownloadInvoice = defineStore('downloadPdf', () => {
    const downloadInvoices = async (invoiceNumber:String) => {
        try {
            const { data } = await $axios({
                method: 'get',
                url : `/download/invoice/${invoiceNumber}`,
            })

            return data.data
        } catch (error) {
            throw error
        }
    }

    return {
        downloadInvoices
    }
})