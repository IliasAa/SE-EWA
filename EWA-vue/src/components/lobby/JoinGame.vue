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
        <popup class="popup" v-if="showPopup1">
          <div class="lobbyDetail" :style="{display: showPopup1 ? 'block' : 'none'}">
            <div class="lobbyContent">
              <span @click="showPopup1 = !showPopup1" class="close">&times;</span>
              <div class="playerColor">
                <p>Choose a starting color:</p>
                <button class="playerColorButton" :class="{ active: selectedColor === 'red'}"
                        id="playerRed" @click="colorChoosing('red')">Red
                </button>
                <button class="playerColorButton" :class="{ active: selectedColor === 'blue'}"
                        id="playerBlue" @click="colorChoosing('blue')">Blue
                </button>
                <button class="playerColorButton" :class="{ active: selectedColor === 'yellow'}"
                        id="playerYellow" @click="colorChoosing('yellow')">Yellow
                </button>
                <button class="playerColorButton" :class="{ active: selectedColor === 'green'}"
                        id="playerGreen" @click="colorChoosing('green')">Green
                </button>
                <button class="btn btn-primary btn-sm play" @click="Joingame(join_code)">&#9658;</button>
              </div>
            </div>
          </div>
        </popup>
        <button class="btn btn-primary btn-lg" @click="showPopup1 = !showPopup1">Join a lobby using a code</button>
        <!--        <button class="btn btn-info" @click="Joingame(this.join_code)">Join a lobby using a code</button>-->
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
              <button class="btn btn-primary btn-lg" @click="showPopup2 = !showPopup2">&#9658;</button>
            </td>
            <popup class="popup" v-if="showPopup2">
              <div class="lobbyDetail" :style="{display: showPopup2 ? 'block' : 'none'}">
                <div class="lobbyContent">
                  <span @click="showPopup2 = !showPopup2" class="close">&times;</span>
                  <div class="playerColor">
                    <p>Choose a starting color:</p>
                    <button class="playerColorButton" :class="{ active: selectedColor === 'red'}"
                            id="playerRed" @click="colorChoosing('red')">Red
                    </button>
                    <button class="playerColorButton" :class="{ active: selectedColor === 'blue'}"
                            id="playerBlue" @click="colorChoosing('blue')">Blue
                    </button>
                    <button class="playerColorButton" :class="{ active: selectedColor === 'yellow'}"
                            id="playerYellow" @click="colorChoosing('yellow')">Yellow
                    </button>
                    <button class="playerColorButton" :class="{ active: selectedColor === 'green'}"
                            id="playerGreen" @click="colorChoosing('green')">Green
                    </button>
                  </div>
                </div>
              </div>
              <button class="btn btn-primary btn-sm play" @click="Joingame(game.join_code)">&#9658;</button>
            </popup>
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
      join_code: "",
      selectedColor: null,
      lobby: null,

      users: [],
      selectedColorsinLobby: [],
      showPopup1: false,
      showPopup2: false,
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

    colorChoosing(color) {
      this.selectedColor = color;
    },
    //Async method to join a game using a join code of that lobby
    async Joingame(join_code) {
      //saves the response and send it to the User_has_lobby.

      //dummy data to test combination between user and lobby
      //this has to be removed if the selectColor pop-up is implemented
      const selectedcolor = this.selectedColor;

      const createdLobby = await this.lobbyService.asyncFindByjoincode(join_code);
      this.selectedColorsinLobby = await this.lobbyService.asyncFindColorToLobby(createdLobby[0].idLobby)
      for (let i = 0; i < this.selectedColorsinLobby.length; i++) {
        if (this.selectedColorsinLobby[i] === selectedcolor){
          alert("color has already been selected")
          break;
        } else {
          await this.lobbyService.combineUserWithLobby(this.userId, createdLobby[0].idLobby, selectedcolor);
          //Push router to lobby with join code so it will see it in the params
          this.$router.push("/lobby/" + createdLobby[0].join_code)
        }

      }



    },

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
.playerColor {
  background-color: white;
  text-align: center;
  margin: 10px;
  border: solid blue;
  border-radius: 12px;
}
</style>
