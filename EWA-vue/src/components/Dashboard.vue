<template>
  <NavBar></NavBar>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <div class="container-center-horizontal">
    <div class="macbook-pro-16-log-in screen">
      <div class="container">
        <div id="select" class="overlap-group">
          <div class="row">

            <div class="col">
              <h1 id="offline" class="h1">offline game</h1>
              <button @click="showPopup1 = !showPopup1">Start a offline game</button>
              <popup class="popup" v-if="showPopup1">
                <div class="lobbyDetail"  :style="{display: showPopup1 ? 'block' : 'none'}">
                  <div class="lobbyContent">
                    <span @click="showPopup1 = !showPopup1" class="close">&times;</span>
                    <DetailOfflineGame></DetailOfflineGame>
                  </div>
                </div>
              </popup>
            </div>

            <div class="col">
              <h1 id="online" class="h1">online game</h1>
              <button @click="showPopup2 = !showPopup2">Start a online game</button>
              <popup class="popup" v-if="showPopup2">
                <div class="lobbyDetail"  :style="{display: showPopup2 ? 'block' : 'none'}">
                  <div class="lobbyContent">
                    <span @click="showPopup2 = !showPopup2" class="close">&times;</span>
                    <DetailOnlineGame></DetailOnlineGame>
                  </div>
                </div>
              </popup>
            </div>

          </div>

          <div class="lobby">
            <h1 id="join" class="h1">Join Lobby:</h1>
            <div class="input">
              <input> <button @click="showPopup3 = !showPopup3">Join</button>
            </div>
            <popup class="popup" v-if="showPopup3">
              <div class="lobbyDetail"  :style="{display: showPopup3 ? 'block' : 'none'}">
                <div class="lobbyContent">
                  <span @click="showPopup3 = !showPopup3" class="close">&times;</span>
                  <detail-lobby></detail-lobby>
                </div>
              </div>
            </popup>
          </div>

        </div>
      </div>
    </div>
  </div>

</template>

<script>
import DetailOnlineGame from "@/components/DetailOnlineGame.vue";
import DetailOfflineGame from "@/components/DetailOfflineGame.vue";
import DetailLobby from "@/components/DetailLobby.vue";
import NavBar from "@/components/NavBar.vue";
export default {
  name: "DashboardScreen",
  components: {NavBar,DetailOnlineGame, DetailOfflineGame, DetailLobby},
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
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
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

/*Screen css*/
.macbook-pro-16-log-in {
  background-color: rgba(5, 11, 98, 1);
  background-image: url("@/assets/Ludo background.png");
  background-position: 40% 40%;
  min-height: 46.8vw;
}

.lobby {
  text-align: center;
}

.row {
  border: solid blue;
  max-width: 1200px;
  text-align: center;
  border-radius: 12px;
}

.h1 {
  color: thistle;
}

#join {
  margin-top: 50px;
  text-align: center;
}

.input {
  text-align: center;
}

.col {
  margin-top: 50px;
  margin-bottom: 50px;
}
button{
  font-size: larger;
  border-radius: 12px;
  background-color: lightskyblue;
  border: solid purple;
}
</style>