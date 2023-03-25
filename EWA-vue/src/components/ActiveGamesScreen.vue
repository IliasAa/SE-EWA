<template>
  <NavBar></NavBar>
  <div class="wrapper">
    <main class="page-main">
      <div class="container flex-column">
        <table class="table">
<!--          <h3 class="table-header">List of Active Games</h3>-->
          <thead>
            <tr>
              <th scope="col">GameID</th>
              <th scope="col">Creator</th>
              <th scope="col">Participants</th>
              <th scope="col">Start</th>
              <th scope="col">Delete</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="game in games" :key="game.name">
              <td>{{ game.name }}</td>
              <td>{{ game.creator }}</td>
              <td>{{ game.participants + "/4" }}</td>
              <td><button class="btn btn-primary btn-sm play" @click="startGame">&#9658;</button></td>
              <td><button class="btn btn-danger btn-sm delete" @click="deleteGame(game)">&times;</button></td>
            </tr>
          </tbody>
        </table>
        <button class="btn btn-info" @click="newGame">New Game</button>
      </div>
    </main>
  </div>
</template>

<script>
import NavBar from "@/components/NavBar.vue";

export default {

  name: "ActiveGamesScreen",
  components: {NavBar},
  data() {
    return {
      games: [
        { name: 'Hx7YbNIX', creator: 'Rinus243', participants: 2 },
        { name: '0AH40uDJ', creator: 'PieterVDE1', participants: 4 },
        { name: 'S2oi2Ah3', creator: 'AlexGames123', participants: 1 }
      ]
    }
  },
  methods: {
    startGame() {
      this.$router.push({ path: '/gamepage', replace: true })
    },
    newGame() {
      this.games.push({
        name: this.makeId(8).toString(),
        creator: 'PelleVKV',
        participants: Math.floor(Math.random() * (4 + 1))
      })
    },
    deleteGame(game) {
      this.games.splice(this.games.indexOf(game), 1)
    },
    makeId(length) {
      let result = '';
      const characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
      const charactersLength = characters.length;
      let counter = 0;
      while (counter < length) {
        result += characters.charAt(Math.floor(Math.random() * charactersLength));
        counter += 1;
      }
      return result;
    }
  }
}
</script>

<style scoped>

.wrapper {
  display: flex;
  flex-direction: column;
  backdrop-filter: blur(20%);
  min-height: 100vh;
  background-image: url("../assets/Ludobackground.png");
  background-position: center;
  background-size: cover;
  background-color: #080931;
  font-family: "Arial Hebrew";
}

.wrapper > * {
  padding: 20px;
  overflow: hidden;
}
.page-main {
  flex-grow: 1;
  backdrop-filter: blur(10px);
}
img {
  max-width: 100%;
  height: auto;
}
.table-header {
  text-align: center;
}
.container {
  display: flex;
  width: 100vh;
  background-color: white;
  padding: 3%;
  margin-top: 7%;
}
.delete, .play {
  border-radius: 50%;
  text-align: center;
}
.play {
  padding-left: 10px;
}
</style>
