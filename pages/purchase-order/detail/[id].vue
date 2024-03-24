<template>
    <div>
      <p>{{ storeType }}</p>
      <NuxtLayout>
        <InvoiceForm :product="[]" :invoiceForm="invoiceDetail" type="invoices" :action="storeType === constant.storeType.branch ? 'edit' : ''" />
      </NuxtLayout>
    </div>
  </template>
  
  
  <script lang="ts" setup >
    import type { Invoice } from "~/helpers/interface";
    import { useInvoicesStore } from '~/store'
    import { constant } from '~/helpers'
  
    const { fetchInvoiceDetail }  = useInvoicesStore()
    const storeType:string = localStorage.getItem("storeType") || "";
  
    const route = useRoute()
    const id:string = route.params?.id ? route.params.id as string : ''
    const invoiceDetail = ref<Invoice>({
      invoiceDate: '',
      price : 0,
      totalItem : 0,
      type : ''
    })
  
    onMounted(async () => {
      invoiceDetail.value = await fetchInvoiceDetail(id)
    })
  
    // method
  
    definePageMeta({
      layout: "dashboard",
    });
  </script>