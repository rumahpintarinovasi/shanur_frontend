<template>
  <div>
  <NuxtLayout>
    <InvoiceForm type="purchaseOrder" action="edit" :product="products" :invoiceForm="invoiceForm" :onHandleSave="handleSave" />
  </NuxtLayout>
  </div>
</template>

<script lang="ts" setup>
definePageMeta({
  layout: "dashboard",
});
import { useProductStore, useInvoicesStore } from '~/store'
import type { NewInvoice, Product, InputFileEvent, InvoiceItem, Invoice } from "../../helpers/interface";
import Swal from 'sweetalert2';
const { fetchProduct } = useProductStore()
const { addInvoices  } = useInvoicesStore()

const products = ref<Product[]>()
  const invoiceForm = ref<Invoice>({
    invoiceDate: '',
    invoiceItems: [],
    price: 0,
    totalItem: 0,
    type: ''
});

onMounted(async () => {
  products.value = await fetchProduct()
})

// Method
const handleSave = async (payload:Invoice) => {
  payload.status = 'Requested'

  delete payload.price
  delete payload.totalItem

  payload.invoiceItems?.forEach(item => {
    delete item.productName
  })
  console.log(payload, '<< ini payload')

  await addInvoices(payload)

  Swal.fire({
    icon : 'success',
    text : "Success Create New Purchase Order"
  })
}

// 
</script>
