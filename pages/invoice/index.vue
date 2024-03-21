<template>
  <div>
    <NuxtLayout>
    <div id="wrapper">
      <div class="main-content">
        <!-- /.row small-spacing two -->

        <div class="row small-spacing">
          <!-- Kartu Stok -->
          <div class="col-12">
            <div class="box-content">
              <div class="flex-custom">
                <h4 class="box-title">Riwayat invoices</h4>
                <NuxtLink
                  to="/invoice/tambah"
                  class="btn btn-sm"
                  style="color: black; margin-bottom: 10px"
                >
                  <i class="fa fa-plus"></i>

                  Buat Invoice
                </NuxtLink>
              </div>

              <button
                  class="btn btn-sm"
                  @click="showFilter = !showFilter"
                  style="color: black; margin-bottom: 10px"
                >
                  <i class="fa fa-filter"></i>
                  Filter
                </button>

                <!-- contain filter -->
                <div class="custom-filter" :class="{ show: showFilter }">
                  <!-- search name input and button search -->
                  <div class="input-group" style="display: flex; gap: 5px">
                    <input
                      type="text"
                      class="form-control"
                      v-model="searchName"
                      placeholder="Cari INV Number"
                      style="max-width: 180px; max-height: 30px"
                    />
                    <div class="input-group-append">
                      <button
                        class="btn btn-info"
                        style="padding: 1px 12px; height: 30px"
                        @click="submitSearch"
                      >
                        <i class="fa fa-search"></i>
                      </button>
                    </div>
                  </div>
                  <div class="input-group" style="display: flex; gap: 5px">
                    <input
                      type="text"
                      class="form-control"
                      v-model="totalPrice"
                      placeholder="Cari Total Harga"
                      style="max-width: 180px; max-height: 30px"
                    />
                    <div class="input-group-append">
                      <button
                        class="btn btn-info"
                        style="padding: 1px 12px; height: 30px"
                        @click="submitTotalPriceSearch"
                      >
                        <i class="fa fa-search"></i>
                      </button>
                    </div>
                  </div>
                  <div class="card flex justify-content-center">
                    <Dropdown
                      v-model="selectedUniqData"
                      :options="unitData"
                      optionLabel="name"
                      placeholder="Pilih Tipe Invoice"
                      class="w-full md:w-14rem"
                    />
                  </div>
                  <!-- clear filter -->
                  <button
                    class="btn btn-sm"
                    @click="selectedUniqData = null"
                    style="color: black; margin-bottom: 10px"
                  >
                    <i class="fa fa-times"></i>
                    Clear Filter
                  </button>
                </div>

              <table class="table table-striped margin-bottom-10 margin-top-10">
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
                    <th>Action</th>
                  </tr>
                </thead>
                <tbody>
                  <tr v-for="(invoice, index) in invoices" :key="index">
                    <td>
                      {{ $moment(invoice.invoiceDate).format("DD MMMM YYYY") }}
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
                    <td>
                      <NuxtLink :to="`/invoice/detail/${invoice.id}`" class="text-primary" >
                        Detail
                      </NuxtLink>
                      <!-- <a :href="`/invoice/detail/${invoice.id}`" class="text-primary">Detail</a> -->
                    </td>
                  </tr>
                </tbody>
              </table>

              <Pagination
                  :totalPages="totalPages"
                  @handleChangePage="handleChangePage"
                  :page="currentPages"
                />
            </div>
            <!-- /.box-content -->
          </div>
        </div>

        <Footer />
      </div>
    </div>
  </NuxtLayout>
  </div>
</template>

<script lang="ts" setup>
import Dropdown from "primevue/dropdown";
import type { Invoice, RequestPayload } from "../../helpers/interface";
import { useInvoicesStore } from "~/store/invoices";
import { formatCurrency } from "../../helpers/utils";
import moment from "~~/plugins/moment";
const $moment = moment().provide.moment;
definePageMeta({
  layout: "dashboard",
});
const invoices = ref<Invoice[] | []>([]);
  const totalPages = ref<Number>(1);
const currentPages = ref<Number>(1);
const totalData = ref<Number>(0)

const invoicesStore = useInvoicesStore();
const { fetchInvoices } = invoicesStore;

const selectedUniqData = ref(null);
const unitData = [
  { name: "Cashier", value: "Cashier" },
  { name: "Purchase Order", value: "Purchase Order" },
];

watch(selectedUniqData, async () => {
  if (selectedUniqData.value === null) {
    const paramFetchInvoice = {
      whereConditions: [],
    };
    const result = await fetchInvoices(paramFetchInvoice);
    invoices.value = result.data
    totalData.value = result.meta.totalData
  } else {
    const paramFetchInvoice = {
      whereConditions: [`{"type" : "${selectedUniqData.value?.value}"}`],
    };
    const result = await fetchInvoices(paramFetchInvoice);
    invoices.value = result.data
    totalData.value = result.meta.totalData
  }
});


const showFilter = ref(false);
const searchName = ref("");
const totalPrice = ref("");

const submitSearch = () => {
  handleFetchInvoices({
    whereConditions: `invoiceNumber=${searchName.value}`,
    page: 1,
    size: 10,
  });
};

const submitTotalPriceSearch = () => {
  handleFetchInvoices({
    whereConditions: `price=${totalPrice.value}`,
    page: 1,
    size: 10,
  });
};

const handleFetchInvoices = async (options: RequestPayload) => {
  const fetchingUser = await fetchInvoices(options);
  console.log(fetchingUser)
  invoices.value = fetchingUser.data
  totalData.value = fetchingUser.meta.totalData
  totalPages.value = Math.ceil(Number(totalData.value) / 10);
};

const handleChangePage = (page: Number) => {
  currentPages.value = page;
  handleFetchInvoices({ whereConditions: '', page: Number(page), size: 10 });
};

onMounted(async () => {
  await handleFetchInvoices({ 
    page: Number(currentPages.value),
    size: 10,
    whereConditions: ''
   });
});

// Method
</script>

<style>
p {
  margin: 0 !important;
}

.flex-custom {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
}

@media (max-width: 516px) {
  .flex-custom {
    flex-direction: column;
    justify-content: start;
    align-items: start;
    gap: 14px;
  }
}
.flex-custom h4.box-title {
  margin: 0;
}


.custom-filter {
  display: flex !important;
  width: 100%;
  flex-direction: row;
  gap: 10px;
  transition: all 0.24s;
  transform: scaleY(0);
}

.custom-filter.show {
  transform: scaleY(1);
  transition: all 0.24s;
  display: flex !important;
  display: flex;
  width: 100%;
  flex-direction: row;
}

@media (max-width: 516px) {
  .custom-filter {
    flex-direction: row;
    gap: 10px;
  }
}


.content-list {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.content-list .list {
  display: flex;
  padding: 8px 6px;
  background: #eee;
  justify-content: space-between;
  align-items: center;
}

.content-list .list .right {
  color: red;
}

.custom-laba {
  padding: 16px;
  border-radius: 6px;
  font-size: 28px;
  text-align: center;
}

.content-list-two {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.content-list-two .list {
  display: flex;
  justify-content: space-between;
  align-items: center;
  gap: 6px;
}

.content-list-two .list .left {
  background-color: #eee;
  padding: 8px 6px;
  border-radius: 6px;
  width: 100%;
}

.content-list-two .list .right {
  background: rgb(224, 176, 86);
  padding: 6px;
  border-radius: 8px 6px;
  min-width: max-content;
  max-width: max-content;
}
</style>
