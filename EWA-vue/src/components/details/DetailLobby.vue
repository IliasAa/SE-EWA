<template>
  <div class="lobby">
    <h1>Waiting for host to start the game:</h1>
    <div class="players">
      <h2>Players:</h2>
      <p>jan</p>
      <p>Erik</p>
      <p>maike</p>
<!--      <tr v-for="(playerName) in players" :key="playerName" :class="{'selected': player === playerName}">-->
<!--        <td class="thumbnail">{{players.username}}</td>-->
<!--      </tr>-->
    </div>

  </div>

</template>

<script>
import {FakeUser} from "@/models/FakeUser";

export default {
  name: "DetailLobby",
  inject: ['userService', 'SessionService'],
  data(){
    return {
      // User: new UserAdaptor().asyncFindAll(),
      tag: [],
      players: [],
      // lobby: [],
      player: FakeUser
    }
  },
  created() {

    for (let i = 0; i < 3; i++) {
      this.players.push(FakeUser.createSampleUser(this.playerNumber))
      console.log(this.players)
    }
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
    removeFromList(){
      this.players = this.players.filter(player => player);
    }
  }
}
</script>

<style scoped>
.lobby {
  border-radius: 20px;
  text-align: center;
  background: dodgerblue;
  border: solid blue;
  max-width: 500px;
  height: 300px;
}
.players {
  background-color: white;
  text-align: center;
  margin: 10px;
  border: solid blue;
  border-radius: 12px;
}
h2 {
  text-decoration: underline;
}
</style>