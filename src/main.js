import { createApp } from 'vue'
import router from './routes'
import App from './App.vue'
import "bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";

createApp(App).use(router).mount('#app')
// createApp(App).use(router)
// createApp(App).mount('#app')
