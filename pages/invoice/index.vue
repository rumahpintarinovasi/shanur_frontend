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
                  <h4 class="box-title">Riwayat invoices</h4>
                  <a href="/invoice/tambah" class="btn btn-sm" style="color:black;margin-bottom: 10px">
                  <i class="fa fa-plus"></i>
                  Buat Invoice
                </a>
                </div>
  
                <table class="table table-striped margin-bottom-10 margin-top-10">
                  <thead>
                    <tr>
                      <th>Tanggal</th>
                      <th>No. Inv</th>
                      <th style="max-width: 300px;  white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">Jenis</th>
                      <th>Barang</th>
                      <th>Jumlah</th>
                      <th>Total Harga</th>
                      <th>Aksi</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>02/05/2023</td>
                      <td>PO103</td>
                      <td
                        style="
                          max-width: 300px; 
                          white-space: nowrap;
                          overflow: hidden;
                          text-overflow: ellipsis;
                        "
                        class="text-ellipsis"
                      >
                        CV. Amidis Waterindo
                      </td>
                      <td>Barang 1</td>
                      <td>10</td>
                      <td>Rp.1000000</td>
                      <td>
                        <a href="#" class="text-primary">Detail</a>
                      </td>
                    </tr>
                    <tr>
                      <td>02/05/2023</td>
                      <td>PO103</td>
                      <td
                        style="
                          max-width: 300px; 
                          white-space: nowrap;
                          overflow: hidden;
                          text-overflow: ellipsis;
                        "
                        class="text-ellipsis"
                      >
                        CV. Amidis Waterindo
                      </td>
                      <td>Barang 2</td>
                      <td>10</td>
                      <td>Rp.1000000</td>
                      <td>
                        <a href="#" class="text-primary">Detail</a>
                      </td>
                    </tr>
                    <tr>
                      <td>02/05/2023</td>
                      <td>PO103</td>
                      <td
                        style="
                          max-width: 300px; 
                          white-space: nowrap;
                          overflow: hidden;
                          text-overflow: ellipsis;
                        "
                        class="text-ellipsis"
                      >
                        CV. Amidis Waterindo
                      </td>
                      <td>Barang 3</td>
                      <td>10</td>
                      <td>Rp.1000000</td>
                      <td>
                        <a href="#" class="text-primary">Detail</a>
                      </td>
                    </tr>
                    <tr>
                      <td>02/05/2023</td>
                      <td>PO103</td>
                      <td
                        style="
                          max-width: 300px; 
                          white-space: nowrap;
                          overflow: hidden;
                          text-overflow: ellipsis;
                        "
                        class="text-ellipsis"
                      >
                        CV. Amidis Waterindo
                      </td>
                      <td>Barang 4</td>
                      <td>10</td>
                      <td>Rp.1000000</td>
                      <td>
                        <a href="#" class="text-primary">Detail</a>
                      </td>
                    </tr>
                    <tr>
                      <td>02/05/2023</td>
                      <td>PO103</td>
                      <td
                        style="
                          max-width: 300px; 
                          white-space: nowrap;
                          overflow: hidden;
                          text-overflow: ellipsis;
                        "
                        class="text-ellipsis"
                      >
                        CV. Amidis Waterindo
                      </td>
                      <td>Barang 5</td>
                      <td>10</td>
                      <td>Rp.1000000</td>
                      <td>
                        <a href="#" class="text-primary">Detail</a>
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
    display:flex;
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
  .flex-custom  h4.box-title {
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
  