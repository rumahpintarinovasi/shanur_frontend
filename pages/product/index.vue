<template>
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
                <a
                  href="/product/tambah"
                  class="btn btn-sm"
                  style="color: black; margin-bottom: 10px"
                >
                  <i class="fa fa-plus"></i>
                  Buat Produk
                </a>
              </div>

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
                    <th>Total Nilai</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>AT0571</td>
                    <td>Buku Tulis Kiky 50gr</td>
                    <td>Box</td>
                    <td>Rp.50.000</td>
                    <td>Rp.300.000.000</td>
                  </tr>
                  <tr>
                    <td>AT0571</td>
                    <td>Buku Tulis Kiky 50gr</td>
                    <td>Box</td>
                    <td>Rp.50.000</td>
                    <td>Rp.300.000.000</td>
                  </tr>
                  <tr>
                    <td>AT0571</td>
                    <td>Buku Tulis Kiky 50gr</td>
                    <td>Box</td>
                    <td>Rp.50.000</td>
                    <td>Rp.300.000.000</td>
                  </tr>
                  <tr>
                    <td>AT0571</td>
                    <td>Buku Tulis Kiky 50gr</td>
                    <td>Box</td>
                    <td>Rp.50.000</td>
                    <td>Rp.300.000.000</td>
                  </tr>
                  <tr>
                    <td>AT0571</td>
                    <td>Buku Tulis Kiky 50gr</td>
                    <td>Box</td>
                    <td>Rp.50.000</td>
                    <td>Rp.300.000.000</td>
                  </tr>
                  <tr>
                    <td>AT0571</td>
                    <td>Buku Tulis Kiky 50gr</td>
                    <td>Box</td>
                    <td>Rp.50.000</td>
                    <td>Rp.300.000.000</td>
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
</template>

<script setup>
definePageMeta({
  layout: "dashboard",
});
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
