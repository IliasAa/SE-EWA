<template>
  <NavBar :isLoggedIn="false"></NavBar>
  <div class="login-form card">
    <div class="title">
      <v-banner>
        <h2>Register</h2>
      </v-banner>
    </div>
    <form>
      <div class="px-3 pt-3">
        <div class="row mb-2">
          <div class="col">
            <v-text-field
                label="Username"
                type="text"
                v-model="username"
            ></v-text-field>
          </div>
        </div>
        <div class="row mb-2">
          <div class="col">
            <v-text-field
                label="Email address"
                type="email"
                v-model="email"
            ></v-text-field>
          </div>
        </div>
        <div class="row mb-2">
          <div class="col">
            <v-text-field
                label="Password"
                type="password"
                hint="Enter your password to access this website"
                v-model="password"
            ></v-text-field>
          </div>
        </div>
      </div>
    </form>
    <div class="row px-3 pb-3">
      <div class="col">
        <v-btn @click="redirect" type="submit" variant="flat" color="indigo-darken-4" class="w-100" style="transition-duration: 0.5s;">
          Submit
        </v-btn>
      </div>
    </div>
    <div class="register">Already Have an Account?
      <router-link to="/Loginpage" class="link-primary fw-bold">Login</router-link>
    </div>
  </div>

  <div class="background">
  <img src="../assets/Ludobackground.png">
  </div>
</template>

<script>
import NavBar from "@/components/NavBar.vue";
export default {
  name: "RegisterScreen",
  components: {NavBar},
  data() {
    return {
      email: '',
      password: '',
      username: '',
    };
  },

  computed: {
    hasChanged() {
      return this.email !== '' && this.password !== '' && this.username !== '';
    }
  },

  methods: {
    redirect(){
      this.$router.push("/Dashboard");
    }
  }
}
</script>

<style scoped>
.title{
  text-align: center;
}
.login-form {
  width: 90vw;
  max-width: 400px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}


.background, .background img {
  width: 100vw;
  height: 100vh;
  object-fit: cover;
  object-position: bottom;
  position: absolute;
  top: 0;
  left: 0;
  z-index: -1000;
  filter: brightness(0.7);
  background-color: rgba(5, 11, 98, 1);
}

.register{
  text-align: center;
}

</style>