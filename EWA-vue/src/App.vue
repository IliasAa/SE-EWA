<template>
  <router-view></router-view>
</template>

<script>
import {UserAdaptor} from "@/adaptors/UserAdaptor";
import {AuthenticationAdaptor} from "@/adaptors/AuthenticationAdaptor";

export default {
  name: 'App',
  components: {
  },
  provide() {
    const URL = "http://localhost:8081";

    return {
      userService: new UserAdaptor(URL + "/users"),
      loginService: new AuthenticationAdaptor(URL + "/authentication"),
    }
  }
}
</script>

<style scoped>

</style>
