import { defineStore } from "pinia";
import axios from "~~/plugins/axios";
import type { Stock } from "../helpers/interface";
const $axios = axios().provide.axios;
import Swal from 'sweetalert2'

export const useStockStore = defineStore('stock', () => {
  // State
  const stocks = ref([]);

  // Action
  const fetchAllStock = async (): Promise<Stock[]> => {
    try {
      const { data } = await $axios({
        method: "get",
        url: "/stock",
      })


      if (data.data) {
        stocks.value = data.data
      }

      return stocks.value
    } catch (error) {
      const message = error?.message || 'Something Wrong'
      Swal.fire({
        title: 'Error!',
        text: message,
        icon: 'error',
      })
      throw error;
    }
  }

  const fetchOneStock = async (id: string): Promise<Stock> => {
    try {
      const { data } = await $axios({
        method: "get",
        url: `/stock/${id}`,
      })

      return data.data
    } catch (error) {
      throw error;
    }
  }

  const addStock = async (payload: any) => {
    try {
      const { data } = await $axios({
        method: "post",
        url: "/stock",
        data: payload
      })

      return true;
    } catch (error) {
      throw error;
    }
  }

  const deleteStock = async (id: string) => {
    try {
      const { data } = await $axios({
        method: "delete",
        url: `/stock/${id}`,
      })

      return true;
    } catch (error) {
      throw error;
    }
  }
  
  const updateStock = async (id: string, payload: any) => {
    try {
      const { data } = await $axios({
        method: "put",
        url: `/stock/${id}`,
        data: payload
      })

      return true;
    } catch (error) {
      throw error;
    }
  }


  return {
    stocks,
    fetchAllStock,
    addStock,
    deleteStock,
    updateStock,
    fetchOneStock
  }
});
