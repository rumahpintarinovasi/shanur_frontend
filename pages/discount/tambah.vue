<template>
  <div>
    <NuxtLayout>
      <div id="wrapper">
        <div class="main-content">
          <!-- /.row small-spacing two -->
          <div class="row small-spacing">
            <div class="col-lg-6 col-xs-12">
              <div class="box-content custom-height">
                <div class="flex-custom middle">
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
              </div>
            </div>

            <div class="col-lg-6 col-xs-12">
              <div class="box-content custom-height">
                <div class="flex-custom">
                  <h4 class="box-title">Pembuat</h4>
                  <div class="form-group">
                    <select class="form-control" style="width: 100%">
                      <option value="">Nama Admin</option>
                      <option value="1">Admin 1</option>
                      <option value="2">Admin 2</option>
                      <option value="3">Admin 3</option>
                    </select>
                  </div>
                </div>
              </div>
            </div>
            <!-- /.col-lg-6 col-xs-12 -->
          </div>

          <div class="row small-spacing">
            <!-- Kartu Stok -->
            <div class="col-lg-12 col-xs-12">
              <div class="box-content">
                <form class="form-horizontal">
                  <div class="form-group">
                    <label
                      for="inputNamaBarang"
                      class="col-sm-3 control-label"
                      style="text-align: left !important"
                      >Nama Barang</label
                    >
                    <div class="col-sm-9">
                        <!-- select from list product.name with value product.id -->
                        <select v-model="NewDiscount.ProductId" class="form-control" style="width: 100%">
                          <option v-for="product in products" :value="product.id">{{ product.name }}</option>
                        </select>
                    </div>
                  </div>
                  <!-- input harga -->
                  <div class="form-group">
                    <label
                      for="inputHarga"
                      class="col-sm-3 control-label"
                      style="text-align: left !important"
                      >Level Diskon</label
                    >
                    <div class="col-sm-9">
                      <input
                        type="number"
                        class="form-control"
                        id="inputHarga"
                        placeholder="Masukan Harga"
                        v-model="NewDiscount.level"
                      />
                    </div>
                  </div>
                  <div class="form-group">
                    <label
                      for="inputHarga"
                      class="col-sm-3 control-label"
                      style="text-align: left !important"
                      >Nilai Persentase</label
                    >
                    <div class="col-sm-9">
                      <input
                        type="number"
                        class="form-control"
                        id="inputHarga"
                        placeholder="Masukan Harga"
                        v-model="NewDiscount.discountPercentage"
                      />
                    </div>
                  </div>
                </form>
              </div>
              <!-- /.box-content -->
            </div>
          </div>

          <div class="row small-spacing">
            <div class="">
              <!-- button ajukan po (green) batalkan po (red) flex row but in mobile column-->
              <div class="flex-custom-responsive" style="margin-left: 10px">
                <button
                  @click="() => $router.back()"
                  type="button"
                  class="btn btn-danger"
                >
                  Batalkan
                </button>
                <button
                  type="button"
                  class="btn btn-success"
                  @click="handleSubmit"
                >
                  Simpan
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
import type { NewDiscount } from "../../helpers/interface";
import { useToast } from "vue-toast-notification";
import "vue-toast-notification/dist/theme-sugar.css";
import { useDiscountStore, useProductStore } from "~/store";

definePageMeta({
  layout: "dashboard",
});

const $toast = useToast();

const { addDiscount } = useDiscountStore();
const { fetchProduct } = useProductStore();
const products = ref([]);

const selectedProduct = ref(null);

const NewDiscount = ref<NewDiscount>({
  ProductId: "",
  level: 1,
  discountPercentage: 0,
});

const handleSubmit = async () => {
  try {
    await addDiscount(NewDiscount.value);
    $toast.open({
      message: "Berhasil menambahkan produk baru",
      type: "success",
      position: "top",
    });
    NewDiscount.value = {
      initPrice: 0,
      sellingPrice: 0,
      unit: "",
    };
  } catch (error) {
    $toast.open({
      message: error?.response?.data?.message,
      type: "error",
      position: "top",
      duration: 5000,
    });
  }
};

onMounted(async () => {
  const paramFetchProduct = {
    whereConditions: [],
  };
  const result = await fetchProduct(paramFetchProduct);
  products.value = result.data;
  console.log(products.value);
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
  height: 140px;
  display: flex;
  flex-direction: column;
  justify-content: center;
}

.form-control {
  width: 100%;
  box-sizing: border-box; /* Ensure padding and border are included in the width */
}

input {
  width: 100%;
}

.flex-custom-responsive {
  display: flex;
  flex-direction: row-reverse;
  gap: 10px;
  justify-content: flex-end;
}
</style>
