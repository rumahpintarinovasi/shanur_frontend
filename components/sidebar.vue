<template>
  <div class="navigation">
    <h5 class="title">Toko Cabang 1</h5>
    <!-- /.title -->
    <ul class="menu js__accordion">
      <li>
        <NuxtLink to="/"
          ><i class="menu-icon ti-dashboard"></i
          ><span>Dashboard</span></NuxtLink
        >
      </li>
      <li>
        <NuxtLink to="/purchase-order"
          >
          <!-- icon order -->
          <i class="menu-icon ti-shopping-cart"></i>
          <span>Purchase Order</span></NuxtLink
        >
      </li>
      <li>
        <NuxtLink to="/invoice"
          >
          <!-- icon transaction -->
          <i class="menu-icon ti-money"></i>
          <span>Invoice</span></NuxtLink
        >
      </li>
      <li>
        <NuxtLink to="/stock"
          >
          <!-- icon supply -->
          <i class="menu-icon ti-bag"></i>
          <span>Stock</span></NuxtLink
        >
      </li>
      <li>
        <NuxtLink to="/product"
          >
          <!-- icon product -->
          <i class="menu-icon ti-package"></i>
          <span>Product</span></NuxtLink
        >
      </li>
      <li>
        <NuxtLink to="/cashier"
          >
          <!-- icon cashier -->
          <i class="menu-icon ti-wallet"></i>
          <span>Cashier</span></NuxtLink
        >
      </li>
      <li>
        <NuxtLink 
          to="/user-management"
          
        >
          <i class="menu-icon fa fa-users" />
          <span>User Management</span>
        </NuxtLink>
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
.sub-menu-active {
  display: block !important;
}
</style>
