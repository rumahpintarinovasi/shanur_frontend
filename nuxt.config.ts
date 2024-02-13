// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
  ssr: false,
  devtools: {
    enabled: true,
  },
  modules: [
    '@pinia/nuxt',
  ],
  plugins: [
    '~/plugins/axios.ts',
    '~/plugins/apexchart.js',
  ],
  components: [
    '~/components',
    '~/components/Invoices',
  ],
  build: {
    transpile: ['axios'], // To avoid potential Axios issues with Nuxt 3
  },
  pages: true,
  app: {
    head: {
      script: [
        {src: "/scripts/jquery.min.js"},
        {src: "/scripts/modernizr.min.js"},
        {src: "/plugin/bootstrap/js/bootstrap.min.js"},
        {src: "/plugin/mCustomScrollbar/jquery.mCustomScrollbar.concat.min.js"},
        {src: "/plugin/nprogress/nprogress.js"},
        {src: "/plugin/sweet-alert/sweetalert.min.js"},
        {src: "/plugin/waves/waves.min.js"},
        {src: "/plugin/chart/sparkline/jquery.sparkline.min.js"},
        {src: "/scripts/chart.sparkline.init.min.js"},
        {src: "/plugin/modal/remodal/remodal.min.js"},
        {src: "/scripts/main.min.js"},
      ],
    },
  },
  runtimeConfig: {
    public: {
      BASE_URL_BACKEND: process.env.BASE_URL_BACKEND
    }
  }

})
