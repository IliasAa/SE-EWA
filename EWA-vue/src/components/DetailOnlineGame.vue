<template>
  <div class="body">
<h1>Game lobby</h1>

  <p>Lobby code:</p><p>niu323</p>
  <h2>Joint game:</h2>
  <p>Jan</p>
  <p>Erik</p>
  <p>Nienke</p>
    <router-link to="/gamepage" v-if="this.players >= 1">
      <button>strart game</button>
    </router-link>
    <p v-else>there has to he a minimal of one joint players</p>
  </div>
</template>

<script>
export default {
  name: "DetailOnlineGame",
  data(){
    return {
      tag: [],
      players: 3
    }
  },
  createTag(){
    let tag = "";
    const char = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    const lenght = 8;

    for (let i = 0; i < lenght; i++) {
      tag += char.charAt(Math.random() * char.length);
    }

    return tag;
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
  height: 350px;
}
button {
  background-color: dodgerblue;
  border-radius: 12px;
}
</style>