<template>
  <div class="main-menu">
    <header class="header">
      <a href="index.html" class="logo"><i class="ico ti-rocket"></i>SpaceX</a>
      <button type="button" class="button-close fa fa-times js__menu_close"></button>
    </header>
    <div class="content">
    <Sidebar />
    <!-- Page content here -->
    <Navbar />
  </div>
  </div>
</template>

<style scoped>
@import "../assets/styles/style.min.css";

@import "../assets/fonts/themify-icons/themify-icons.css";
@import "../assets/plugin/mCustomScrollbar/jquery.mCustomScrollbar.min.css";
@import "../assets/plugin/waves/waves.min.css";
@import "../assets/plugin/sweet-alert/sweetalert.css";
</style>

<script>
import Sidebar from '~/components/sidebar.vue'
import Navbar from '~/components/navbar.vue'

export default {
  components: {
    Sidebar,
    Navbar
  },
  layout: 'default'
}
</script>