<template>
  <Head>
    <Title>Shanur</Title>
  </Head>
  <Body>
    <div class="main-menu">
      <header class="header">
        <a href="index.html" class="logo"
          ><i class="ico ti-rocket"></i>SpaceX</a
        >
        <button
          type="button"
          class="button-close fa fa-times js__menu_close"
        ></button>
      </header>
      <div class="content">
        <Sidebar />
      </div>
      <Navbar />
    </div>
    <slot />      
      
  </Body>
</template>


<style>

@import "../assets/styles/style.min.css";

@import "../assets/fonts/themify-icons/themify-icons.css";
@import "../assets/plugin/mCustomScrollbar/jquery.mCustomScrollbar.min.css";
@import "../assets/plugin/waves/waves.min.css";
@import "../assets/plugin/sweet-alert/sweetalert.css";


html, body {
    font-family: 'poppins';
}

</style>
