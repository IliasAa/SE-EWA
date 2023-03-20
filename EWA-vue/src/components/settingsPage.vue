<template>
  <body>
  <NavBar></NavBar>
  <div class="form-container">
    <div class="card-title">
      <h1>Ludo Game Settings</h1>
    </div>

    <form>
      <div class="form-group">
        <label for="num-players">Number of Players:</label>
        <input type="number" id="num-players" name="num-players" min="2" max="4" value="2">
      </div>
      <div class="form-group">
        <label for="game-mode">Game Mode:</label>
        <select id="game-mode" name="game-mode">
          <option value="classic">Classic</option>
          <option value="quick">Quick</option>
          <option value="chaos">Chaos</option>
        </select>
      </div>
      <div class="form-group">
        <label for="dark-mode">Dark Mode:</label>
        <input type="checkbox" id="dark-mode" name="dark-mode">
      </div>
      <div class="form-group">
        <label for="sound-effects">Sound Effects:</label>
        <input type="checkbox" id="sound-effects" name="sound-effects" checked>
      </div>
      <div class="form-group">
        <label for="music">Music:</label>
        <input type="checkbox" id="music" name="music" checked>
      </div>
      <div class="form-group">
        <input type="submit" value="Save Settings">
      </div>
    </form>
  </div>
  </body>
</template>

<script>
import NavBar from "@/components/NavBar.vue";
export default {
  name: "settingsPage.vue",
  components: {NavBar},
}
</script>

<style scoped>
body {
  background-color: rgba(5, 11, 98, 1);
  padding-bottom: 30px;
}
.card-title {
  display: flex;
  justify-content: center;
  align-content: center;

}
h1 {
  text-align: center;
  color: white;
  background-color: #002B7F;
  width: 500px;
  padding-top: 10px;
  padding-bottom: 10px;
  border-radius: 10px;

}

div.form-container {
   margin-top: 50px;
 }
.form-container {
  width: 80%;
  margin: 0 auto;
  background-color: #fff;
  border-radius: 10px;
  padding: 30px;
  box-shadow: 0px 0px 10px #888888;
}
.form-group {
  margin-bottom: 20px;
}
label {
  display: block;
  margin-bottom: 10px;
  font-weight: bold;
}
input[type="number"] {
  width: 100%;
  padding: 10px;
  border-radius: 5px;
  border: 1px solid #ccc;
}
input[type="submit"] {
  background-color: #002B7F;
  color: #fff;
  border: none;
  border-radius: 5px;
  padding: 10px 20px;
  cursor: pointer;
  font-size: 16px;
}
input[type="submit"]:hover {
  background-color: #4b4d50;
}
</style>