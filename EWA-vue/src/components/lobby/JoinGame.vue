<template>
  <NavBar></NavBar>
  <div class="wrapper">
    <main class="page-main">
      <div class="container flex-column">
        <router-link to="/Dashboard"><img src="../../assets/back.png" class="back-button"></router-link>
        <v-text-field
            label="Lobby code"
            type="text"
            v-model="join_code"
        ></v-text-field>
        <button class="btn btn-info" @click="Joingame(this.join_code)">Join a lobby using a code</button>
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
          <tr v-for="(game) in games" :key="game">
            <td>{{ game.idLobby }}</td>
            <td>{{game.creatorNames}}</td>
            <td>{{ game.player_size + "/" + game.max_allowed_Players }}</td>
            <td>
              <button class="btn btn-primary btn-sm play" @click="Joingame(game.join_code)">&#9658;</button>
            </td>
          </tr>
          </tbody>
        </table>
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
      allgames: [],
      creatorNames: [],
      lobbyCreators: [],
      user: null,
      userId: null,
      mygames: [],
      games: [],
      join_code: ""
    }
  },
  async created() {
    this.allgames = await this.lobbyService.asyncFindAll();
    this.user = await this.userService.asyncGetInfo();
    this.userId = this.user.userId;
    console.log(this.allgames)


    // This is to avoid seeing games that you made yourself and it will only show the games that did not start yet.
    for (let i = 0; i < this.allgames.length; i++) {
      if (this.allgames[i].lobby_status === 0) {
        if (this.allgames[i].userid_owner === this.userId) {
          this.mygames.push(this.allgames[i]);
        } else {
          this.games.push(this.allgames[i]);
        }
      }
    }

    //this is to find the username of all the lobby owners so it will show in the lobby browser.
    for (let i = 0; i < this.games.length; i++) {
      if (this.games[i].userid_owner !== 0 && this.games[i].userid_owner !== null) {
        this.lobbyCreators.push(await this.userService.asyncFindId(this.games[i].userid_owner))
      } else {
        this.lobbyCreators.push("Bugged user")
      }
    }

    //saves the creatorname in games variable.
    for (let i = 0; i < this.allgames.length; i++) {
      this.games[i].creatorNames = this.lobbyCreators[i].username
    }
  },

  methods: {
    //Async method to join a game using a join code of that lobby
    async Joingame(join_code) {
      //saves the response and send it to the User_has_lobby.
      const createdLobby = await this.lobbyService.asyncFindByjoincode(join_code);



      //dummy data to test combination between user and lobby
      //this has to be removed if the selectColor pop-up is implemented
      const selectedcolor = "green";


      console.log(this.userId);
      console.log(createdLobby);
      console.log(createdLobby[0].idLobby);

      await this.lobbyService.combineUserWithLobby(this.userId, createdLobby[0].idLobby, selectedcolor);

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
  margin-bottom: 10px;
}

.page-main {
  flex-grow: 1;
}

.container {
  display: flex;
  background-color: white;
  padding: 3%;
  margin-top: 7%;
  border-radius: 10px;
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
