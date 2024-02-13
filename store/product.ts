import { defineStore } from "pinia";
import axios from "~~/plugins/axios";
import type { Product } from "../helpers/interface";
const $axios = axios().provide.axios;
import Swal from 'sweetalert2'

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

      return products.value
    } catch (error) {
      const message = error?.message || 'Something Wrong'
      Swal.fire({
        title: 'Error!',
        text: message,
        icon: 'error',
      })
      console.log(error, '<< ini error')
      throw error;
    }
  }

  return {
    products,
    fetchProduct
  }
});
