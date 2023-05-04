<template>
  <NavBar></NavBar>
  <div class="screen">

    <div class="card">
<!--      <div class="input">-->
<!--        <v-banner>-->
<!--          <h1 id="join" class="h1">Join Lobby</h1>-->
<!--          <v-text-field label="Lobby Code"></v-text-field>-->
<!--&lt;!&ndash;          <button @click="earthPressed" class="joinButton">Join</button>&ndash;&gt;-->
<!--          <button @click="showPopup3 = !showPopup3">Join</button>-->
<!--        </v-banner>-->
<!--      </div>-->


      <router-link to="/Dashboard"><img src="../../assets/back.png" class="back-button"></router-link>


      <div class="card-buttons">

      <button class="btn btn-primary btn-lg" @click="showPopup1 = !showPopup1">Host Offline Game</button>
      <popup class="popup" v-if="showPopup1">
        <div class="lobbyDetail" :style="{display: showPopup1 ? 'block' : 'none'}">
          <div class="lobbyContent">
            <span @click="showPopup1 = !showPopup1" class="close">&times;</span>
            <DetailOfflineGame></DetailOfflineGame>
          </div>
        </div>
      </popup>


      <button class="btn btn-primary btn-lg" @click="showPopup2 = !showPopup2">Host Online Game</button>
      <popup class="popup" v-if="showPopup2">
        <div class="lobbyDetail" :style="{display: showPopup2 ? 'block' : 'none'}">
          <div class="lobbyContent">
            <span @click="showPopup2 = !showPopup2" class="close">&times;</span>
            <DetailOnlineGame></DetailOnlineGame>
          </div>
        </div>
      </popup>
      </div>
    </div>

  </div>

  <div class="background">
    <img src="../../assets/Ludobackground.png">
  </div>

</template>

<script>
import DetailOnlineGame from "@/components/details/DetailOnlineGame.vue";
import DetailOfflineGame from "@/components/details/DetailOfflineGame.vue";
import NavBar from "@/components/NavBar.vue";
import LobbyRepo from "@/reposetory/lobbyRepo";

export default {
  name: "DashboardScreen",
  components: {NavBar, DetailOnlineGame, DetailOfflineGame},
  data() {
    return {
      lobbyRepo: new LobbyRepo(),
      showPopup1: false,
      showPopup2: false,
    }
  },
}
</script>


<style scoped>


.back-button {
  height: 30px;
  width: 30px;
}
.screen{
  display: flex;
  flex-direction: column;
  align-items: center;
}

.card {
  margin-top: 50px;
  background: white;
  width: 50%;
  z-index: 1;
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
  border-radius: 20px;
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

.btn{
  margin-left: 7px;
  margin-bottom: 30px;
}

.card-buttons {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 3%;
}
</style>