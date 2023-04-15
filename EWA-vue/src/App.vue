<template>
  <router-view></router-view>
</template>

<script>
import {UserAdaptor} from "@/adaptors/UserAdaptor";
import {LoginAdaptor} from "@/adaptors/LoginAdaptor";

export default {
  name: 'App',
  components: {
  },
  provide() {
    const URL = "http://localhost:8081";

    return {
      userService: new UserAdaptor(URL + "/users"),
      loginService: new LoginAdaptor(URL + "/users"),
    }
  }
}
</script>

<style scoped>

</style>
