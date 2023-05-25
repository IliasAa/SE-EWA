<template>
  <div>
    <NavBar></NavBar>
    <div class="screen">
      <div class="card">
        <div class="card-header">
          <h1>Welcome to Ludo King</h1>
          <p>Choose your adventure:</p>
        </div>
        <div class="card-buttons">
          <router-link to="/hostgame">
            <button class="btn btn-primary btn-lg">Create a game</button>
          </router-link>
          <router-link to="/joingame">
            <button class="btn btn-primary btn-lg">Join a game</button>
          </router-link>

        </div>
        <hr>
        <div class="card-footer">
          <router-link to="/rulepage">
            <button class="btn btn-secondary btn-sm">How to Play</button>
          </router-link>
          <a>
            <button class="btn btn-primary btn-lg" @click="togglePopup">Random Chat</button>
          </a>
          <router-link to="/settings">
            <button class="btn btn-secondary btn-sm">Settings</button>
          </router-link>
        </div>
      </div>
      <div class="background"></div>
    </div>
    <div class="chatDetail" v-if="showPopup">
      <div class="close" @click="togglePopup">&times;</div>
      <chatBox></chatBox>
    </div>
  </div>

</template>

<script>
import NavBar from "@/components/NavBar.vue";
import chatBox from "@/components/chat/chatBox.vue";


export default {
  name: "DashboardScreen",
  components: {NavBar, chatBox},
  data() {
    return {
      showPopup: false,
    }
  },
  methods: {
    togglePopup() {
      this.showPopup = !this.showPopup;
    },
  },

}
</script>


<style scoped>


.chatDetail {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 2;
  background-color: rgba(255, 255, 255, 0.9);
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
}

.close {
  /* ... existing styles ... */
  position: absolute;
  top: 10px;
  right: 10px;
  font-size: 30px;
  font-weight: bold;
  cursor: pointer;
}

button {
  padding: 8px 16px;
  background-color: #3772ff;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
.screen {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 80vh;
}

.card {
  position: relative;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
  padding: 30px;
  background-color: rgba(255, 255, 255, 0.9);
  border-radius: 10px;
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
  width: 50%;
  min-width: 350px;
  z-index: 1;
}

.card-header {
  text-align: center;
  border-color: black;
  margin-bottom: 20px;
}


.card-footer {
  display: flex;
  justify-content: space-between;
  width: 100%;
  margin-top: 20px;
}

.background {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: -1;
  background-image: url("../assets/Ludobackground.png");
  background-color: rgba(5, 11, 98, 1);
  background-size: cover;
  background-position: center;
  filter: brightness(0.5)
}

.btn {
  margin-bottom: 20px;
  padding: 10px 20px;
  font-size: 1.2rem;
  border-radius: 5px;
}

.btn-primary {
  background-color: #0085FF;
  color: white;
  border: none;
  width: 100%;

}

.btn-primary:hover {
  background-color: #0066CC;
}

.btn-secondary {
  background-color: white;
  color: #555;
  border: 1px solid #CCC;
}

.btn-secondary:hover {
  background-color: #EEE;
}
</style>