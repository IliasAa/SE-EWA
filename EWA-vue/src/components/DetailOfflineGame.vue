<template>
  <div class="body">
    <h1>Offline Game</h1>
    <p>AI bots:</p>
    <button>-</button> <input> <button>+</button>
    <router-link to="/gamepage">
      <button>Start game</button>
    </router-link>
  </div>

</template>

<script>
export default {
  name: "DetailOfflineGame",
  data(){
    return {

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