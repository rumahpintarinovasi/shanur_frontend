<template>
  <div>
    <NuxtLayout>
    <div id="wrapper">
      <div class="main-content">
        <!-- /.row small-spacing two -->

        <div class="row small-spacing">
          <!-- Kartu Stok -->
          <div class="col-lg-4 col-xs-12">
            <div class="box-content">
              <h4 class="box-title">Kartu Stok</h4>

              <div class="content-list">
                <div class="list">
                  <p class="left">Minyak Goreng</p>
                  <p class="right">&#60; 10 Box</p>
                </div>
                <div class="list">
                  <p class="left">Indomie Goreng</p>
                  <p class="right">
                    <!-- write < (in unicode html) -->
                    &#60; 15 Box
                  </p>
                </div>
                <div class="list">
                  <p class="left">Buku Kiky</p>
                  <p class="right">
                    <!-- write < (in unicode html) -->
                    &#60; 20 Box
                  </p>
                </div>
                <div class="list">
                  <p class="left">Ballpoint Standard</p>
                  <p class="right">
                    <!-- write < (in unicode html) -->
                    &#60; 24 Box
                  </p>
                </div>
                <div class="list">
                  <p class="left">Popmie Ayam Bawang</p>
                  <p class="right">
                    <!-- write < (in unicode html) -->
                    &#60; 30 Box
                  </p>
                </div>
              </div>
            </div>
            <!-- /.box-content -->
          </div>

          <!-- Faktur Penjualan -->
          <div class="col-lg-8 col-xs-12">
            <div class="box-content">
              <h4 class="box-title">Faktur Penjualan</h4>

              <!-- chart faktur penjualan -->
              <div>
                <apexchart
                  height="250"
                  type="bar"
                  :options="chartOptions"
                  :series="chartSeries"
                />
              </div>
            </div>
            <!-- /.box-content -->
          </div>
          <!-- /.col-lg-6 col-xs-12 -->
        </div>
        <!-- /.row small-spacing three -->

        <div class="row small-spacing">
          <!-- Laba -->
          <div class="col-lg-4 col-xs-12">
            <div class="box-content">
              <h4 class="box-title text-info">Laba</h4>
              <div class="bg-success text-white custom-laba">Rp3.000.000</div>
              <!-- /.content widget-stat -->
            </div>
            <!-- /.box-content -->
          </div>
          <!-- /.col-lg-4 col-xs-12 -->

          <!-- Hutang -->
          <div class="col-lg-4 col-xs-12">
            <div class="box-content">
              <h4 class="box-title text-danger">Hutang</h4>
              <div class="content-list-two">
                <div class="list">
                  <p class="left">CV. Amidis Waterindo</p>
                  <p class="right">2/02/24</p>
                </div>
                <div class="list">
                  <p class="left">CV. Bendera Frisian</p>
                  <p class="right">3/02/24</p>
                </div>
              </div>
            </div>
            <!-- /.box-content -->
          </div>
          <!-- /.col-lg-4 col-xs-12 -->

          <!-- Piutang -->
          <div class="col-lg-4 col-xs-12">
            <div class="box-content">
              <h4 class="box-title text-success">Piutang</h4>
              <!-- /.dropdown js__dropdown -->
              <div class="content-list-two">
                <div class="list">
                  <p class="left">Toko Cabang 3</p>
                  <p class="right">2/02/24</p>
                </div>
                <div class="list">
                  <p class="left">Toko Cabang 1</p>
                  <p class="right">3/02/24</p>
                </div>
              </div>
              <!-- /.content widget-stat -->
            </div>
            <!-- /.box-content -->
          </div>
          <!-- /.col-lg-4 col-xs-12 -->
        </div>

        <div class="row small-spacing">
          <!-- Faktur Pembelian -->
          <div class="col-lg-4 col-xs-12">
            <div class="box-content">
              <h4 class="box-title">Faktur Pembelian</h4>
              <!-- faktur pembelian chart -->
              <div>
                <!-- Faktur Pembelian Chart -->
                <apexchart
                  type="pie"
                  :options="chartOptionsFakturPembelian"
                  :series="chartSeriesFakturPembelian"
                />
              </div>
            </div>
            <!-- /.box-content -->
            <div class="box-content">
              <h4 class="box-title">Purchase Order</h4>
              <!-- /.dropdown js__dropdown -->
              <div class="content-list-two">
                <div class="list">
                  <p class="left">CV. Amidis Waterindo</p>
                  <p class="right">2/02/24</p>
                </div>
                <div class="list">
                  <p class="left">CV. Amidis Waterindo</p>
                  <p class="right">2/02/24</p>
                </div>
                <div class="list">
                  <p class="left">CV. Amidis Waterindo</p>
                  <p class="right">2/02/24</p>
                </div>
              </div>
            </div>
            <!-- /.box-content -->
          </div>
          <!-- /.col-lg-4 col-xs-12 -->

          <div class="col-lg-8 col-xs-12">
            <div class="box-content">
              <h4 class="box-title">Laporan Pembelian</h4>
              <apexchart
                height="250"
                type="pie"
                :options="chartOptionsLaporanPembelian"
                :series="chartSeriesLaporanPembelian"
              />
              <!-- /.box-title -->
              <table class="table table-striped margin-bottom-10 margin-top-10">
                <thead>
                  <tr>
                    <th>Kode</th>
                    <th style="width: 40%">Nama Item</th>
                    <th>Jumlah</th>
                    <th>Total Penjualan</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>AT0571</td>
                    <td>Buku Kiky</td>
                    <td>10.000 pcs</td>
                    <td>Rp100.000.000</td>
                  </tr>
                  <tr>
                    <td>AT0594</td>
                    <td>Sepatu Warrior Hitam</td>
                    <td>10.000 pcs</td>
                    <td>Rp100.000.000</td>
                  </tr>
                  <tr>
                    <td>AT0501</td>
                    <td>Ransel Bodypack Medium</td>
                    <td>10.000 pcs</td>
                    <td>Rp100.000.000</td>
                  </tr>
                </tbody>
              </table>
              <!-- /.table -->
            </div>
            <!-- /.box-content -->
          </div>
          <!-- /.col-lg-6 col-xs-12 -->
        </div>


        <Footer />
      </div>
    </div>
  </NuxtLayout>
  </div>
</template>

<script setup>
definePageMeta({
  layout: "dashboard",
});

const chartOptions = {
  chart: {
    type: "bar",
    height: 300,
  },
  xaxis: {
    categories: ["Cabang1", "Cabang2", "Cabang3", "Cabang4", "Cabang5"],
  },
  yaxis: {
    min: 0,
    max: 800000000,
    labels: {
      formatter: function (value) {
        // Format the y-axis labels in millions
        return value / 1000000 + "jt";
      },
    },
  },
  plotOptions: {
    bar: {
      dataLabels: {
        position: "top", // Set to 'top' to hide the values within bars
        formatter: function () {
          return ""; // Empty string to hide the values
        },
      },
      columnWidth: "80%", // Adjust the width of the bars
    },
  },
  fill: {
    colors: ["#00BF4F", "#00BF4F", "#00BF4F", "#00BF4F", "#00BF4F"], // Change bar colors
  },
};

const chartSeries = [
  {
    name: "Faktur Penjualan",
    data: [600000000, 200000000, 50000000, 500000000, 200000000],
  },
];

const chartOptionsFakturPembelian = {
  chart: {
    type: "pie",
    height: 300,
  },
  labels: ["Approved", "Pending", "Closed"],
  colors: ["#007BFF", "#FFC107", "#DC3545"], // Blue, Yellow, Red
  legend: {
    show: true,
    position: "bottom",
  },
  plotOptions: {
    pie: {
      dataLabels: {
        position: "bottom",
      },
    },
  },
};

const chartSeriesFakturPembelian = [
  Math.random() * 100,
  Math.random() * 100,
  Math.random() * 100,
];

const chartOptionsLaporanPembelian = {
  chart: {
    type: "pie",
    height: 300,
  },
  legend: {
    show: false,
  },
  labels: ["Fashion", "Makanan", "Minuman", "Alat Tulis"],
  colors: ["#007BFF", "#FFC107", "#DC3545", "#28A745"], 
};

const chartSeriesLaporanPembelian = [
  Math.random() * 100,
  Math.random() * 100,
  Math.random() * 100,
  Math.random() * 100,
];
</script>

<style>
p {
  margin: 0 !important;
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
