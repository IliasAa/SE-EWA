<template>
  <div class="body">
<h1>Game lobby</h1>
  <p class="lobbyTitle">Lorem ipsum dolor sit amet</p>
  <h2>Joined game:</h2>
  <p id="p1Color">Jan</p>
  <p id="p2Color">Erik</p>
  <p id="p3Color">Nienke</p>
    <router-link to="/gamepage" class="startLink">
      <button>Start game</button>
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

h1, h2 {
  margin-bottom: 8%;
  color: white;
}

h2 {
  margin-top: 3%;
  color: white;
}

p {
  font-weight: bold;
  color: white;
  background-color: black;
  width: 50%;
  padding: 5px;
  border-radius: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.lobbyTitle {
  width: 100%;
}

#p1Color {
  background-color: red;
  color: black;
}

#p2Color {
  background-color: yellow;
  color: black;
}

#p3Color {
  background-color: blue;
  color: black;
}

.body {
  display: flex;
  flex-direction: column;
  background: #0b5ed7;
  max-width: 500px;
  height: 500px;
  border-radius: 10px;
  padding: 10px;
  margin-left: 6%;
}

.startLink {
  display: flex;
  justify-content: center;
  align-items: center;
  position: absolute;
  top: 64%;
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

</style>