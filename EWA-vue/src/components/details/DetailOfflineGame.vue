<template>
  <div class="body">
    <h1>Offline Game</h1>
    <p>AI bots:</p>
    <p>{{players}}</p>
    <button @click="maxPlayer()" v-on:click="players= 0">-</button><button @click="maxPlayer()" v-on:click="players++">+</button>
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
  background: lightskyblue;
  border: solid blue;
  max-width: 500px;
  height: 300px;

}
</style>