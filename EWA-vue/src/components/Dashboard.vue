<template>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <div class="container-center-horizontal">
    <div class="macbook-pro-16-log-in screen">
      <div id="select" class="overlap-group">
        <img class="image-11" src="../assets/Hvalogo.png" alt="image 11"/>
        <div class="row">

          <div class="col">
            <h1 id="offline" class="h1">offline game</h1>
            <button @click="showPopup1 = !showPopup1">Start a offline game</button>
            <popup v-if="showPopup1">
              <DetailOfflineGame></DetailOfflineGame>
            </popup>
          </div>

          <div class="col">
            <h1 id="online" class="h1">online game</h1>
            <button @click="showPopup2 = !showPopup2">Start a online game</button>
            <popup v-if="showPopup2">
              <DetailOnlineGame></DetailOnlineGame>
            </popup>
          </div>
        </div>
        <h1 class="h1">Join Lobby:</h1>
        <input> <button @click="showPopup3 = !showPopup3">Join</button>
        <popup v-if="showPopup3">
          <DetailLobby></DetailLobby>
        </popup>
      </div>
    </div>
  </div>

</template>

<script>
import DetailOnlineGame from "@/components/DetailOnlineGame.vue";
import DetailOfflineGame from "@/components/DetailOfflineGame.vue";
import DetailLobby from "@/components/DetailLobby.vue";
export default {
  name: "DashboardScreen",
  components: {DetailOnlineGame, DetailOfflineGame, DetailLobby},
  data() {
    return {
      showPopup1: false,
      showPopup2: false,
      showPopup3: false,
    }
  }
}
</script>



<style scoped>


/*Screen css*/
.macbook-pro-16-log-in {
  background-color: rgba(5, 11, 98, 1);
}


.overlap-group {
  background-image: url("@/assets/Ludo background.png");
  background-position: 50% 50%;
  min-height: 1117px;
}

.row {
  border: solid blue;
  max-width: 800px;
}
.h1 {
  color: thistle;
  margin-left: 20px;
}
#offline {

}
</style>