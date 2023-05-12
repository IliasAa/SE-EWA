<template>
  <NavBar></NavBar>
  <div class="wrapper">
    <main class="page-main">
      <div class="container flex-column">
        <router-link to="/Dashboard"><img src="../../assets/back.png" class="back-button"></router-link>
        <table class="table">
          <thead>
          <tr>
            <th scope="col">GameID</th>
            <th scope="col">Creator</th>
            <th scope="col">Participants</th>
            <th scope="col">Join game</th>
            >
          </tr>
          </thead>
          <tbody>
          <tr v-for="game in games" :key="game.id">
            <td>{{ game.idLobby }}</td>
            <td>{{ this.lobbyCreators.username }}</td>
            <td>{{ game.player_size + "/" + game.max_allowed_Players }}</td>
            <td>
              <button class="btn btn-primary btn-sm play" @click="Joingame(game.join_code)">&#9658;</button>
            </td>
          </tr>
          </tbody>
        </table>
        <button class="btn btn-info" @click="newGame">Join a lobby using a code</button>
      </div>
    </main>
  </div>

  <div class="background">
    <img src="../../assets/Ludobackground.png">
  </div>
</template>

<script>
import NavBar from "@/components/NavBar.vue";

export default {

  name: "ActiveGamesScreen",
  components: {NavBar},
  inject: ['lobbyService', 'userService'],

  data() {
    return {
      games: [],
      creatorNames: [],
      lobbyCreators: [],
      user: null,
      userId: null,

    }
  },
  async created() {
    this.games = await this.lobbyService.asyncFindAll();
    this.user = await this.userService.asyncGetInfo();
    this.userId = this.user.userId;


    //this is to avoid seeing games that you made yourself.
    for (let i = 0; i < this.games.length; i++) {
      console.log(this.games[i].userid_owner);
      if (this.games[i].userid_owner === this.userId) {
        this.games.splice(i, 1);
      }
    }

    //this is to find the username of all the lobby owners so it will show in the lobby browser.
    for (let i = 0; i < this.games.length; i++) {
      let lobbyOwnerId = this.games[i].userid_owner;
      this.lobbyCreators[i] = await this.lobbyService.asyncFindId(lobbyOwnerId)
    }

  },

  methods: {
    //Async method to join a game using a join code of that lobby
    async Joingame(join_code) {
      //saves the response and send it to the User_has_lobby.
      const createdLobby = await this.lobbyService.asyncFindByjoincode(join_code);
      await this.lobbyService.combineUserWithLobby(this.userId, createdLobby[0].idLobby);
      //Push router to lobby with join code so it will see it in the params
      this.$router.push("/lobby/" + createdLobby[0].join_code)
    }
  }
}
</script>

<style scoped>
.back-button {
  height: 30px;
  width: 30px;
}

.page-main {
  flex-grow: 1;
  backdrop-filter: blur(10px);
}

.container {
  display: flex;
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

.background, .background img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  object-position: bottom;
  position: absolute;
  top: 0;
  left: 0;
  z-index: -1000;
  filter: brightness(0.7);
  background-color: rgba(5, 11, 98, 1);
}
</style>
