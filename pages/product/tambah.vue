<template>
  <NuxtLayout>
    <div id="wrapper">
      <div class="main-content">
        <!-- /.row small-spacing two -->
        <div class="row small-spacing">
          <div class="col-lg-6 col-xs-12">
            <div class="box-content custom-height">
              <div class="flex-custom middle">
                <h4 class="box-title">Tanggal PO</h4>
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
                    for="inputKodeBarang"
                    class="col-sm-3 control-label"
                    style="text-align: left !important"
                    >Kode Barang</label
                  >
                  <div class="col-sm-9">
                    <input
                      type="email"
                      class="form-control"
                      id="inputKodeBarang"
                      placeholder="Ketik Nama Barang"
                    />
                  </div>
                </div>
                <div class="form-group">
                  <label
                    for="inputNamaBarang"
                    class="col-sm-3 control-label"
                    style="text-align: left !important"
                    >Nama Barang</label
                  >
                  <div class="col-sm-9">
                    <input
                      type="text"
                      class="form-control"
                      id="inputNamaBarang"
                      placeholder="Masukan Jumlah Masuk"
                    />
                  </div>
                </div>
                <!-- input satuan unit select -->
                <div class="form-group">
                  <label
                    for="inputSatuan"
                    class="col-sm-3 control-label"
                    style="text-align: left !important"
                    >Satuan</label
                  >
                  <div class="col-sm-9">
                    <select class="form-control" style="width: 100%">
                      <option value="">Pilih Satuan</option>
                      <option value="1">Pcs</option>
                      <option value="2">Box</option>
                      <option value="3">Dus</option>
                    </select>
                  </div>
                </div>
                <!-- input harga -->
                <div class="form-group">
                  <label
                    for="inputHarga"
                    class="col-sm-3 control-label"
                    style="text-align: left !important"
                    >Harga per Unit</label
                  >
                  <div class="col-sm-9">
                    <input
                      type="text"
                      class="form-control"
                      id="inputHarga"
                      placeholder="Masukan Harga"
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
              <div class="flex-custom-responsive " style="margin-left:10px;">
                <button type="button" class="btn btn-danger">Batalkan</button>
                <button type="button" class="btn btn-success">Simpan</button>
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
]);

const addItem = () => {
  listDataPo.value.push({
    id: 5,
    kode: "AT0571",
    nama: "Buku Kiky",
    harga: 10000,
    jumlah: 2,
    total: 20000,
  });
};
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
