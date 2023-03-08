import { createRouter, createWebHashHistory } from 'vue-router'
import LoginScreen from "@/components/LoginScreen.vue";

const routes = [
    {path: '/Loginpage', component: LoginScreen},
    {path: '/', redirect: '/Loginpage'}
];

export const router = createRouter({
  history: createWebHashHistory(),
  routes
})

