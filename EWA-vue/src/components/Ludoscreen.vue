<template>
  <NavBar></NavBar>
  <div class="container-center-horizontal">
    <div class="left-part">
      <div class="left-green">
        <div id="green_username" class="username">
          <div class="logo">
            <a href="#"><img src="../assets/icon.png" alt="Hva logo"></a>
          </div>
          <p>{{ this.greenName }}</p>
        </div>
      </div>
      <div class="left-red">
        <div id="red_username" class="username">
          <div class="logo">
            <a href="#"><img src="../assets/icon.png" alt="Hva logo"></a>
          </div>
          <p>{{ this.redName }}</p>
        </div>
      </div>
    </div>
    <div class="overlap-group">


      <div class="game">
        <div class="house green">

          <div class="box">
            <div id="1000" class="square square-one green">
              <button :disabled="hasChanged" @click="checkIfPawnOnField($event)" v-bind="this.pawns[0]"
                      class="green-pawn 1"></button>
            </div>
            <div id="1001" class="square square-two green">
              <button :disabled="hasChanged" @click="checkIfPawnOnField($event)" v-bind="this.pawns[1]"
                      class="green-pawn 2"></button>
            </div>
            <div id="1002" class="square square-three green">
              <button :disabled="hasChanged" @click="checkIfPawnOnField($event)" v-bind="this.pawns[2]"
                      class="green-pawn 3"></button>
            </div>
            <div id="1003" class="square square-four green">
              <button :disabled="hasChanged" @click="checkIfPawnOnField($event)" v-bind="this.pawns[3]"
                      class="green-pawn 4"></button>
            </div>
          </div>
        </div>
        <div class="house yellow" style="right: 0">
          <div class="box">
            <div id="2000" class="square square-one yellow">
              <button :disabled="hasChanged" @click="checkIfPawnOnField($event)" v-bind="this.pawns[4]"
                      class="yellow-pawn 1"></button>
            </div>
            <div id="2001" class="square square-two yellow">
              <button :disabled="hasChanged" @click="checkIfPawnOnField($event)" v-bind="this.pawns[5]"
                      class="yellow-pawn 2"></button>
            </div>
            <div id="2002" class="square square-three yellow">
              <button :disabled="hasChanged" @click="checkIfPawnOnField($event)" v-bind="this.pawns[6]"
                      class="yellow-pawn 3"></button>
            </div>
            <div id="2003" class="square square-four yellow">
              <button :disabled="hasChanged" @click="checkIfPawnOnField($event)" v-bind="this.pawns[7]"
                      class="yellow-pawn 4"></button>
            </div>
          </div>
        </div>
        <div class="house red" style="bottom: 0">
          <div class="box">
            <div id="3000" class="square square-one red">
              <button :disabled="hasChanged" @click="checkIfPawnOnField($event)" v-bind="this.pawns[8]"
                      class="red-pawn 1"></button>
            </div>
            <div id="3001" class="square square-two red">
              <button :disabled="hasChanged" @click="checkIfPawnOnField($event)" v-bind="this.pawns[9]"
                      class="red-pawn 2"></button>
            </div>
            <div id="3002" class="square square-three red">
              <button :disabled="hasChanged" @click="checkIfPawnOnField($event)" v-bind="this.pawns[10]"
                      class="red-pawn 3"></button>
            </div>
            <div id="3003" class="square square-four red">
              <button :disabled="hasChanged" @click="checkIfPawnOnField($event)" v-bind="this.pawns[11]"
                      class="red-pawn 4"></button>
            </div>
          </div>
        </div>
        <div class="house blue" style="bottom: 0;right: 0">
          <div class="box">
            <div id="4000" class="square square-one blue">
              <button :disabled="hasChanged" @click="checkIfPawnOnField($event)" v-bind="this.pawns[12]"
                      class="blue-pawn 1"></button>
            </div>
            <div id="4001" class="square square-two blue">
              <button :disabled="hasChanged" @click="checkIfPawnOnField($event)" v-bind="this.pawns[13]"
                      class="blue-pawn 2"></button>
            </div>
            <div id="4002" class="square square-three blue">
              <button :disabled="hasChanged" @click="checkIfPawnOnField($event)" v-bind="this.pawns[14]"
                      class="blue-pawn 3"></button>
            </div>
            <div id="4003" class="square square-four blue">
              <button :disabled="hasChanged" @click="checkIfPawnOnField($event)" v-bind="this.pawns[15]"
                      class="blue-pawn 4"></button>
            </div>
          </div>
        </div>

        <div class="home"><h2 class="dice-output">{{ output }}</h2></div>
        <div id="51" class="cells" style="top: 40%;"></div>
        <div id="0" class="cells g-start" style="top: 40%;left:6.66%;"></div>
        <div id="1" class="cells" style="top: 40%;left:13.32%;"></div>
        <div id="2" class="cells" style="top: 40%;left:19.98%;"></div>
        <div id="3" class="cells" style="top: 40%;left:26.64%;"></div>
        <div id="4" class="cells" style="top: 40%;left:33.3%;"></div>

        <div id="5" class="cells" style="top: 33.3%;left:40%;"></div>
        <div id="6" class="cells" style="top: 26.64%;left:40%;"></div>
        <div id="7" class="cells" style="top: 19.98%;left:40%;"></div>
        <div id="8" class="cells safe" style="top: 13.32%;left:40%;"></div>
        <div id="9" class="cells" style="top: 6.66%;left:40%;"></div>
        <div id="10" class="cells" style="top: 0;left:40%;"></div>


        <div id="11" class="cells" style="top: 0;left:46.66%;"></div>
        <div id="12" class="cells" style="top: 0;left:53.32%;"></div>
        <div id="13" class="cells y-start" style="top: 6.66%;left:53.32%;"></div>
        <div id="14" class="cells" style="top: 13.32%;left:53.32%;"></div>
        <div id="15" class="cells" style="top: 19.98%;left:53.32%;"></div>
        <div id="16" class="cells" style="top: 26.64%;left:53.32%;"></div>
        <div id="17" class="cells" style="top: 33.3%;left:53.32%;"></div>

        <div id="18" class="cells" style="top: 40%; right: 33.3%"></div>
        <div id="19" class="cells" style="top: 40%;right:26.64%;"></div>
        <div id="20" class="cells" style="top: 40%;right:19.98%;"></div>
        <div id="21" class="cells safe" style="top: 40%;right:13.32%;"></div>
        <div id="22" class="cells" style="top: 40%;right:6.66%;"></div>
        <div id="23" class="cells" style="top: 40%;right:0;"></div>
        <div id="24" class="cells" style="top: 46.66%;right:0;"></div>

        <div id="25" class="cells" style="top: 53.32%;right: 0;"></div>
        <div id="26" class="cells b-start" style="top: 53.32%;right:6.66%;"></div>
        <div id="27" class="cells" style="top: 53.32%;right:13.32%;"></div>
        <div id="28" class="cells" style="top: 53.32%;right:19.98%;"></div>
        <div id="29" class="cells" style="top: 53.32%;right:26.64%;"></div>
        <div id="30" class="cells" style="top: 53.32%; right: 33.3%"></div>

        <div id="31" class="cells" style="bottom: 33.3%;left:53.32%;"></div>
        <div id="32" class="cells" style="bottom: 26.64%;left:53.32%;"></div>
        <div id="33" class="cells" style="bottom: 19.98%;left:53.32%;"></div>
        <div id="34" class="cells safe" style="bottom: 13.32%;left:53.32%;"></div>
        <div id="35" class="cells" style="bottom: 6.66%;left:53.32%;"></div>
        <div id="36" class="cells" style="bottom: 0;left:53.32%;"></div>


        <div id="37" class="cells" style="bottom: 0;left:46.66%;"></div>
        <div id="38" class="cells" style="bottom: 0;left:40%;"></div>
        <div id="39" class="cells r-start" style="bottom: 6.66%;left:40%;"></div>
        <div id="40" class="cells" style="bottom: 13.32%;left:40%;"></div>
        <div id="41" class="cells" style="bottom: 19.98%;left:40%;"></div>
        <div id="42" class="cells" style="bottom: 26.64%;left:40%;"></div>
        <div id="43" class="cells" style="bottom: 33.3%;left:40%;"></div>

        <div id="44" class="cells" style="top: 53.32%; left: 33.3%"></div>
        <div id="45" class="cells" style="top: 53.32%;left:26.64%;"></div>
        <div id="46" class="cells" style="top: 53.32%;left:19.98%;"></div>
        <div id="47" class="cells safe" style="top: 53.32%;left:13.32%;"></div>
        <div id="48" class="cells" style="top: 53.32%;left:6.66%;"></div>
        <div id="49" class="cells" style="top: 53.32%;left:0;"></div>
        <div id="50" class="cells" style="top: 46.66%;left:0;"></div>

        <div id="65" class="cells blue" style="top: 46.66%; right: 33.3%"></div>
        <div id="64" class="cells blue" style="top: 46.66%;right:26.64%;"></div>
        <div id="63" class="cells blue" style="top: 46.66%;right:19.98%;"></div>
        <div id="62" class="cells blue" style="top: 46.66%;right:13.32%;"></div>
        <div id="61" class="cells blue" style="top: 46.66%;right:6.66%;"></div>

        <div id="56" class="cells green" style="top: 46.66%;left: 33.3%"></div>
        <div id="55" class="cells green" style="top: 46.66%;left:26.64%;"></div>
        <div id="54" class="cells green" style="top: 46.66%;left:19.98%;"></div>
        <div id="53" class="cells green" style="top: 46.66%;left:13.32%;"></div>
        <div id="52" class="cells green" style="top: 46.66%;left:6.66%;"></div>

        <div id="71" class="cells red " style="bottom: 6.66%;left:46.66%;"></div>
        <div id="72" class="cells red" style="bottom: 13.32%;left:46.66%;"></div>
        <div id="73" class="cells red" style="bottom: 19.98%;left:46.66%;"></div>
        <div id="74" class="cells red" style="bottom: 26.64%;left:46.66%;"></div>
        <div id="75" class="cells red" style="bottom: 33.3%;left:46.66%;"></div>

        <div id="81" class="cells yellow" style="top: 6.66%;left:46.66%;"></div>
        <div id="82" class="cells yellow" style="top: 13.32%;left:46.66%;"></div>
        <div id="83" class="cells yellow" style="top: 19.98%;left:46.66%;"></div>
        <div id="84" class="cells yellow" style="top: 26.64%;left:46.66%;"></div>
        <div id="85" class="cells yellow" style="top: 33.3%;left:46.66%;"></div>
      </div>
      <h2 class="make-your-move-text">{{ movePawnText }}</h2>

      <button class="btn btn-primary" :disabled="!hasChanged" @click="ThrowDice">Gooi je dobbelsteen</button>

    </div>
    <div class="right-part">
      <div class="right-yellow">
        <div class="username">
          <p id="yellow_username">{{ this.yellowName }}</p>
          <div class="logo">
            <a href="#"><img src="../assets/icon.png" alt="Hva logo"></a>
          </div>
        </div>
      </div>
      <div class="right-blue">
        <div class="username">
          <p id="blue_username">{{ this.blueName }}</p>
          <div class="logo">
            <a href="#"><img src="../assets/icon.png" alt="Hva logo"></a>
          </div>
        </div>
      </div>
    </div>
  </div>


  <div class="background">
    <img alt="backgroundimg" src="../assets/Ludobackground.png">
  </div>


</template>

<script>
import NavBar from "@/components/NavBar.vue";
import {pawn} from "@/models/pawn"
import {toast} from "vue3-toastify";
import {playermove} from "@/models/playermove";

export default {
  name: "LoginScreen",
  components: {NavBar},
  props: ['selectedColor'],
  inject: ['SessionService', 'lobbyService', 'userService', 'ludoService'],
  data() {
    return {
      //save the lobbycode and saves if the game is singleplayer or not.
      lobbyCode: null,
      isSingleplayer: false,

      pawns: [],
      output: null,
      movePawnText: null,
      pawnSteps: 0,
      selectedcolor: null,
      playablePawns: [],
      allowedToMove: true,


      //information for multiplayer
      userids: [],
      lobby: null,
      currentuser: null,
      connectedUsers: [],
      users: [],
      selectedColorsMP: [],


      //PlayerCardinfo
      greenName: null,
      yellowName: null,
      blueName: null,
      redName: null,


      //Websockets playermove
      playerMoves: [],
      activeThrow: null,
    };
  },

  async created() {
    this.currentuser = await this.userService.asyncGetInfo();

    //saves the param in lobby code and changes game to singleplayer if the lobbycode is not found.
    this.lobbyCode = this.$route.params.joincode;
    if (this.lobbyCode === ":joincode") {
      this.isSingleplayer = true;
    }

    //Will change the way how selectedColor is saved based on whether it is a multiplayer game or a singleplayer game.
    if (this.isSingleplayer === true) {
      this.selectedcolor = this.$route.query.selectedColor;
    } else {
      await this.multiplayerInitialLaunch();
    }


    //creates all pawns
    this.createPawns();

    //Saves all the pawns that is allowed to move to playablePawns.
    //Make it so only can move pawns that have the same color as you selected.
    switch (this.selectedcolor) {
      case 'green':
        for (let i = 0; i < 4; i++) {
          this.playablePawns.push(this.pawns[i]);
        }
        this.greenName = this.currentuser.username;
        break;
      case 'yellow':
        for (let i = 4; i < 8; i++) {
          this.playablePawns.push(this.pawns[i]);
        }
        this.yellowName = this.currentuser.username;
        break;
      case 'red':
        for (let i = 8; i < 12; i++) {
          this.playablePawns.push(this.pawns[i]);
        }
        this.redName = this.currentuser.username;
        break;
      case  'blue':
        for (let i = 12; i < 16; i++) {
          this.playablePawns.push(this.pawns[i]);
        }
        this.blueName = this.currentuser.username;
    }

    //Multiplayer usernames on cards and removes unused pawns from board.
    if (!this.isSingleplayer) {
      this.assignPlayerCardMP();
      this.removePawns();
      // this.notificationService.subscribe("playermoves", this.reInitialize)
      // await this.reInitialize();
      this.playerMoves = await this.ludoService.asyncFindAllWithLobbyid(this.lobby[0].idLobby);
      console.log(this.playerMoves)
    }

  },

  computed: {
    hasChanged() {
      return this.allowedToMove;
    }

  },

  methods: {
    createPawns() {
      //for statements to create pawns for each color with unique ids
      for (let i = 100; i < 104; i++) {
        let count = i - 100;
        let homepos = 1000 + count;
        this.pawns.push(pawn.createGreenpawn(i, homepos))
      }
      for (let i = 200; i < 204; i++) {
        let count = i - 200;
        let homepos = 2000 + count;
        this.pawns.push(pawn.createYellowpawn(i, homepos))
      }
      for (let i = 300; i < 304; i++) {
        let count = i - 300;
        let homepos = 3000 + count;
        this.pawns.push(pawn.createRedpawn(i, homepos))
      }
      for (let i = 400; i < 404; i++) {
        let count = i - 400;
        let homepos = 4000 + count;
        this.pawns.push(pawn.createbluePawn(i, homepos))
      }
    },
    async multiplayerInitialLaunch() {
      //get the selectedColor from manyToMany table in DB
      this.lobby = await this.lobbyService.asyncFindByjoincode(this.lobbyCode);

      console.log(this.lobby);
      console.log(this.lobby.idLobby);
      console.log(this.lobby[0].idLobby);

      const returnStatement =
          await this.lobbyService.asyncFindColorConnectedToUser(this.lobby[0].idLobby, this.currentuser.userId);
      this.selectedcolor = returnStatement[0];


      //get info from other players
      this.userids = await this.lobbyService.asyncFindAllConnectedToLobby(this.lobby[0].idLobby);
      console.log(this.userids)
      for (let i = 0; i < this.userids.length; i++) {
        //prevents saving the current user in the user variable
        console.log(this.currentuser.userId)
        if (this.currentuser.userId !== this.userids[i]) {
          //saves users in users variable and searches connected color in the ManyToMany table
          this.users.push(await this.userService.asyncFindId(this.userids[i]));
          const returns = await this.lobbyService.asyncFindColorConnectedToUser(this.lobby[0].idLobby, this.userids[i]);
          this.selectedColorsMP.push(returns[0]);
        }
      }

    },

    async newPawn() {
      //Check if there are pawns in the home area (Starting zone for their color)
      let pawnId = null;
      let arrayPos = null;
      for (let i = 0; i < 4; i++) {
        //onfield is used to see the status of the pawn. 1 being in the starting zone, 2 in the playing field and 3
        //in the finished area and in its corrosponding ending.
        if (this.playablePawns[i].onField === 1) {
          pawnId = this.playablePawns[i].id;
          arrayPos = i;
          break;
        }
      }

      //Check if the pawnId exist before it will select an element.
      if (pawnId != null) {
        //checks if the spawn position has a child node or not.
        if (!document.getElementById(this.playablePawns[0].path[0]).hasChildNodes()) {
          const pawnMove = document.getElementById(pawnId);
          this.playablePawns[arrayPos].previousPosition = this.playablePawns[arrayPos].homePosition;
          this.playablePawns[arrayPos].position = this.playablePawns[arrayPos].path[0];
          let prevPosBox = document.getElementById(this.playablePawns[arrayPos].previousPosition);
          let nextPosBox = document.getElementById(this.playablePawns[arrayPos].position);
          prevPosBox.removeChild(pawnMove);
          nextPosBox.appendChild(pawnMove);
          this.playablePawns[arrayPos].onField = 2;

          //if it is a mutliplayer game it will post the playermove to the database
          if (!this.isSingleplayer) {
            console.log(this.lobby[0].idLobby);
            const move = playermove.createPlayermove(pawnId, this.playablePawns[arrayPos].position);
            await this.ludoService.asyncSaveUsermove(move, this.lobby[0].idLobby)
          }
        } else {
          this.selectPawn()
        }
      } else {
        this.selectPawn()
      }
    },


    async movePawn(pawnId, arrayPos) {
      const result = this.output;

      //checks if pawnId exist before it will call the connected div.
      if (pawnId != null) {
        const pawnMove = document.getElementById(pawnId);
        const currPawnPosIndex = this.playablePawns[arrayPos].path.indexOf(this.playablePawns[arrayPos].position);
        let newPawnPosIndex = currPawnPosIndex + result;
        let maxPossiblePositions = this.playablePawns[arrayPos].path.length - 1;

        //This will be used to determine how many available positions there are in the finish
        //if a pawn finish at last spot in pawn.path it will reduce the arraysize to avoid overlapping.
        let finishPosIndexAvailable = 0;

        for (let i = 0; i < 4; i++) {
          const onfieldValue = this.playablePawns[i].onField;
          if (onfieldValue === 3) {
            finishPosIndexAvailable += 1;
          }
        }
        maxPossiblePositions = maxPossiblePositions - finishPosIndexAvailable;

        //makes so that if u throw higher than the amount of available positions it will replace it with the
        //max available positions
        if (newPawnPosIndex >= maxPossiblePositions) {
          newPawnPosIndex = maxPossiblePositions;

          //changes status to finished if it got moved to the right finish box
          this.playablePawns[arrayPos].onField = 3;

          if (finishPosIndexAvailable === 3) {
            toast.success("Achievement unlocked:\nFirst Win!")
            this.winConfirmation();
          }
        }

        //makes it so the buttons are not activated anymore and the text will disappear.
        this.allowedToMove = true;
        this.movePawnText = null;

        //moving the pawn to the new position and changing the data of the pawn itself.
        this.playablePawns[arrayPos].previousPosition = this.playablePawns[arrayPos].position;
        this.playablePawns[arrayPos].position = this.playablePawns[arrayPos].path[newPawnPosIndex];
        let prevPosBox = document.getElementById(this.playablePawns[arrayPos].previousPosition);
        let nextPosBox = document.getElementById(this.playablePawns[arrayPos].position);
        prevPosBox.removeChild(pawnMove);
        nextPosBox.appendChild(pawnMove);


        //if it is a mutliplayer game it will post the playermove to the database
        if (!this.isSingleplayer) {
          const move =
              playermove.createPlayermove(pawnId, this.playablePawns[arrayPos].position, this.lobby[0].idLobby);
          await this.ludoService.asyncUpdatePlayerPos(move);
        }
      }
    },

    winConfirmation() {
      this.allowedToMove = false
      this.output = "win"
    },

    ThrowDice() {
      let result = Math.floor((Math.random() * 6) + 1);
      this.output = result
      let allowMove = false;
      if (result === 6) {
        this.newPawn(result)

      } else {
        //this checks if a pawn is available in the first place (think about start of the game)
        //if not it will skip the whole process of going through the other methods.
        for (let i = 0; i < 4; i++) {
          if (this.playablePawns[i].onField === 2) {
            allowMove = true
          }
        }
        if (allowMove) {
          this.selectPawn()
        }
      }
    },


    selectPawn() {
      //possible to make it more efficient if I could toggle or add a listener for the
      // button press, but it will take too long to figure out
      this.allowedToMove = false;
      this.movePawnText = "Selecteer welke pion je wilt bewegen";
    },


    checkIfPawnOnField(event) {
      //small check if selected pawn (event) is playable and gives an alert if it is not.
      let arrayPos = null;
      for (let i = 0; i < 4; i++) {
        // only able to do double == because the value comes from an event
        if (this.playablePawns[i].id == event.target.id) {
          if (this.playablePawns[i].onField === 2) {
            arrayPos = i;
          }
        }
      }
      if (arrayPos != null) {
        this.movePawn(event.target.id, arrayPos);
      } else {
        alert("Je kan alleen een pion van je eigen kleur kiezen en die in het veld staat.")
      }
    },

    removePawns() {

      //Could be better
      if (this.greenName === null) {
        for (let i = 0; i < 4; i++) {
          const element = document.getElementById('100' + i);
          console.log(element)
          element.remove();
        }
      }
      if (this.yellowName === null) {
        for (let i = 0; i < 4; i++) {
          let element = document.getElementById('200' + i)
          console.log(element)
          element.remove();
        }
      }
      if (this.redName === null) {
        for (let i = 0; i < 4; i++) {
          const element = document.getElementById('300' + i);
          console.log(element)
          element.remove();
        }
      }
      if (this.blueName === null) {
        for (let i = 0; i < 4; i++) {
          const element = document.getElementById('400' + i);
          console.log(element)
          element.remove();
        }
      }
    },

    assignPlayerCardMP() {
      for (let i = 0; i < this.selectedColorsMP.length; i++) {
        switch (this.selectedColorsMP[i]) {
          case 'green':
            this.greenName = this.users[i].username;
            break;
          case 'yellow':
            this.yellowName = this.users[i].username;
            break;
          case 'red':
            this.redName = this.users[i].username;
            break;
          case  'blue':
            this.blueName = this.users[i].username;
        }
      }
    },

    async reInitialize() {
      // reload all playerMoves from the back-end

      //saves all the moves made
      this.playerMoves = await this.ludoService.asyncFindAllWithLobbyid(this.lobby[0].idLobby);
    },
  },

}
</script>


<style scoped>

/* Variables */

.make-your-move-text {
  color: white;
}

.green-pawn {
  height: 25px;
  width: 25px;
  border-radius: 100%;
  position: absolute;
  background-color: green;

  border-width: 2px;
  border-style: solid;
  border-color: black;

  top: 0;
  left: 0;
  transition: top 1s ease, left 1s ease;
}

.red-pawn {
  height: 25px;
  width: 25px;
  border-radius: 100%;
  position: absolute;
  background-color: red;

  border-width: 2px;
  border-style: solid;
  border-color: black;

  top: 0;
  left: 0;
  transition: top 1s ease, left 1s ease;
}

.yellow-pawn {
  height: 25px;
  width: 25px;
  border-radius: 100%;
  position: absolute;
  background-color: yellow;


  border-width: 2px;
  border-style: solid;
  border-color: black;

  top: 0;
  left: 0;
  transition: top 1s ease, left 1s ease;
}

.blue-pawn {
  height: 25px;
  width: 25px;
  border-radius: 100%;
  position: absolute;
  background-color: blue;

  border-width: 2px;
  border-style: solid;
  border-color: black;

  top: 0;
  left: 0;
  transition: top 1s ease, left 1s ease;
}

:root {
  --BackgroundColor: rgba(5, 11, 98, 1);
  --BoxBorderColor: rgba(119, 181, 221, 1);
  --InputBoxColor: rgba(196, 196, 196, 0.271);

  --font-size-s: 32px;
  --font-size-xl: 64px;
  --font-size-s2: 40px;
  --font-size-m2: 57px;

  --font-family-poetsenone-regular: "PoetsenOne-Regular"
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

/*.container-center-horizontal {*/
/*  display: flex;*/
/*  flex-direction: row;*/
/*  !*justify-content: space-between;*!*/
/*}*/

.left-part {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  padding: 10px 0 10px 10px;
  height: 500px;
}

.right-part {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  padding: 10px 10px 10px 0;
  height: 500px;
}

.username {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  border-radius: 10px;

}

.left-green {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  background-color: #66bb6a;
  padding: 10px;
  border-top-left-radius: 10px;
  border-bottom-left-radius: 10px;
  border: 2px solid black;
}

.left-red {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  margin-bottom: 10px;
  padding: 10px;
  background-color: #e53935;
  border-top-left-radius: 10px;
  border-bottom-left-radius: 10px;
  border: 2px solid black;
}

.right-yellow {
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  background-color: #fff176;
  padding: 10px;
  border-top-right-radius: 10px;
  border-bottom-right-radius: 10px;
  border: 2px solid black;
}

.right-blue {
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  background-color: #29b6f6;
  padding: 10px;
  margin-bottom: 10px;
  border-top-right-radius: 10px;
  border-bottom-right-radius: 10px;
  border: 2px solid black;

}


#yellow_username {
  margin-left: 10px;
  margin-right: 0;
}

#blue_username {
  margin-left: 10px;
  margin-right: 0;
}

.username p {
  color: black;
  margin-bottom: 0;
  margin-right: 10px;
}

.logo {
  padding: 10px;
}

.logo img {
  height: 50px;
}

.container-center-horizontal {
  align-items: center;
  display: flex;
  flex-direction: row;
  justify-content: center;
}

.overlap-group {
  align-items: center;
  display: flex;
  flex-direction: column;
}


.game {
  background: white;
  display: flex;
  flex-wrap: wrap;
  margin: 20px auto;
  position: relative;
  width: 500px;
  height: 500px;
}

.green {
  background-color: #66bb6a;
}

.red {
  background-color: #e53935;
  border: none;
}

.yellow {
  background-color: #fff176;
  border: none;
}

.blue {
  background-color: #29b6f6;
  border: none;
}

.dice-output {
  color: black;
}

.house {
  display: inline-block;
  position: absolute;
  width: 40%;
  height: 40%;
  padding: 7%;
}

.box {
  position: relative;
  width: 100%;
  height: 100%;
  background-color: white;
  padding: 20%;
}

.square {
  position: absolute;
  width: 25%;
  height: 25%;

}

.square-one {
  top: 20%;
  left: 20%;
}

.square-two {
  top: 20%;
  right: 20%;
}

.square-three {
  bottom: 20%;
  left: 20%;
}

.square-four {
  bottom: 20%;
  right: 20%;
}

.home {
  position: absolute;
  top: 40%;
  left: 40%;
  width: 20%;
  height: 20%;
  border-bottom: 20px solid #e53935;
  border-top: 20px solid #fff176;
  border-left: 20px solid #66bb6a;
  border-right: 20px solid #29b6f6;
}

.cells {
  position: absolute;
  width: 6.66%;
  height: 6.66%;
  border-collapse: collapse;
  border: 1px solid #e5e5e569;
}

.safe {
  background-color: #99999938;

}

.g-start {
  background-color: #66bb6a;


}

.y-start {
  background-color: #fff176;


}

.r-start {
  background-color: #e53935;


}

.b-start {
  background-color: #29b6f6;

}


</style>