<template>
  <NavBar></NavBar>
  <div class="screen">

    <div class="card">
      <div class="input">
        <v-banner>
          <h1 id="join" class="h1">Join Lobby</h1>
          <v-text-field label="Lobby Code"></v-text-field>
<!--          <button @click="earthPressed" class="joinButton">Join</button>-->
          <button @click="showPopup3 = !showPopup3">Join</button>
        </v-banner>
      </div>

<!--      <div v-if="showModal"-->
<!--           id="myModal" class="modal">-->
<!--        <div class="modal-content">-->
<!--          <div class="modal-header border-none mb-0">-->
<!--            <h2 class="">Hva Ludo king</h2>-->
<!--            <span class="close" @click="earthPressed">&times;</span>-->
<!--          </div>-->
<!--          <h2 class="mb-2 text-xl text-green-800 mt-0 font-bold">Hoe werkt deze site?</h2>-->
<!--          <p>> Maak een-->
<!--            <router-link class="underline" to="/registreren">account</router-link>-->
<!--            aan en log in. Je kan dan een lobby aanmaken of een bestaande lobby joinen.-->
<!--            <router-link class="underline" to=""></router-link>-->
<!--            test test-->
<!--          </p>-->
<!--          <h2 class="mb-2 text-xl text-green-800 mt-4 font-bold">Moet ik een student zijn?</h2>-->
<!--          <p>> Nee natuurlijk niet! Iedereen is welkom om te werken aan de-->
<!--            <a class="underline" href="" target="_blank"></a></p>-->
<!--          <div class="modal-footer mt-3">-->
<!--            <h3>Als je nog meer vragen hebt kan je de rechtsonder de chatbot gebruiken!</h3>-->
<!--          </div>-->
<!--        </div>-->
<!--      </div>-->

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
      <popup class="popup" v-if="showPopup2" v-on:click="new LobbyCode()">
        <div class="lobbyDetail" :style="{display: showPopup2 ? 'block' : 'none'}">
          <div class="lobbyContent">
            <span @click="showPopup2 = !showPopup2" class="close">&times;</span>
            <DetailOnlineGame></DetailOnlineGame>
          </div>
        </div>
      </popup>
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
import DetailOnlineGame from "@/components/details/DetailOnlineGame.vue";
import DetailOfflineGame from "@/components/details/DetailOfflineGame.vue";
import DetailLobby from "@/components/details/DetailLobby.vue";
import NavBar from "@/components/NavBar.vue";
import {Lobby} from "@/models/Lobby";

export default {
  name: "DashboardScreen",
  components: {NavBar, DetailOnlineGame, DetailOfflineGame, DetailLobby},
  data() {
    return {
      showPopup1: false,
      showPopup2: false,
      showPopup3: false,
      showModal: false,
      lobby: ""
    }
  },
  methods: {
    LobbyCode(){
      this.lobby.push(Lobby.creatSampleLobby())
    },
    // earthPressed() {
    //   this.showModal = !this.showModal;
    //   return this.showModal;
    // },
    created() {

    }
  }

}
</script>


<style scoped>

.modal {
  display: block; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0, 0, 0); /* Fallback color */
  background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

.modal-content {
  background-color: #fefefe;
  margin: 13% auto; /* 15% from the top and centered */
  padding: 20px;
  border: 1px solid #888;
  width: 50%; /* Could be more or less, depending on screen size */
}

.joinButton {
  font-weight: bold;
  font-size: large;
}

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
  display: flex;
  flex-direction: column;
}

input {
  background: #F2F2F2;
}

.btn{
  margin-left: 7px;
  margin-bottom: 30px;
}

.card-buttons {
  margin-top: 3%;
}
</style>