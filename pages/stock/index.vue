<template>
  <!-- Modal -->
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
              <label for="inputEmail3" class="col-sm-3 control-label" style="text-align:left!important;"
                >Nama Barang</label
              >
              <div class="col-sm-9">
                <input
                  type="text"
                  class="form-control"
                  id="inputEmail3"
                  placeholder="Ketik Nama Barang"
                />
              </div>
            </div>
            <div class="form-group">
              <label for="inputPassword3" class="col-sm-3 control-label" style="text-align:left!important;"
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
  <NuxtLayout>
    <div id="wrapper">
      <div class="main-content">
        <!-- /.row small-spacing two -->

        <div class="row small-spacing">
          <!-- Kartu Stok -->
          <div class="col-12">
            <div class="box-content">
              <h4 class="box-title">Kartu Stock</h4>
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
                    <tr>
                      <td>02/05/2023</td>
                      <td>AT0571</td>
                      <td
                        style="
                          max-width: 200px;
                          white-space: nowrap;
                          overflow: hidden;
                          text-overflow: ellipsis;
                        "
                        class="text-ellipsis"
                      >
                        CV. Amidis Waterindo
                      </td>
                      <td>100 Box</td>
                      <td>90 Box</td>
                      <td>10 Box</td>
                      <td>Rp.5000</td>
                      <td>Rp.500000</td>
                      <td>Rp.450000</td>
                      <td>Rp.50000</td>
                      <td>
                        <a
                          href="#"
                          class="text-primary"
                          data-toggle="modal"
                          data-target="#boostrapModal-1"
                          >Edit</a
                        >
                      </td>
                    </tr>
                    <tr>
                      <td>02/05/2023</td>
                      <td>AT0571</td>
                      <td
                        style="
                          max-width: 200px;
                          white-space: nowrap;
                          overflow: hidden;
                          text-overflow: ellipsis;
                        "
                        class="text-ellipsis"
                      >
                        CV. Amidis Waterindo
                      </td>
                      <td>100 Box</td>
                      <td>90 Box</td>
                      <td>10 Box</td>
                      <td>Rp.5000</td>
                      <td>Rp.500000</td>
                      <td>Rp.450000</td>
                      <td>Rp.50000</td>
                      <td>
                        <a
                          href="#"
                          class="text-primary"
                          data-toggle="modal"
                          data-target="#boostrapModal-1"
                          >Edit</a
                        >
                      </td>
                    </tr>
                    <tr>
                      <td>02/05/2023</td>
                      <td>AT0571</td>
                      <td
                        style="
                          max-width: 200px;
                          white-space: nowrap;
                          overflow: hidden;
                          text-overflow: ellipsis;
                        "
                        class="text-ellipsis"
                      >
                        CV. Amidis Waterindo
                      </td>
                      <td>100 Box</td>
                      <td>90 Box</td>
                      <td>10 Box</td>
                      <td>Rp.5000</td>
                      <td>Rp.500000</td>
                      <td>Rp.450000</td>
                      <td>Rp.50000</td>
                      <td>
                        <a
                          href="#"
                          class="text-primary"
                          data-toggle="modal"
                          data-target="#boostrapModal-1"
                          >Edit</a
                        >
                      </td>
                    </tr>
                    <tr>
                      <td>02/05/2023</td>
                      <td>AT0571</td>
                      <td
                        style="
                          max-width: 200px;
                          white-space: nowrap;
                          overflow: hidden;
                          text-overflow: ellipsis;
                        "
                        class="text-ellipsis"
                      >
                        CV. Amidis Waterindo
                      </td>
                      <td>100 Box</td>
                      <td>90 Box</td>
                      <td>10 Box</td>
                      <td>Rp.5000</td>
                      <td>Rp.500000</td>
                      <td>Rp.450000</td>
                      <td>Rp.50000</td>
                      <td>
                        <a
                          href="#"
                          class="text-primary"
                          data-toggle="modal"
                          data-target="#boostrapModal-1"
                          >Edit</a
                        >
                      </td>
                    </tr>
                    <tr>
                      <td>02/05/2023</td>
                      <td>AT0571</td>
                      <td
                        style="
                          max-width: 200px;
                          white-space: nowrap;
                          overflow: hidden;
                          text-overflow: ellipsis;
                        "
                        class="text-ellipsis"
                      >
                        CV. Amidis Waterindo
                      </td>
                      <td>100 Box</td>
                      <td>90 Box</td>
                      <td>10 Box</td>
                      <td>Rp.5000</td>
                      <td>Rp.500000</td>
                      <td>Rp.450000</td>
                      <td>Rp.50000</td>
                      <td>
                        <a
                          href="#"
                          class="text-primary"
                          data-toggle="modal"
                          data-target="#boostrapModal-1"
                          >Edit</a
                        >
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
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
