<template>
  <NavBar></NavBar>
  <div class="screen">
    <div class="card">


      <button class="btn btn-primary btn-lg" @click="showPopup1 = !showPopup1">Start a offline game</button>
      <popup class="popup" v-if="showPopup1">
        <div class="lobbyDetail" :style="{display: showPopup1 ? 'block' : 'none'}">
          <div class="lobbyContent">
            <span @click="showPopup1 = !showPopup1" class="close">&times;</span>
            <DetailOfflineGame></DetailOfflineGame>
          </div>
        </div>
      </popup>


      <button class="btn btn-primary btn-lg" @click="showPopup2 = !showPopup2">Start a online game</button>
      <popup class="popup" v-if="showPopup2">
        <div class="lobbyDetail" :style="{display: showPopup2 ? 'block' : 'none'}">
          <div class="lobbyContent">
            <span @click="showPopup2 = !showPopup2" class="close">&times;</span>
            <DetailOnlineGame></DetailOnlineGame>
          </div>
        </div>
      </popup>



      <div class="input">
        <h1 id="join" class="h1">Join Lobby:</h1>
        <input>
        <button @click="showPopup3 = !showPopup3">Join</button>
      </div>
      <popup class="popup" v-if="showPopup3">
        <div class="lobbyDetail" :style="{display: showPopup3 ? 'block' : 'none'}">
          <div class="lobbyContent">
            <span @click="showPopup3 = !showPopup3" class="close">&times;</span>
            <detail-lobby></detail-lobby>
          </div>
        </div>
      </popup>


    </div>

  </div>

  <div class="background">
    <img src="../assets/Ludobackground.png">
  </div>

</template>

<script>
import DetailOnlineGame from "@/components/DetailOnlineGame.vue";
import DetailOfflineGame from "@/components/DetailOfflineGame.vue";
import DetailLobby from "@/components/DetailLobby.vue";
import NavBar from "@/components/NavBar.vue";

export default {
  name: "DashboardScreen",
  components: {NavBar, DetailOnlineGame, DetailOfflineGame, DetailLobby},
  data() {
    return {
      showPopup1: false,
      showPopup2: false,
      showPopup3: false,
    }
  },

}
</script>


<style scoped>

.screen{
  display: flex;
  flex-direction: column;
  align-items: center;
}

.card {
  display: flex;
  flex-direction: column;
  margin-top: 50px;
  align-items: center;
  background: white;
  width: 50%;
}

button {
  margin-top: 50px;
}

.lobbyContent {
  background-color: #fefefe;
  margin: 15% auto; /* 15% from the top and centered */
  padding: 20px;
  border: 1px solid #888;
  width: 80%; /* Could be more or less, depending on screen size */
}

.lobbyDetail {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  left: 0;
  top: 0;
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
  width: 800px;
}

.close {
  color: #aaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: black;
  text-decoration: none;
  cursor: pointer;
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


.input {
  margin-top: 50px;
  text-align: center;
  margin-bottom: 20px;
}


</style>