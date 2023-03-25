<template>
  <div class="lobby">
    <h1>Waiting for host to start the game:</h1>
    <div class="players">
      <h2>Players:</h2>
      <p>jan</p>
      <p>Erik</p>
      <p>maike</p>
    </div>

  </div>

</template>

<script>
export default {
  name: "DetailLobby"
}
</script>

<style scoped>
.lobby {
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