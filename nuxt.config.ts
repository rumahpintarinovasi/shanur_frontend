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
        {src: "/plugin/waves/waves.min.js"},
        {src: "/plugin/modal/remodal/remodal.min.js"},
      ],
    },
  },

})
