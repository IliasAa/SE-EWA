<template>
  <div class="body">
<h1>Game lobby</h1>
  <p>hoi</p>
  <h2>Joint game:</h2>
  <p>Jan</p>
  <p>Erik</p>
  <p>Nienke</p>
    <router-link to="/gamepage">
      <button>strart game</button>
    </router-link>
  </div>
</template>

<script>
export default {
  name: "DetailOnlineGame",
  data(){
    return {
      tag: []
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