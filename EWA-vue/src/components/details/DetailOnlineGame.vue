<template>
  <div class="body">
<h1>Game lobby</h1>
  <p>lobby code: G23UI6</p>
    <div class="players">
      <h2>Joint game:</h2>
      <tr v-for="(playerName) in players" :key="playerName" :class="{'selected': player === playerName}">
        <td class="thumbnail">{{players.}}</td>
      </tr>
    </div>


    <router-link to="/gamepage">
      <button>start game</button>
    </router-link>
  </div>
</template>

<script>
import {User} from "@/models/user";

export default {
  name: "DetailOnlineGame",
  data(){
    return {
      tag: [],
      players: [],
      player: User
    }
  },
  created() {
    for (let i = 0; i < 3; i++) {
      this.players.push(User.createSampleUser(this.playerNumber))
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
    }
//   createTag(){
//   let tag = "";
//   const char = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
//   const lenght = 8;
//
//   for (let i = 0; i < lenght; i++) {
//     tag += char.charAt(Math.random() * char.length);
//   }
//
//   return tag;
// }
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