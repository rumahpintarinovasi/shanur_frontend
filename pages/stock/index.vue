<template>
  <div>
    <NuxtLayout>
      <div
        class="modal fade"
        id="modal-tambah"
        tabindex="-1"
        role="dialog"
        aria-labelledby="myModalLabel"
      >
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header bg-primary">
              <button
                type="button"
                class="close text-white"
                data-dismiss="modal"
                aria-label="Close"
              >
                <span aria-hidden="true">&times;</span>
              </button>
              <h4 class="modal-title" id="myModalLabel">Tambah Stok Barang</h4>
            </div>
            <div class="modal-body">
              <form class="form-horizontal">
                <div class="form-group">
                  <label
                    for="inputEmail3"
                    class="col-sm-3 control-label"
                    style="text-align: left !important"
                    >Nama Barang</label
                  >
                  <div class="col-sm-9">
                    <Dropdown
                          :options="products"
                          v-model="selectedProduct"
                          optionLabel="name"
                          style="padding: 10px 0;width:100%"
                          @change="handleChangeProductItem"
                          placeholder="Choose a product"
                          filter
                          showClear
                          :filterPlaceholder="'Search'"
                        />
                  </div>
                </div>
                <div class="form-group">
                  <label
                    for="inputPassword3"
                    class="col-sm-3 control-label"
                    style="text-align: left !important"
                    >Jumlah Masuk</label
                  >
                  <div class="col-sm-9">
                    <input
                      type="text"
                      class="form-control"
                      v-model="newStock.quantity"
                      id="inputPassword3"
                      placeholder="Masukan Jumlah Masuk"
                    />
                  </div>
                </div>
              </form>
            </div>
            <div class="modal-footer">
              <button
                type="button"
                class="btn btn-danger btn-sm waves-effect waves-light"
                data-dismiss="modal"
              >
                Batalkan
              </button>
              <button
                type="button"
                @click="handleSubmit"
                class="btn btn-success btn-sm waves-effect waves-light"
              >
                Simpan
              </button>
            </div>
          </div>
        </div>
      </div>
      <div
        class="modal fade"
        id="boostrapModal-1"
        tabindex="-1"
        role="dialog"
        aria-labelledby="myModalLabel"
      >
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header bg-primary">
              <button
                type="button"
                class="close text-white"
                data-dismiss="modal"
                aria-label="Close"
              >
                <span aria-hidden="true">&times;</span>
              </button>
              <h4 class="modal-title" id="myModalLabel">Edit Stok Barang</h4>
            </div>
            <div class="modal-body">
              <form class="form-horizontal">
                <div class="form-group">
                  <label
                    for="inputEmail3"
                    class="col-sm-3 control-label"
                    style="text-align: left !important"
                    >Nama Barang</label
                  >
                  <div class="col-sm-9">
                    <Dropdown
                      v-model="newStock.productId"
                      :options="products"
                      filter
                      optionLabel="name"
                      showClear
                      style="z-index: 99999;padding:8px 0; width:100%"
                      filterPlaceholder="Cari Barang"
                      placeholder="Pilih Barang"
                    />
                  </div>
                </div>
                <div class="form-group">
                  <label
                    for="inputPassword3"
                    class="col-sm-3 control-label"
                    style="text-align: left !important"
                    >Jumlah Masuk</label
                  >
                  <div class="col-sm-9">
                    <input
                      type="text"
                      class="form-control"
                      id="inputPassword3"
                      placeholder="Masukan Jumlah Masuk"
                    />
                  </div>
                </div>
              </form>
            </div>
            <div class="modal-footer">
              <button
                type="button"
                class="btn btn-danger btn-sm waves-effect waves-light"
                data-dismiss="modal"
              >
                Batalkan
              </button>
              <button
                type="button"
                class="btn btn-success btn-sm waves-effect waves-light"
              >
                Simpan
              </button>
            </div>
          </div>
        </div>
      </div>
      <div id="wrapper">
        <div class="main-content">
          <!-- /.row small-spacing two -->
          <div class="row small-spacing">
            <!-- Kartu Stok -->
            <div class="col-12">
              <div class="box-content">
                <div 
                  style="display: flex;justify-content: space-between;align-items: end;margin-bottom: 20px;"
                >
                  <h4 class="box-title">Kartu Stock</h4>
                
                <button
                  class="btn btn-info fa fa-pencil"
                  data-toggle="modal"
                  data-target="#modal-tambah"
                />
                </div>


                <button
                  class="btn btn-sm"
                  @click="showFilter = !showFilter"
                  style="color: black; margin-bottom: 10px"
                >
                  <i class="fa fa-filter"></i>
                  Filter
                </button>

                <div class="custom-filter" :class="{ show: showFilter }">
                  <div class="input-group" style="display: flex; gap: 5px">
                    <input
                      type="text"
                      class="form-control"
                      v-model="searchName"
                      placeholder="Cari Barang"
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
                </div>

                <div style="overflow-x: scroll">
                  <table
                    class="table table-striped margin-bottom-10 margin-top-10"
                  >
                    <thead>
                      <tr>
                        <th>Tanggal</th>
                        <th style="min-width: 100px">Kode</th>
                        <th
                          style="
                            max-width: 200px;
                            white-space: nowrap;
                            overflow: hidden;
                            text-overflow: ellipsis;
                          "
                        >
                          Nama Barang
                        </th>
                        <th style="min-width: 150px">Jumlah Masuk</th>
                        <th style="min-width: 150px">Jumlah Keluar</th>
                        <th style="min-width: 150px">Saldo Akhir</th>
                        <th style="min-width: 150px">Harga/pcs</th>
                        <th style="min-width: 150px">Total Nilai Masuk</th>
                        <th style="min-width: 150px">Total Nilai Keluar</th>
                        <th style="min-width: 150px">Total Nilai Stock</th>
                        <th>Aksi</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr v-for="item in stock">
                        <td>{{ item.date }}</td>
                        <td>{{ item.id }}</td>
                        <td
                          style="
                            max-width: 200px;
                            white-space: nowrap;
                            overflow: hidden;
                            text-overflow: ellipsis;
                          "
                          class="text-ellipsis"
                        >
                          {{ item.name }}
                        </td>
                        <td style="display: flex; gap: 10px">
                          <button
                            class="btn btn-info fa fa-pencil"
                            data-toggle="modal"
                            data-target="#boostrapModal-1"
                          />
                          <button class="btn btn-danger fa fa-trash" />
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
                <!-- <Pagination
                  :totalPages="totalPages"
                  @handleChangePage="handleChangePage"
                  :page="currentPages"
                  :size="10"
                /> -->
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
import type { Stock, NewStock, RequestPayload } from "../../helpers/interface";
import { useStockStore } from "~/store/stock";
import { useProductStore } from "~/store";
import { useToast } from "vue-toast-notification";
import "vue-toast-notification/dist/theme-sugar.css";

definePageMeta({
  layout: "dashboard",
});

const $toast = useToast();
const productStore = useProductStore();
const { fetchProduct } = productStore;

const stock = ref<Stock[]>([]);
const newStock = ref<NewStock>({
  productId: "",
  quantity: 0,
  price: 0,
});


const products = ref(null);

const totalPages = ref<Number>(1);
const currentPages = ref<Number>(1);
const totalData = ref<Number>(0);

const searchName = ref<string>("");
const selectedProduct = ref(null);

const showFilter = ref<boolean>(false);

const submitSearch = () => {
  handleFetchStock({
    whereConditions: searchName.value,
    page: 1,
    size: 10,
  });
};

const stockStore = useStockStore();
const { fetchAllStock, addStock } = stockStore;

const handleFetchStock = async (options: RequestPayload) => {
  const fetchingStock = await fetchAllStock(options);
  stock.value = fetchingStock?.data;
  totalData.value = fetchingStock?.meta?.totalData;
  totalPages.value = Math.ceil(Number(totalData.value) / 10);
};




const handleChangePage = (page: Number) => {
  currentPages.value = page;
  handleFetchStock({
    whereConditions: "",
    page: page,
    size: 10,
  });
};

const handleChangeProductItem = (value: Event) => {
  newStock.value.productId = value.value.id;
  newStock.value.price = value.value.price;

};

const handleSubmit = async () => {
  try {
    await addStock(newStock.value);
    $toast.open({
      message: "Berhasil menambahkan stok baru",
      type: "success",
      position: "top",
    });
    newStock.value = {
      productId: "",
      quantity: 0,
      price: 0,
    };
  } catch (error) {
    $toast.open({
      message: error?.response?.data?.message || "Something went wrong",
      type: "error",
      position: "top",
    });
  }
};

onMounted(async () => {
  await handleFetchStock({
    whereConditions: "",
    page: 1,
    size: 10,
  });

  const response = await fetchProduct();
  products.value = response.data;
});
</script>

<style>
p {
  margin: 0 !important;
}

.modal-footer {
  display: flex;
  flex-direction: column-reverse;
  gap: 16px;
}

.flex-custom {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
}

.modal-content {
  padding: 0 !important;
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

.content-list {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.p-dropdown-panel {
  z-index: 999999 !important;
  max-width: 350px;
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
