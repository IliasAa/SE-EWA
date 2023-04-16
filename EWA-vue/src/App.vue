<template>
  <router-view></router-view>
</template>

<script>
import {UserAdaptor} from "@/adaptors/UserAdaptor";
import {AuthenticationAdaptor} from "@/adaptors/AuthenticationAdaptor";
import {LeaderboardAdaptor} from "@/adaptors/LeaderboardAdaptor";

export default {
  name: 'App',
  components: {
  },
  provide() {
    const URL = "http://localhost:8081";

    return {
      userService: new UserAdaptor(URL + "/users"),
      loginService: new AuthenticationAdaptor(URL + "/authentication"),
      leaderboardService: new LeaderboardAdaptor(URL + "/leaderboard")
    }
  }
}
</script>

<style scoped>

</style>
