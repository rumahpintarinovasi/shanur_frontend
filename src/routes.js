import homePage from './pages/Home.vue'
import aboutPage from './pages/About.vue'
import { createRouter, createWebHistory } from 'vue-router'

const routes = [
    {
        path : '/',
        component : homePage
    },
    {
        path : '/about',
        component : aboutPage
    }
]

const router = createRouter({
    history : createWebHistory(),
    routes
})


export default router