import { createRouter, createWebHashHistory } from 'vue-router'
import LoginScreen from "@/components/LoginScreen.vue";
import Ludoscreen from "@/components/Ludoscreen.vue";
import Dashboard from "@/components/Dashboard.vue";

const routes = [
    {path: '/Loginpage', component: LoginScreen},
    {path: '/gamepage', component: Ludoscreen},
    {path: '/Dashboard', component: Dashboard},
    {path: '/', redirect: '/Loginpage'}
];

export const router = createRouter({
  history: createWebHashHistory(),
  routes
})

