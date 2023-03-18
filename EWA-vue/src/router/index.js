import { createRouter, createWebHashHistory } from 'vue-router'
import LoginScreen from "@/components/LoginScreen.vue";
import Ludoscreen from "@/components/Ludoscreen.vue";
import Dashboard from "@/components/Dashboard.vue";
import rulePage from "@/components/rulePage.vue";
import RegisterScreen from "@/components/RegisterScreen.vue";

const routes = [
    {path: '/Loginpage', component: LoginScreen},
    {path: '/gamepage', component: Ludoscreen},
    {path: '/Dashboard', component: Dashboard},
    {path: '/', redirect: '/Loginpage'},
    {path: '/rulepage', component: rulePage},
    {path: '/Registerpage', component: RegisterScreen}
];

export const router = createRouter({
  history: createWebHashHistory(),
  routes
})

