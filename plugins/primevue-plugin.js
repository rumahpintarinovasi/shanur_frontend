import { defineNuxtPlugin } from "#app";
import PrimeVue from "primevue/config";
import Tooltip from "primevue/tooltip";


export default defineNuxtPlugin(nuxtApp => {
    nuxtApp.vueApp.use(PrimeVue, { ripple : true})
})