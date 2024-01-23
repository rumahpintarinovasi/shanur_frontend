<template>
  <Head>
    <Title>Shanur</Title>
  </Head>
  <Body>
    <Navbar />
    <div class="main-menu">
      <header class="header">
        <a href="index.html" class="logo"
          ><i class="ico ti-rocket"></i>SpaceX</a
        >
        <button
          type="button"
          class="button-close fa fa-times js__menu_close"
          @click="closeMenu"
        ></button>
      </header>
      <div class="content">
        <Sidebar />
      </div>
    </div>
    <slot />
  </Body>
</template>

<script>
export default {
  methods: {
    closeMenu() {
      document.querySelector("html").classList.remove("menu-active");
    },
  },
};
</script>

<style>
@import "../assets/styles/style.min.css";
@import "../assets/fonts/themify-icons/themify-icons.css";
@import "../assets/plugin/mCustomScrollbar/jquery.mCustomScrollbar.min.css";
@import "../assets/plugin/waves/waves.min.css";
@import "../assets/plugin/sweet-alert/sweetalert.css";

html,
body {
  font-family: "poppins";
}
</style>
