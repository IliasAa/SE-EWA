<template>

  <div class="login-form card">
    <div class="title">
      <h1>Register</h1>
    </div>
    <div class="card-body">
      <form>
        <div class="form-group">
          <label for="email">Email</label>
          <input type="email" class="form-control" id="email" v-model="email" placeholder="Enter email">
        </div>
        <div class="form-group">
          <label for="username">Username</label>
          <input type="text" class="form-control" id="username" v-model="username" placeholder="Enter username">
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <input type="password" class="form-control" id="password" v-model="password" placeholder="Password">
        </div>
        <button type="submit" class="btn btn-primary" v-if="hasChanged" @click="redirect">Submit</button>
      </form>
    </div>
  </div>

  <div class="background">
  <img src="../assets/Ludobackground.png">
  </div>
</template>

<script>
export default {
  name: "RegisterScreen",
  data() {
    return {
      email: '',
      password: '',
      username: '',
    };
  },

  computed: {
    hasChanged() {
      if (this.email !== '' && this.password !== ''&& this.username !== ''){
        return true;
      } else {
        return false;
      }
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

</style>