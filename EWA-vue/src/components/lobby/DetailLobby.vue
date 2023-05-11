<template>
  <NavBar></NavBar>
  <div class="wrapper">
    <main class="page-main">
      <div class="container flex-column">
        <router-link to="/Dashboard"><img src="../../assets/back.png" class="back-button"></router-link>

        <h1>Active game {{ this.lobbyCode }}</h1>

        <h4>host : {{ this.host.username }} </h4>

        <table class="table">
          <thead>
          <tr>
            <th scope="col">Username</th>
            <th scope="col">Points</th>
            <th scope="col">SelectedColor</th>
          </tr>
          </thead>
          <tbody>

          <tr v-for="user in this.users" :key="user.userId">
            <td>{{ user.username }}</td>
            <td>{{ user.points }}</td>
          </tr>
          </tbody>
        </table>
        <button class="btn btn-info" @click="startGame()">Start game</button>
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
  name: "DetailLobby",
  components: {NavBar},
  inject: ['lobbyService'],
  data() {
    return {
      lobbyCode: null,
      lobby: null,
      users: [],
      host: null,
    }
  },
  async created() {
    //get the lobby code from route param and finds associated lobby
    this.lobbyCode = this.$route.params.joincode;
    this.lobby = await this.lobbyService.asyncFindByjoincode(this.lobbyCode);
    let ownerid = this.lobby[0].userid_owner;
    this.host = await this.lobbyService.asyncFindId(ownerid);
    this.users = await this.lobbyService.asyncFindAllConnectedToLobby(this.lobby[0].idLobby)

  },

  methods: {
    async startGame() {
      this.lobby[0].lobby_status = 1;
      await this.lobbyService.asyncUpdate(this.lobby[0]);
      this.$router.push("/gamepage");
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