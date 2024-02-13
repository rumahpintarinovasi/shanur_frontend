<template>
    <NuxtLayout>
      <InvoiceForm :product="[]" :invoiceForm="invoiceDetail" type="invoices" action="detail" />
    </NuxtLayout>
</template>


<script lang="ts" setup >
  import type { NewInvoice, Product, InputFileEvent, InvoiceItem, Invoice } from "~/helpers/interface";
  import { useInvoicesStore } from '~/store'

  const { fetchInvoiceDetail }  = useInvoicesStore()

  const route = useRoute()
  console.log(route.params.id)
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