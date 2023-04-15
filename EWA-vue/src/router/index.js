import { createRouter, createWebHashHistory } from 'vue-router'
import LoginPage from "@/components/LoginPage.vue";
import Ludoscreen from "@/components/Ludoscreen.vue";
import Dashboard from "@/components/Dashboard.vue";
import rulePage from "@/components/rulePage.vue";
import RegisterScreen from "@/components/RegisterScreen.vue";
import homePage from "@/components/homePage.vue";
import settingsPage from "@/components/settingsPage.vue";
import ActiveGamesScreen from "@/components/ActiveGamesScreen.vue"

import LeaderboardPage from "@/components/LeaderboardPage.vue";

const routes = [
    {path: '/homePage', component: homePage},
    {path: '/Loginpage', component: LoginPage},
    {path: '/gamepage', component: Ludoscreen},
    {path: '/Dashboard', component: Dashboard},
    {path: '/', redirect: '/homePage'},
    {path: '/rulepage', component: rulePage},
    {path: '/Registerpage', component: RegisterScreen},
    {path: '/settings', component: settingsPage},
    {path: '/activeGames', component: ActiveGamesScreen},
    {path: '/LeaderboardPage', component: LeaderboardPage}
];

export const router = createRouter({
  history: createWebHashHistory(),
  routes
})

