// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
  ssr: false,
  devtools: {
    enabled: true,
  },
  plugins: [
    // {
    //   // src: '~/plugins/jquery.js', // path to your jQuery plugin file
    //   // mode: 'client', // only include on the client-side
    // },
    '~/plugins/apexchart.js',
  ],
  pages: true,
  app: {
    head: {
      script: [
        // { src: '/scripts/modernizr.min.js' },
        // { src: '/plugin/bootstrap/js/bootstrap.min.js' },
        // { src: '/plugin/mCustomScrollbar/jquery.mCustomScrollbar.concat.min.js' },
        // { src: '/plugin/sweet-alert/sweetalert.min.js' },
        // { src: '/plugin/waves/waves.min.js' },
        // { src: '/plugin/chart/sparkline/jquery.sparkline.min.js' },
        // { src: '/scripts/main.min.js' }, 
      ],
    },
  },

})
