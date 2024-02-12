import { defineStore } from "pinia";
import axios from "~~/plugins/axios";
import type { Product } from "../helpers/interface";
const $axios = axios().provide.axios;

export const useProductStore = defineStore('product', () => {
  // State
  const products = ref([]);

  // Action
  const fetchProduct = async (): Promise<Product[]> => {
    try {
      const { data } = await $axios({
        method: "get",
        url: "/product",
      })

      if (data.data) {
        products.value = data.data
      }

      console.log(data.data, '<< ini data')
      return products.value
    } catch (error) {
      throw error;
    }
  }

  const addProduct = async (payload: any) => {
    try {
      const { data } = await $axios({
        method: "post",
        url: "/product",
        data: payload
      })

      return true;
    } catch (error) {
      throw error;
    }
  }


  return {
    products,
    fetchProduct,
    addProduct
  }
});
