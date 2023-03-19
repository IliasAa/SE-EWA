<template>
  <div class="body">
<h1>Game lobby</h1>
  <p>1HG6I97</p>
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
  name: "DetailOnlineGame"
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