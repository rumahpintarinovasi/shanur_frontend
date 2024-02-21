import { defineStore } from "pinia";
import axios from "~~/plugins/axios";
import type { Discount } from "../helpers/interface";
const $axios = axios().provide.axios;
import Swal from 'sweetalert2'

export const useProductStore = defineStore('product', () => {
  // State
  const discounts = ref([]);

  // Action
  const fetchAllDiscount = async (): Promise<Discount[]> => {
    try {
      const { data } = await $axios({
        method: "get",
        url: "/discount",
      })

      if (data.data) {
        discounts.value = data.data
      }

      return discounts.value
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

  const fetchOneDiscount = async (id: string): Promise<Discount> => {
    try {
      const { data } = await $axios({
        method: "get",
        url: `/discount/${id}`,
      })

      return data.data
    } catch (error) {
      throw error;
    }
  }

  const addDiscount = async (payload: any) => {
    try {
      const { data } = await $axios({
        method: "post",
        url: "/discount",
        data: payload
      })

      return true;
    } catch (error) {
      throw error;
    }
  }

  const updateDiscount = async (id: string, payload: any) => {
    try {
      const { data } = await $axios({
        method: "put",
        url: `/discount/${id}`,
        data: payload
      })

      return true;
    } catch (error) {
      throw error;
    }
  }

  const deleteDiscount = async (id: string) => {
    try {
      const { data } = await $axios({
        method: "delete",
        url: `/discount/${id}`,
      })

      return true;
    } catch (error) {
      throw error;
    }
  }

  return {
    discounts,
    fetchAllDiscount,
    fetchOneDiscount,
    addDiscount,
    updateDiscount,
    deleteDiscount,
  }
});
