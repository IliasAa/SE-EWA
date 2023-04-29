<template>
  <NavBar></NavBar>
  <div class="screen">

    <div class="card">
      <div class="card-buttons">
        <router-link to="/hostgame">
          <button class="btn btn-primary btn-lg">Create a game</button>
        </router-link>
        <router-link to="/joingame">
          <button class="btn btn-primary btn-lg">Join a game</button>
        </router-link>
        <router-link to="/rulepage">
          <button class="btn btn-primary btn-lg">How to play</button>
        </router-link>
        <router-link to="/settings">
          <button class="btn btn-primary btn-lg">Settings</button>
        </router-link>
      </div>

    </div>
    <div class="background">
      <img src="../assets/Ludobackground.png">
    </div>
  </div>

</template>

<script>
import NavBar from "@/components/NavBar.vue";


export default {
  name: "DashboardScreen",
  components: {NavBar},
  data() {
    return {

    }
  },

}
</script>


<style scoped>

.screen {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.card {
  position: relative;
  display: flex;
  flex-direction: column;
  margin-top: 50px;
  align-items: center;
  background: white;
  width: 50%;
  z-index: 1;
}

.card-buttons {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 3%;
}

.background, .background img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  object-position: bottom;
  position: absolute;
  top: 0;
  left: 0;
  z-index: -1000;
  filter: brightness(0.7);
  background-color: rgba(5, 11, 98, 1);
}

input {
  background: #F2F2F2;
}

.btn {
  margin-left: 7px;
  margin-bottom: 30px;
}


</style>