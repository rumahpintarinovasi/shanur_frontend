<template>
  <div>
    <NuxtLayout>
      <div id="wrapper">
        <div class="main-content">
          <!-- /.row small-spacing two -->
          <div class="row small-spacing">
            <div class="col-lg-6 col-xs-12">
              <div class="box-content">
                <div class="flex-custom">
                  <h4 class="box-title">Tanggal</h4>
                  <div class="input-group" style="width: 100%">
                    <input
                      type="date"
                      class="form-control"
                      placeholder="mm/dd/yyyy"
                      id="datepicker"
                      style="width: 100%"
                    />
                  </div>
                </div>
                <div class="flex-custom">
                  <h4 class="box-title">Nama Kasir</h4>
                  <!-- select -->
                  <div class="form-group">
                    <select class="form-control" style="width: 100%">
                      <option value="">Nama Kasir</option>
                      <option value="1">Kasir 1</option>
                      <option value="2">Kasir 2</option>
                      <option value="3">Kasir 3</option>
                    </select>
                  </div>
                </div>
                <!-- customer (Select) -->
                <div class="flex-custom">
                  <h4 class="box-title">Customer</h4>
                  <div class="form-group">
                    <select class="form-control" style="width: 100%">
                      <option value="">Nama Customer</option>
                      <option value="1">001 - UMUM</option>
                      <option value="2">Customer 2</option>
                      <option value="3">Customer 3</option>
                    </select>
                  </div>
                </div>
              </div>
            </div>

            <!-- Faktur Penjualan -->
            <div class="col-lg-6 col-xs-12">
              <div class="box-content">
                <div class="flex-custom">
                  <h4 class="box-title">Nomor Invoice</h4>
                  <div class="form-group">
                    <input
                      type="text"
                      class="form-control"
                      placeholder="Nomor Invoice"
                      style="width: 100%"
                    />
                  </div>
                </div>
                <div class="flex-custom">
                  <h4 class="box-title">Total Belanja</h4>
                  <h2>
                    {{ formatCurrency(totalPrice) }}
                  </h2>
                </div>
              </div>
            </div>
            <!-- /.col-lg-6 col-xs-12 -->
          </div>

          <div class="row small-spacing">
            <!-- Kartu Stok -->
            <div class="col-lg-12 col-xs-12">
              <div class="box-content">
                <table
                  class="table table-striped margin-bottom-10 margin-top-10"
                >
                  <thead>
                    <tr>
                      <th>Date</th>
                      <th>Inv Number</th>
                      <th
                        style="
                          max-width: 300px;
                          white-space: nowrap;
                          overflow: hidden;
                          text-overflow: ellipsis;
                        "
                      >
                        Type
                      </th>
                      <th>Quantity</th>
                      <th>Total Price</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr v-for="invoice in invoices">
                      <td>
                        {{
                          $moment(invoice.invoiceDate).format("DD MMMM YYYY")
                        }}
                      </td>
                      <td>{{ invoice.invoiceNumber || "-" }}</td>
                      <td
                        style="
                          max-width: 300px;
                          white-space: nowrap;
                          overflow: hidden;
                          text-overflow: ellipsis;
                        "
                        class="text-ellipsis"
                      >
                        {{ invoice.type }}
                      </td>
                      <td>{{ invoice.totalItem }}</td>
                      <td>{{ formatCurrency(Number(invoice.price)) }}</td>
                      <!-- <td>{{ invoice.price}}</td> -->
                    </tr>

                    <tr v-if="isAddNewItem">
                      <td>
                        <!-- <input class="form-control" placeholder="Nama Item"  /> -->
                        <select
                          @change="(e) => handleChangeProductItem(e)"
                          class="form-select form-control"
                          placeholder="Item"
                        >
                          <option selected disabled>
                            Open this select menu
                          </option>
                          <option
                            v-for="(product, index) in products"
                            :value="`${product.id}|${index}|${product.name}`"
                            :key="index"
                          >
                            {{ product.name }}
                          </option>
                        </select>
                      </td>
                      <td>
                        <input
                          class="form-control"
                          placeholder="Harga"
                          :value="newInvoiceItem.price"
                          disabled
                        />
                      </td>
                      <td>
                        <input
                          @change="(e) => handleChangeQantity(e)"
                          class="form-control"
                          placeholder="Jumlah"
                          type="number"
                          min="0"
                        />
                      </td>
                      <td>
                        <input
                          class="form-control"
                          placeholder="Total"
                          disabled
                          :value="newInvoiceItem.total"
                        />
                      </td>

                      <td class="gap-2" style="display: flex; gap: 10px">
                        <button
                          @click="handleSaveInvoiceItems"
                          class="btn btn-primary fa fa-save"
                        ></button>
                        <button
                          @click="() => (isAddNewItem = false)"
                          class="btn btn-warning fa fa-close"
                        ></button>
                      </td>
                    </tr>
                  </tbody>
                </table>
                <button @click="() => isAddNewItem = true" class="btn">Add Item</button>
              </div>
              <!-- /.box-content -->
            </div>
          </div>

          <div class="row small-spacing">
            <!-- Kartu Stok -->
            <div class="col-lg-4 col-xs-12">
              <div class="box-content">
                <div class="flex-custom">
                  <h4 class="box-title">Subtotal</h4>
                  <div class="input-group" style="width: 100%">
                    <input
                      type="text"
                      class="form-control"
                      placeholder="Subtotal"
                      value="Rp 100.000"
                      style="width: 100%"
                    />
                  </div>
                </div>
                <div class="flex-custom">
                  <h4 class="box-title">Diskon</h4>
                  
                    <button
                      class="btn btn-primary"
                      @click="handleCheckDiscount"
                    >
                      Periksa
                    </button>
                </div>
            
                <div class="flex-custom">
                  <h4 class="box-title">Total</h4>
                  <div class="form-group">
                    <input
                      type="text"
                      class="form-control"
                      placeholder="Total"
                      value="Rp 100.000"
                      style="width: 100%"
                    />
                  </div>
                </div>
              </div>
            </div>
            <div class="col-lg-4 col-xs-12">
              <div class="box-content">
                <div class="flex-custom">
                  <h4 class="box-title">Pembayaran</h4>
                  <div class="input-group" style="width: 100%">
                    <!-- select -->
                    <select v-model="paymentMethod"  class="form-control" style="width: 100%">
                      <option value="" selected disabled>Pilih Pembayaran</option>
                      <option value="Cash">Cash</option>
                      <option value="Transfer">Transfer</option>
                    </select>
                  </div>
                </div>
                <div class="flex-custom">
                  <h4 class="box-title">Cash</h4>
                  <!-- select -->
                  <div class="form-group">
                    <input
                      type="text"
                      class="form-control"
                      placeholder="Cash"
                      value="Rp 100.000"
                      style="width: 100%"
                    />
                  </div>
                </div>
                <!-- customer (Select) -->
                <div class="flex-custom">
                  <h4 class="box-title">Change</h4>
                  <div class="form-group">
                    <input
                      type="text"
                      class="form-control"
                      placeholder="Change"
                      value="Rp 0"
                      style="width: 100%"
                    />
                  </div>
                </div>
              </div>
            </div>

            <div class="col-lg-4 col-xs-12">
              <div class="flex-custom-responsive">
                <button type="button" class="btn btn-danger">
                  Batalkan Nota
                </button>
                <button type="button" class="btn btn-success" @click="submitTransaction">
                  Proses Pembayaran
                </button>
              </div>
            </div>
          </div>

          <Footer />
        </div>
      </div>
    </NuxtLayout>
  </div>
</template>

<script setup lang="ts">
definePageMeta({
  layout: "dashboard",
});

import type { Product, NewInvoice, InputFileEvent, InvoiceItem, Invoice } from "../../helpers/interface";
import { useProductStore, useInvoicesStore } from '~/store'
import { useCashierStore } from "~/store/cashier";
import { formatCurrency } from "../../helpers/utils";
import moment from "~~/plugins/moment";
import Swal from "sweetalert2";
import { onMounted } from "vue";
const $moment = moment().provide.moment;

const invoices = ref<Invoice[] | []>([]);

const { addInvoices  } = useInvoicesStore()
const productStore =  useProductStore()
const { fetchProduct } = productStore
interface NewInvoiceItem extends InvoiceItem {
  total : number
}
const paymentMethod = ref<string>("Cash");

const {createTransaction, checkDiscount } = useCashierStore()

const products = ref<Product[]>()

const invoiceForm = ref<NewInvoice>({
  invoiceDate: "",
  invoiceItems: [],
});
const newInvoiceItem = ref<NewInvoiceItem>({
  productId: '',
  quantity: 0,
  price: 0,
  total : 0
})
const isAddNewItem = ref<boolean>(false)

const totalPrice = computed(() => {
  let total = 0
  invoices.value.forEach(invoice => {
    total += Number(invoice.price)
  })  
  return total
})

const invoicesStore = useInvoicesStore();
const { fetchInvoices } = invoicesStore;

const handleChangeProductItem = (value: Event) => {
    const el = value as InputFileEvent
    const rawValue:string = el.target.value
    const rawValueArr: string[] = rawValue.split('|')
    const productId:string = rawValueArr[0]
    const index:number = Number(rawValueArr[1])
    const productName:string = rawValueArr[2]
    newInvoiceItem.value.productId = productId
    newInvoiceItem.value.price = products.value? products.value[index].sellingPrice : 0
    newInvoiceItem.value.productName = productName
}

const handleChangeQantity = (value:Event) =>{
  const el = value as InputFileEvent
  newInvoiceItem.value.quantity = Number(el.target.value)
  newInvoiceItem.value.total = newInvoiceItem.value.price * newInvoiceItem.value.quantity
}

const handleChangeInvoiceForm = (e: Event) => {
  const el = e as InputFileEvent
  const { value , name } = el.target
  
  switch (name) {
    case 'invoiceDate':
      invoiceForm.value.invoiceDate =  value
      break;
  
    default:
      break;
  }

}

const handleSaveInvoiceItems = async () => {
  const newItem : InvoiceItem = {
    productId : newInvoiceItem.value.productId,
    quantity : newInvoiceItem.value.quantity,
    price : newInvoiceItem.value.price,
    productName: newInvoiceItem.value.productName
  } 

  invoiceForm.value.invoiceItems?.push(newItem)
  newInvoiceItem.value = {
    productId: '',
    quantity: 0,
    price: 0,
    total: 0
  }
  invoiceForm.value.invoiceItems?.forEach(item => {
    delete item.productName
  })

  const newInvoices = {
    type : 'Cashier',
    status: 'Accepted',
    invoiceDate: invoiceForm.value.invoiceDate,
    invoiceItems: invoiceForm.value.invoiceItems,
  }

  await addInvoices(newInvoices)
}


const submitTransaction = async () => {
  // confirm first
  const confirm = await Swal.fire({
    title: "Apakah anda yakin?",
    text: "Anda tidak dapat mengembalikan transaksi ini",
    icon: "warning",
    showCancelButton: true,
    confirmButtonColor: "#3085d6",
    cancelButtonColor: "#d33",
    confirmButtonText: "Ya, Proses!",
    cancelButtonText: "Batal",
  });

  if (confirm.isConfirmed) {

    const dataItems = invoices.value.map(invoice => {
      return {
        productId: invoice.id,
        quantity: invoice.totalItem,
        price: invoice.price
      }
    })

    const newTransaction = {
      items: dataItems,
      memberId: '',
      cashierId: '',
      paymentMethod: paymentMethod.value,
    };

    // 

    const response = await createTransaction(newTransaction);
    if (response) {
      await Swal.fire("Berhasil!", "Transaksi berhasil", "success");
      invoiceForm.value.invoiceItems = [];
    } else {
      await Swal.fire("Gagal!", "Transaksi gagal", "error");
    }
    
  }


}

const handleCheckDiscount = async () => {
  const response = await checkDiscount(invoices.value)
  if(response){
    await Swal.fire("Berhasil!", "Diskon berhasil", "success");
  }else{
    await Swal.fire("Gagal!", "Diskon gagal", "error");
  }
}

onMounted(async () => {
  const paramsFetchInvoices = {
    whereConditions : [`{"type" : "Cashier" }`]
  }
  invoices.value = await fetchInvoices(paramsFetchInvoices);
  const result = await fetchProduct()
  products.value = result.data
});
</script>

<style>
.flex-custom {
  display: flex;
  justify-content: space-between;
  align-items: center;
  gap: 3em;
  margin-bottom: 2em;
}

.flex-custom .box-title {
  margin-bottom: 0 !important;
  min-width: max-content;
  max-width: max-content;
}

.flex-custom .form-group {
  flex: 1;
  margin: 0 !important;
}

.custom-height {
  height: 185px;
  display: flex;
  flex-direction: column;
  justify-content: center;
}

.form-control {
  width: 100%;
  box-sizing: border-box; /* Ensure padding and border are included in the width */
}

.custom-height {
  height: 185px;
}

input {
  width: 100%;
}

.flex-custom-responsive {
  display: flex;
  flex-direction: column;
  max-width: 300px;
  gap: 1.5em;
  justify-content: space-between;
}
</style>
