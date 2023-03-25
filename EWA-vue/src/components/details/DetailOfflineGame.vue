<template>
  <div class="body">
    <h1>Offline Game</h1>
    <div class="players">
      <p>AI bots:</p>
      <p>{{players}}</p>
      <button @click="maxPlayer()" v-on:click="players= 0">-</button><button @click="maxPlayer()" v-on:click="players++">+</button>
    </div>


    <router-link to="/gamepage" v-if="this.players >= 1">
      <p></p>
      <button>Start game</button>
    </router-link>
    <p v-else>there has to he a minimal of one AI bot</p>

  </div>

</template>

<script>

export default {
  name: "DetailOfflineGame",
  data(){
    return {
      players: 0
    }
  },
  methods: {
    maxPlayer(){
      if (this.players < 0){
        return this.players = 1;
      }
      if (this.players > 2){
        return this.players = 2;
      }
    }
  }
}
</script>

<style scoped>
.body {
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
</style>