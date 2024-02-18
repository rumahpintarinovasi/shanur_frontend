<template>
  <Head>
    <Title>Shanur</Title>
  </Head>
  <Body>
    <Navbar />
    <div class="main-menu">
      <header class="header">
        <NuxtLink to="/" class="logo">
          SHANUR
        </NuxtLink>
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
  async created() {
    try {
      // const res = await this.$api("todos/1");
      // console.log(res.data);
    } catch (error) {
      console.log(error);
    }
  },
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

html,
body {
  font-family: "poppins";
}
</style>
