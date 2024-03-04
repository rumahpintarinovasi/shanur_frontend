import { defineStore } from "pinia";
import type { RequestPayload, Customer } from "~/helpers/interface";
import axios from '~~/plugins/axios'
const $axios = axios().provide.axios


export const useCustomerStore = defineStore('customer', () => {
    const customers = ref<Customer[]>([])
    const totalData = ref(0)

    const fetchCustomers = async (payload : RequestPayload) : Promise<Customer[]> => {
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
            }

            totalData.value = data.meta.totalData || 0

            return customers.value

        } catch (error) {
            throw error
        }
    }

    return {
        customers,
        totalData,
        fetchCustomers
    }
})