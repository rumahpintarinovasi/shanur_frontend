import { defineStore } from "pinia";
import axios from "~~/plugins/axios";
import type { Product, RequestPayload } from "../helpers/interface";
const $axios = axios().provide.axios;
import Swal from 'sweetalert2'

export const useProductStore = defineStore('product', () => {
  // State
  const products = ref([]);

  // Action
  const fetchProduct = async (options:RequestPayload = {}): Promise<Product[]> => {
    try {
      const { whereConditions } = options
      const { data } = await $axios({
        method: "get",
        url: "/product",
        params: {
          whereConditions: whereConditions || "",
        },
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
      throw error;
    }
  }

  const fetchOneProduct = async (id: string): Promise<Product> => {
    try {
      const { data } = await $axios({
        method: "get",
        url: `/product/${id}`,
      })

      return data.data
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

  const deleteProduct = async (id: string) => {
    try {
      const { data } = await $axios({
        method: "delete",
        url: `/product/${id}`,
      })

      return true;
    } catch (error) {
      throw error;
    }
  }
  
  const updateProduct = async (id: string, payload: any) => {
    try {
      const { data } = await $axios({
        method: "put",
        url: `/product/${id}`,
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
    addProduct,
    deleteProduct,
    updateProduct,
    fetchOneProduct
  }
});
