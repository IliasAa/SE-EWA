<template>
  <router-view></router-view>
</template>

<script>
import {UserAdaptor} from "@/adaptors/UserAdaptor";
import {AuthenticationAdaptor} from "@/adaptors/AuthenticationAdaptor";
import {shallowReactive} from "vue";
import {SessionService} from "@/adaptors/SessionService";
import {FetchInterceptor} from "@/adaptors/FetchInterceptor";
import {toast} from "vue3-toastify";
import {LeaderboardAdaptor} from "@/adaptors/LeaderboardAdaptor";
import {LobbyAdaptor} from "@/adaptors/LobbyAdaptor";

export default {
  name: 'App',
  components: {},
  provide() {
    const URL = "http://localhost:8081";

    this.theSessionService = shallowReactive(
        new SessionService(URL + "/authentication", "JWT_LUDO"));

    this.theFetchInterceptor =
        new FetchInterceptor(this.theSessionService, this.$router, toast);


    return {
      userService: new UserAdaptor(URL + "/users"),
      loginService: new AuthenticationAdaptor(URL + "/authentication"),
      leaderboardService: new LeaderboardAdaptor(URL + "/leaderboard"),
      lobbyService: new LobbyAdaptor(URL + "/Lobby"),
      SessionService: this.theSessionService,
    }
  },
  beforeUnmount() {
    this.theFetchInterceptor.unregister();
  }
}

</script>

<style scoped>

</style>
