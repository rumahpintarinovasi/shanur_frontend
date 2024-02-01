<template>
  <div class="navigation">
    <h5 class="title">Toko Cabang 1</h5>
    <!-- /.title -->
    <ul class="menu js__accordion">
      <li>
        <a href="/"
          ><i class="menu-icon ti-dashboard"></i
          ><span>Dashboard</span></a
        >
      </li>
      <li>
        <a href="/purchase-order"
          >
          <!-- icon order -->
          <i class="menu-icon ti-shopping-cart"></i>
          <span>Purchase Order</span></a
        >
      </li>
      <li>
        <a href="/invoice"
          >
          <!-- icon transaction -->
          <i class="menu-icon ti-money"></i>
          <span>Invoice</span></a
        >
      </li>
      <li>
        <a href="/stock"
          >
          <!-- icon supply -->
          <i class="menu-icon ti-bag"></i>
          <span>Stock</span></a
        >
      </li>
      <li>
        <a href="/product"
          >
          <!-- icon product -->
          <i class="menu-icon ti-package"></i>
          <span>Product</span></a
        >
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      activeIndex: null,
    };
  },
  methods: {
    handleMenuItemClick(index) {
      // Toggle the clicked menu
      this.activeIndex = this.activeIndex === index ? null : index;
    },
  },
};
</script>

<style scoped>
@import "../assets/styles/style.min.css";
@import "../assets/fonts/themify-icons/themify-icons.css";
@import "../assets/plugin/mCustomScrollbar/jquery.mCustomScrollbar.min.css";
@import "../assets/plugin/waves/waves.min.css";
@import "../assets/plugin/sweet-alert/sweetalert.css";

.sub-menu-active {
  display: block !important;
}
</style>
