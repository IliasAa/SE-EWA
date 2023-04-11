<template>
  <div class="body">
    <h1>Game lobby</h1>
    <p>lobby code: {{ lobby.LobbyCode }}</p>
    <div class="players">
      <h2>Joint game:</h2>
      <div>
        <tr v-for="(player, index) in players" :key="index">
          <td class="thumbnail">{{player.userName}}</td>
          <button onclick="removeFromList(player.userId)">kick player</button>
        </tr>
      </div>
    </div>


    <router-link to="/gamepage">
      <button>start game</button>
    </router-link>
  </div>
</template>

<script>
import {User} from "@/models/user";
import {Lobby} from "@/models/Lobby";
// import {Lobby} from "@/models/Lobby";

export default {
  name: "DetailOnlineGame",
  data(){
    return {
      tag: [],
      players: [],
      lobby: [],
    }
  },
  created() {
    for (let i = 0; i < 3; i++) {
      this.players.push(User.createSampleUser(this.playerNumber))
    }
    this.lobby.push(Lobby.creatSampleLobby())
  },

  methods: {
    playerNumber() {
      let number = 0;

      if (this.players.length === 0){
        return 0;
      } else {
        number = this.players.length;
      }
      return number;
    },
    removeFromList(userId){
      this.players = this.players.filter(player => player.userId !== userId);
    }
  }
}

</script>

<style scoped>
.body {
  border-radius: 20px;
  text-align: center;
  background: dodgerblue;
  border: solid blue;
  max-width: 500px;
  height: 350px;
}
.players {
  background-color: white;
  text-align: center;
  margin: 10px;
  border: solid blue;
  border-radius: 12px;
}
button {
  background-color: #002B7F;
  color: white;
  border: solid blue;
  padding: 5px;
}
h2 {
  text-decoration: underline;

}
</style>