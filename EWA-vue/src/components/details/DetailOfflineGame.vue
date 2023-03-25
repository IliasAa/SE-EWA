<template>
  <div class="body">
    <h1>Offline Game</h1>
    <h2>AI bots:</h2>
    <button id="inputMinus">-</button>
    <input> <button id="inputPlus">+</button>
    <router-link to="/gamepage" class="startLink">
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

h1, h2 {
  margin-bottom: 6%;
  color: white;
}

p {
  color: white;
}

.body {
  display: flex;
  flex-direction: column;
  background: #0b5ed7;
  max-width: 500px;
  height: 300px;
  border-radius: 10px;
  padding: 10px;
  margin-left: 6%;
}

.startLink {
  display: flex;
  justify-content: center;
  align-items: center;
  position: absolute;
  top: 41%;
  left: 49%;
  transform: translate(-50%, -50%);
  margin-top: 5%;
  padding: 5px;
  color: white;
  font-size: x-large;
  font-style: italic;
  background-color: black;
  width: 25%;
  text-decoration: none;
  border-radius: 10px;
}

.startLink:hover {
  background-color: gray;
}

#inputMinus {
  color: red;
  font-size: x-large;
}

#inputPlus {
  color: green;
  font-size: x-large;
}
</style>