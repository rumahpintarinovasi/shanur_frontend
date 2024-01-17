// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
  ssr: false,
  devtools: {
    enabled: true,

    timeline: {
      enabled: true
    }
  },
  plugins: [
    {
      src: '~/plugins/jquery.js', // path to your jQuery plugin file
      mode: 'client', // only include on the client-side
    },
  ],
  pages: true,
  app: {
    head: {
      script: [
        { src: '/scripts/cells-by-row.min.js' },
        { src: '/scripts/chart.flot.init.js' },
        { src: '/scripts/chart.flot.init.min.js' },
        { src: '/scripts/chart.highcharts.init.js' },
        { src: '/scripts/chart.highcharts.init.min.js' },
        { src: '/scripts/chart.morris.init.js' },
        { src: '/scripts/chart.morris.init.min.js' },
        { src: '/scripts/chart.sparkline.init.js' },
        { src: '/scripts/chart.sparkline.init.min.js' },
        { src: '/scripts/comingsoon.init.js' },
        { src: '/scripts/comingsoon.init.min.js' },
        { src: '/scripts/datatables.demo.js' },
        { src: '/scripts/datatables.demo.min.js' },
        { src: '/scripts/fileUpload.demo.js' },
        { src: '/scripts/fileUpload.demo.min.js' },
        { src: '/scripts/form.demo.js' },
        { src: '/scripts/form.demo.min.js' },
        { src: '/scripts/form.wizard.init.js' },
        { src: '/scripts/form.wizard.init.min.js' },
        { src: '/scripts/fullcalendar.init.js' },
        { src: '/scripts/horizontal-menu.js' },
        { src: '/scripts/horizontal-menu.min.js' },
        { src: '/scripts/html5shiv.min.js' },
        { src: '/scripts/ion.rangeSlider.init.js' },
        { src: '/scripts/ion.rangeSlider.init.min.js' },
        { src: '/scripts/isotope.pkgd.min.js' },
        { src: '/scripts/jquery.chartjs.init.js' },
        { src: '/scripts/jquery.chartjs.init.min.js' },
        { src: '/scripts/jquery.knob.init.js' },
        { src: '/scripts/jquery.min.js' },
        { src: '/scripts/jquery.scrollTo.min.js' },
        { src: '/scripts/mailbox.init.js' },
        { src: '/scripts/mailbox.init.min.js' },
        { src: '/scripts/main.js' },
        { src: '/scripts/main.min.js' },
        { src: '/scripts/map.demo.js' },
        { src: '/scripts/map.demo.min.js' },
        { src: '/scripts/modernizr.min.js' },
        { src: '/scripts/nouislider.init.js' },
        { src: '/scripts/nouislider.init.min.js' },
        { src: '/scripts/respond.min.js' },
        { src: '/scripts/rwd.demo.js' },
        { src: '/scripts/rwd.demo.min.js' },
        { src: '/scripts/sweetalert.init.js' },
        { src: '/scripts/sweetalert.init.min.js' },
        { src: '/scripts/tinymce.init.js' },
        { src: '/scripts/tinymce.init.min.js' },
        { src: '/scripts/toastr.demo.js' },
        { src: '/scripts/toastr.demo.min.js' },
        { src: '/scripts/tourist.demo.js' },
        { src: '/scripts/tourist.demo.min.js' },
        { src: '/scripts/treeview.init.js' },
        { src: '/scripts/treeview.init.min.js' },
        { src: '/scripts/x-editable.demo.js' },
        { src: '/scripts/x-editable.demo.min.js' },
      ],
    },
  },

})
