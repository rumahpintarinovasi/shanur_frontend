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
                    <h4 class="box-title">Kelola Diskon</h4>
                    <NuxtLink
                      to="/discount/tambah"
                      class="btn btn-sm"
                      style="color: black; margin-bottom: 10px"
                    >
                      <i class="fa fa-plus"></i>
                      Buat Diskon
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
                          Nama Produk
                        </th>
                        <th>Nilai Diskon</th>
                        <th>Level</th>
                        <th>Aksi</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr v-for="item in discount">
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
                          {{ item.discountId }}
                        </td>
                        <td>Rp. {{ item.discountPercentage }}</td>
                        <td>{{ item.level }}</td>
                        <td style="display: flex; gap: 10px; justify-content: center;">
                          <button
                            class="btn btn-info fa fa-pencil"
                            @click="router.push(`/discount/edit/${item.id}`)"
                          />
                          <button
                            class="btn btn-danger fa fa-trash"
                            @click="confirmDelete(item.id)"
                          />
                        </td>
                      </tr>
                    </tbody>
                  </table>
  
                  <!-- if discount empty -->
                  <div
                    v-if="discount.length === 0"
                    class="d-flex justify-content-center"
                    style="text-align: center;"
                  >
                    <h4 class="box-title">Tidak ada diskon</h4>
                  </div>
                  
  
                  <Pagination 
                    :page="1"
                    :size="10"
                    :totalPages="getTotalPages()"
                    @handleChangePage="() => {
                      // SHOW PAGE FROM PAGINATION COMPONENT
                      
                    }"
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
  
  import { type Discount } from "../../helpers/interface";
  import { useDiscountStore } from "~/store";
  
  import { useToast } from "vue-toast-notification";
  import "vue-toast-notification/dist/theme-sugar.css";
  
  import {Swal} from "sweetalert2";
  
  definePageMeta({
    layout: "dashboard",
  });
  
  const discount = ref<Discount[] | []>([]);
  
  const totalData = ref(0);
  
  const getTotalPages = () => {
    return Math.ceil(totalData.value / 10);
  };
  
  const searchName = ref("");
  
  const sellingPriceSearch = ref(null);
  
  const submitSellingPriceSearch = async () => {
    if (sellingPriceSearch.value === null || sellingPriceSearch.value === "") {
      const paramFetchdiscount = {
        whereConditions: [],
      };
      const result = await fetchAllDiscount(paramFetchdiscount);
      discount.value = result.data
      totalData.value = result.meta.totalData
    } else {
      const paramFetchdiscount = {
        whereConditions: [`{"sellingPrice" : "${sellingPriceSearch.value}"}`],
      };
      const result = await fetchAllDiscount(paramFetchdiscount);
      discount.value = result.data
      totalData.value = result.meta.totalData
    }
  };
  
  const submitSearch = async () => {
    if (searchName.value === "" || searchName.value === null) {
      const paramFetchdiscount = {
        whereConditions: [],
      };
      const result = await fetchAllDiscount(paramFetchdiscount);
      discount.value = result.data
      totalData.value = result.meta.totalData
    } else {
      const paramFetchdiscount = {
        whereConditions: [`{"name" : "${searchName.value}"}`],
      };
      const result = await fetchAllDiscount(paramFetchdiscount);
      discount.value = result.data
      totalData.value = result.meta.totalData
    }
  };
  
  const showFilter = ref(false);
  
  const router = useRouter();
  
  const discountStore = useDiscountStore();
  const { fetchAllDiscount, deleteDiscount } = discountStore;
  
  const confirmDelete = (id: number) => {
    Swal({
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
        deleteDiscount(id);
        Swal("Terhapus!", "Produk telah dihapus.", "success");
      }
    });
  };
  
  onMounted(async () => {
    const paramFetchdiscount = {
      whereConditions: [],
    };
    const result = await fetchAllDiscount(paramFetchdiscount);
    discount.value = result.data
    totalData.value = result.meta.totalData
    console.log(totalData.value)
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
  