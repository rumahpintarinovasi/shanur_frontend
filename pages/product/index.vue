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
                  <h4 class="box-title">Produk Terdaftar</h4>
                  <NuxtLink
                    to="/product/tambah"
                    class="btn btn-sm"
                    style="color: black; margin-bottom: 10px"
                  >
                    <i class="fa fa-plus"></i>
                    Buat Produk
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
                      placeholder="Cari Nama Produk"
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
                      v-model="initPriceSearch"
                      placeholder="Cari  Harga Awal"
                      style="max-width: 180px; max-height: 30px"
                    />
                    <div class="input-group-append">
                      <button
                        class="btn btn-info"
                        style="padding: 1px 12px; height: 30px"
                        @click="submitInitPriceSearch"
                      >
                        <i class="fa fa-search"></i>
                      </button>
                    </div>
                  </div>
                  <div class="input-group" style="display: flex; gap: 5px">
                    <input
                      type="text"
                      class="form-control"
                      v-model="sellingPriceSearch"
                      placeholder="Cari  Harga Jual"
                      style="max-width: 180px; max-height: 30px"
                    />
                    <div class="input-group-append">
                      <button
                        class="btn btn-info"
                        style="padding: 1px 12px; height: 30px"
                        @click="submitSellingPriceSearch"
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
                      placeholder="Pilih Satuan"
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

                <table
                  class="table table-striped margin-bottom-10 margin-top-10"
                >
                  <thead>
                    <tr>
                      <th
                        style="
                          max-width: 300px;
                          white-space: nowrap;
                          overflow: hidden;
                          text-overflow: ellipsis;
                          width:300px;
                          text-align: left;
                        "
                      >
                        Nama Barang
                      </th>
                      <th>Unit</th>
                      <th>Harga</th>
                      <th>Aksi</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr v-for="item in product">
                      <td
                        style="
                          max-width: 300px;
                          white-space: nowrap;
                          overflow: hidden;
                          text-overflow: ellipsis;
                          width:300px;
                          text-align: left;
                        "
                        class="text-ellipsis"
                      >
                        {{ item.name }}
                      </td>
                      <td>{{ item.unit }}</td>
                      <td>Rp. {{ item.sellingPrice }}</td>
                      <td style="display: flex; gap: 10px; justify-content: center;">
                        <button
                          class="btn btn-info fa fa-pencil"
                          @click="router.push(`/product/edit/${item.id}`)"
                        />
                        <button
                          class="btn btn-danger fa fa-trash"
                          @click="confirmDelete(item.id)"
                        />
                      </td>
                    </tr>
                  </tbody>
                </table>

                <!-- if product empty -->
                <div
                  v-if="product.length === 0"
                  class="d-flex justify-content-center"
                  style="text-align: center;"
                >
                  <h4 class="box-title">Produk Kosong</h4>
                </div>
                

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

import type { Product, RequestPayload } from "../../helpers/interface";
import { useProductStore } from "~/store/product";

import { useToast } from "vue-toast-notification";
import "vue-toast-notification/dist/theme-sugar.css";

import { swal } from "sweetalert2";

definePageMeta({
  layout: "dashboard",
});

const product = ref<Product[] | []>([]);

const totalData = ref<Number>(0)
const totalPages = ref<Number>(1);
const currentPages = ref<Number>(1);


const selectedUniqData = ref(null);
const unitData = ref([
  { name: "Dus", code: "dus" },
  { name: "Sak", code: "sak" },
  { name: "Box", code: "box" },
  { name: "Pcs", code: "pcs"}
]);

// if selecedUniqData is null, then fetch all product and detec chanage
watch(selectedUniqData, async () => {
  if (selectedUniqData.value === null) {
    const paramFetchProduct = {
      whereConditions: [],
    };
    const result = await fetchProduct(paramFetchProduct);
    product.value = result.data
    totalData.value = result.meta.totalData
  } else {
    const paramFetchProduct = {
      whereConditions: [`{"unit" : "${selectedUniqData.value?.code}"}`],
    };
    const result = await fetchProduct(paramFetchProduct);
    product.value = result.data
    totalData.value = result.meta.totalData
  }
});


const searchName = ref("");

const initPriceSearch = ref(null);

const handleFetchProduct = async (options: RequestPayload) => {
  const fetchingProduct = await fetchProduct(options);
  product.value = fetchingProduct.data
  totalData.value = fetchingProduct.meta.totalData
  totalPages.value = Math.ceil(Number(totalData.value) / 10);
};

const submitInitPriceSearch = async () => {
  if (initPriceSearch.value === null || initPriceSearch.value === "") {
    await handleFetchProduct({ whereConditions: "", page: 1, size: 10 });
  } else {
    const paramFetchProduct = {
      whereConditions: [`{"initPrice" : "${initPriceSearch.value}"}`],
    };
    await handleFetchProduct({
      whereConditions: paramFetchProduct,
      page:1,
      size:10
    })
  }
};

const sellingPriceSearch = ref(null);

const submitSellingPriceSearch = async () => {
  if (sellingPriceSearch.value === null || sellingPriceSearch.value === "") {
    await handleFetchProduct({ whereConditions: "", page: 1, size: 10 });
  } else {
    const paramFetchProduct = {
      whereConditions: [`{"sellingPrice" : "${sellingPriceSearch.value}"}`],
    };
    await handleFetchProduct({
      whereConditions: paramFetchProduct,
      page:1,
      size:10
    })
  }
};

const submitSearch = async () => {
  if (searchName.value === "" || searchName.value === null) {
    await handleFetchProduct({ whereConditions: "", page: 1, size: 10 });
  } else {
    const paramFetchProduct = {
      whereConditions: [`{"name" : "${searchName.value}"}`],
    };
    await handleFetchProduct({
      whereConditions: paramFetchProduct,
      page:1,
      size:10
    });
  }
};

const showFilter = ref(false);

const router = useRouter();

const productStore = useProductStore();
const { fetchProduct, deleteProduct } = productStore;

const confirmDelete = (id: number) => {
  swal({
    title: "Apakah Anda yakin?",
    text: "Anda tidak akan dapat mengembalikan ini!",
    icon: "warning",
    showCancelButton: true,
    confirmButtonColor: "#3085d6",
    cancelButtonColor: "#d33",
    confirmButtonText: "Ya, hapus!",
    cancelButtonText: "Batal",
  }).then((result) => {
    if (result.isConfirmed) {
      deleteProduct(id);
      swal("Terhapus!", "Produk telah dihapus.", "success");
    }
  });
};


const handleChangePage = async (index: number) => {
  currentPages.value = index;
  await handleFetchProduct({ whereConditions: "", page: index, size: 10 });
};

onMounted(async () => {
  await handleFetchProduct({ whereConditions: "", page: 1, size: 10 });

});
</script>

<style scoped>
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
  gap: 30px;
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
