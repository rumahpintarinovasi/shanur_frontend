<template>
  <div class="navigation">
    <h5 class="title">Toko Cabang 1</h5>
    <ul class="menu js__accordion">
      <li v-for="(item, index) in menu" :key="index" >
        <NuxtLink v-if="item === 'Dashboard'" to="/"
          ><i class="menu-icon ti-dashboard"></i
          ><span>Dashboard</span></NuxtLink
        >

        <NuxtLink v-else-if="item === 'Purchase Order'" to="/purchase-order"
          >
          <!-- icon order -->
          <i class="menu-icon ti-shopping-cart"></i>
          <span>Purchase Order</span></NuxtLink
        >

        <NuxtLink v-else-if="item === 'Invoice'" to="/invoice"
          >
          <i class="menu-icon ti-money"></i>
          <span>Invoice</span></NuxtLink
        >

        <NuxtLink v-else-if="item === 'Stock'" to="/stock"
          >
          <i class="menu-icon ti-bag"></i>
          <span>Stock</span></NuxtLink
        >

        <NuxtLink v-else-if="item === 'Product'"  to="/product"
          >
          <i class="menu-icon ti-package"></i>
          <span>Product</span></NuxtLink
        >

        <NuxtLink v-else-if="item === 'Cashier'" to="/cashier"
          >
          <i class="menu-icon ti-wallet"></i>
          <span>Cashier</span></NuxtLink
        >

        <NuxtLink 
          v-else-if="item === 'User Management'"
          to="/user-management"
          
        >
          <i class="menu-icon fa fa-users" />
          <span>User Management</span>
        </NuxtLink>

        <NuxtLink 
          v-else-if="item === 'Customer Management'"
          to="/customer-management"
          
        >
          <i class="menu-icon fa fa-users" />
          <span>Customer Management</span>
        </NuxtLink>
      </li>
      <!-- <li>
        <NuxtLink to="/"
          ><i class="menu-icon ti-dashboard"></i
          ><span>Dashboard</span></NuxtLink
        >
      </li> -->
      <!-- <li>
        <NuxtLink to="/purchase-order"
          >
          <i class="menu-icon ti-shopping-cart"></i>
          <span>Purchase Order</span></NuxtLink
        >
      </li> -->
      
      <!-- <li>
        <NuxtLink to="/invoice"
          >
          <i class="menu-icon ti-money"></i>
          <span>Invoice</span></NuxtLink
        >
      </li>
      <li>
        <NuxtLink to="/stock"
          >
          <i class="menu-icon ti-bag"></i>
          <span>Stock</span></NuxtLink
        >
      </li>
      <li>
        <NuxtLink to="/product"
          >
          <i class="menu-icon ti-package"></i>
          <span>Product</span></NuxtLink
        >
      </li>
      <!-- discount -->
      <li>
        <NuxtLink to="/discount"
          >
          <!-- icon discount -->
          <i class="menu-icon ti-cut"></i>
          <span>Discount</span></NuxtLink
        >
      </li>

    </ul>
  </div>
</template>

<script lang="ts" setup >
  import { constant } from '~/helpers'
  const role = ref<String>('cashier')
  const menu = ref<String[]>([''])

  onMounted( async () => {
    const storageRole:string = localStorage.getItem('role') || 'cashier'
    role.value = storageRole || 'cashier'
  
    menu.value = constant.sideBarMenu[storageRole]
  })
</script>

<style scoped>
.sub-menu-active {
  display: block !important;
}
</style>
