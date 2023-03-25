<template>
  <div class="body">
<h1>Game lobby</h1>
  <p>lobby code: G23UI6</p>
    <div class="players">
      <h2>Joint game:</h2>
      <p>Jan</p>
      <p>Erik</p>
      <p>Nienke</p>
    </div>


    <router-link to="/gamepage">
      <button>start game</button>
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