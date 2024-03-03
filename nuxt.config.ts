// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
  ssr: false,
  devtools: {
    enabled: true,
  },
  css: ['primevue/resources/themes/aura-light-green/theme.css'],
  modules: [
    '@pinia/nuxt',
    'nuxt-primevue'
  ],
  primevue: {
    cssLayerOrder: 'primevue'
},
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
  primevue: {
    usePrimeVue : true
  },
  pages: true,
  app: {
    head: {
      // meta: [
      //   {
      //     "http-equiv": 'Content-Security-Policy',
      //     content: 'upgrade-insecure-requests'
      //   }
      // ],
      script: [
        {src: "/scripts/jquery.min.js"},
        {src: "/scripts/modernizr.min.js"},
        {src: "/plugin/bootstrap/js/bootstrap.min.js"},
        {src: "/plugin/modal/remodal/remodal.min.js"},
      ],
    },
  },
  runtimeConfig: {
    public: {
      BASE_URL_BACKEND: process.env.BASE_URL_BACKEND
    }
  }

})
