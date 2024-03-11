import { defineStore } from "pinia";
import type { RequestPayload, Customer, Response } from "~/helpers/interface";
import axios from '~~/plugins/axios'
const $axios = axios().provide.axios

interface ResponseCustomer  extends Response {
    data : Customer[],
}

export const useCustomerStore = defineStore('customer', () => {
    const customers = ref<Customer[]>([])
    const totalData = ref(0)

    const fetchCustomers = async (payload : RequestPayload) : Promise<ResponseCustomer> => {
        try {
            const { data } = await $axios({
                method : 'get',
                url: '/customer',
                params : {
                    ...payload
                }
            })

            if (data.data) {
                customers.value = data.data
                totalData.value = data.meta.totalData || 0

            }


            return data

        } catch (error) {
            throw error
        }
    }

    const editCustomer = async (payload: any, customerId : string) => {
        console.log(payload)

        return
    }

    return {
        customers,
        totalData,
        fetchCustomers,
        editCustomer
    }
})