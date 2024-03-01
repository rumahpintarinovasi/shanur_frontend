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

              <!--  -->

              <table class="table table-striped margin-bottom-10 margin-top-10">
                <thead>
                  <tr>
                    <th>Kode</th>
                    <th
                      style="
                        max-width: 300px;
                        white-space: nowrap;
                        overflow: hidden;
                        text-overflow: ellipsis;
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
                    <td>{{ item.id }}</td>
                    <td
                      style="
                        max-width: 300px;
                        white-space: nowrap;
                        overflow: hidden;
                        text-overflow: ellipsis;
                      "
                      class="text-ellipsis"
                    >
                      {{ item.name }}
                    </td>
                    <td>{{ item.unit }}</td>
                    <td>{{ item.sellingPrice }}</td>
                    <td style="display: flex; gap: 10px">
                      <button 
                      class="btn btn-info fa fa-pencil" 
                      @click="router.push(`/product/edit/${item.id}`)"
                      />
                      <button class="btn btn-danger fa fa-trash" 
                      @click="confirmDelete(item.id)"
                      />
                    </td>
                  </tr>
                </tbody>
              </table>
              <Pagination />  
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
import { type Product } from '../../helpers/interface';
import { useProductStore } from '~/store/product'

import { useToast } from 'vue-toast-notification';
import "vue-toast-notification/dist/theme-sugar.css";

import {swal} from 'sweetalert2'

definePageMeta({
  layout: "dashboard",
});

const router = useRouter()

const product = ref<Product[]| []>([])

const productStore = useProductStore()
const { fetchProduct, deleteProduct } = productStore

const confirmDelete = (id: number) => {
  swal({
    title: 'Apakah Anda yakin?',
    text: "Anda tidak akan dapat mengembalikan ini!",
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Ya, hapus!',
    cancelButtonText: 'Batal'
  }).then((result) => {
    if (result.isConfirmed) {
      deleteProduct(id)
      swal(
        'Terhapus!',
        'Produk telah dihapus.',
        'success'
      )
    }
  })
}



onMounted(async () => {
  product.value = await fetchProduct()
})

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
