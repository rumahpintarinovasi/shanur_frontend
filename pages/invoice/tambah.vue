<template>
    <NuxtLayout>
      <div id="wrapper">
        <div class="main-content">
          <!-- /.row small-spacing two -->
          <div class="row small-spacing">
            <div class="col-lg-6 col-xs-12">
              <div class="box-content custom-height">
                <div class="flex-custom middle">
                  <h4 class="box-title">Tanggal</h4>
                  <div class="input-group" style="width: 100%;">
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
  
            <!-- Faktur Penjualan -->
            <div class="col-lg-6 col-xs-12">
              <div class="box-content">
                <div class="flex-custom">
                  <h4 class="box-title">Pembuat</h4>
                  <div class="form-group">
                    <select class="form-control" style="width:100%">
                      <option value="">Nama Toko</option>
                      <option value="1">Toko Cabang 1</option>
                      <option value="2">Toko Cabang 2</option>
                      <option value="3">Toko Cabang 3</option>
                    </select>
                  </div>
                </div>
                <div class="flex-custom">
                  <h4 class="box-title">Kepada</h4>
                  <div class="form-group">
                    <select class="form-control" style="width:100%">
                      <option value="">001 - Gudang Pusat</option>
                      <option value="1">002 - Gudang Cabang</option>
                      <option value="2">003 - Gudang Cabang</option>
                      <option value="3">004 - Gudang Cabang</option>
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
                <table class="table table-striped margin-bottom-10 margin-top-10">
                  <thead>
                    <tr>
                      <th>Nomor</th>
                      <th>Kode</th>
                      <th style="width: 20%">Nama Item</th>
                      <th>Harga</th>
                      <th>Jumlah</th>
                      <th>Total</th>
                      <th>Aksi</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr v-for="(item, index) in listDataPo" :key="index">
                      <td>{{ index + 1 }}</td>
                      <td>{{ item.kode }}</td>
                      <td>{{ item.nama }}</td>
                      <td>{{ item.harga }}</td>
                      <td>{{ item.jumlah }}</td>
                      <td>{{ item.total }}</td>
                      <td>
                        <div class="text-danger" style="cursor: pointer;" @click="listDataPo.splice(index, 1)">
                          Hapus
                        </div>
                      </td>
                    </tr>
                    <tr>
                      <td colspan="7">
                        <div class="text-black " style="cursor: pointer;" @click="addItem">
                          <i class="fa fa-plus"></i>
                          Tambah Item
                        </div>
                      </td>
                    </tr>
                  </tbody>
                </table>              
              </div>
              <!-- /.box-content -->
  
            </div>
          </div>
  
          <div class="row small-spacing">
            <!-- Kartu Stok -->
            <div class="col-lg-6 col-xs-12">
              <div class="box-content">
                <div class="flex-custom">
                  <h4 class="box-title">Total</h4>
                  <div class="form-group" style="max-width:100%;">
                    <input type="text" class="form-control font-bold" placeholder="Rp. 0" style="max-width:100%;" value="Rp.60.0000">     
                  </div>
                </div>
                <div class="flex-custom">
                  <h4 class="box-title">Pembayaran</h4>
                  <div class="form-group">
                    <select class="form-control" style="width:100%">
                      <option value="">Cash</option>
                      <option value="1">Kredit</option>
                      <option value="2">Dana</option>
                      <option value="3">Ovo</option>
                    </select>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-lg-6 col-xs-12">
            <!-- button ajukan po (green) batalkan po (red) flex row but in mobile column-->
            <div class="flex-custom-responsive">
              <button type="button" class="btn btn-danger ">Batalkan PO</button>
              <button type="button" class="btn btn-success ">Ajukan PO</button>
            </div>
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
  
  const listDataPo = ref([
    {
      id: 1,
      kode: "AT0571",
      nama: "Buku Kiky",
      harga: 10000,
      jumlah: 2,
      total: 20000,
    },
    {
      id: 2,
      kode: "AT0571",
      nama: "Buku Kiky",
      harga: 10000,
      jumlah: 2,
      total: 20000,
    },
    {
      id: 3,
      kode: "AT0571",
      nama: "Buku Kiky",
      harga: 10000,
      jumlah: 2,
      total: 20000,
    },
    {
      id: 4,
      kode: "AT0571",
      nama: "Buku Kiky",
      harga: 10000,
      jumlah: 2,
      total: 20000,
    },
  ])
  
  const addItem = () => {
    listDataPo.value.push({
      id: 5,
      kode: "AT0571",
      nama: "Buku Kiky",
      harga: 10000,
      jumlah: 2,
      total: 20000,
    })
  }
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
    gap:1.5em;
    justify-content: space-between;
  }
  
    </style>
  