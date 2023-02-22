import { createRouter, createWebHistory } from 'vue-router'
import Home from "@/components/Home.vue";

const routes = [
    {path: '/home', component: Home},
    {path: '/', redirect: Home}
];

export const router = createRouter({
  history: createWebHashHistory(),
  routes
})

