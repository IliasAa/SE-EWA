<template>
  <NavBar></NavBar>
  <div class="container-center-horizontal">
    <div class="overlap-group">
      <div class="game">

        <div class="house green">

          <div class="box">
            <div id="100" class="square square-one green">
              <div v-bind="this.pawns[0]" class="green-pawn 1"></div>
            </div>
            <div id="101" class="square square-two green">
              <div v-bind="this.pawns[1]" class="green-pawn 2"></div>
            </div>
            <div id="102" class="square square-three green">
              <div v-bind="this.pawns[2]" class="green-pawn 3"></div>
            </div>
            <div id="103" class="square square-four green">
              <div v-bind="this.pawns[3]" class="green-pawn 4"></div>
            </div>
          </div>
        </div>
        <div class="house yellow" style="right: 0">
          <div class="box">
            <div id="200" class="square square-one yellow">
              <div v-bind="this.pawns[4]" class="yellow-pawn 1"></div>
            </div>
            <div id="201" class="square square-two yellow">
              <div v-bind="this.pawns[5]" class="yellow-pawn 2"></div>
            </div>
            <div id="202" class="square square-three yellow">
              <div v-bind="this.pawns[6]" class="yellow-pawn 3"></div>
            </div>
            <div id="203" class="square square-four yellow">
              <div v-bind="this.pawns[7]" class="yellow-pawn 4"></div>
            </div>
          </div>
        </div>
        <div class="house red" style="bottom: 0">
          <div class="box">
            <div id="300" class="square square-one red">
              <div v-bind="this.pawns[8]" class="red-pawn 1"></div>
            </div>
            <div id="301" class="square square-two red">
              <div v-bind="this.pawns[9]" class="red-pawn 2"></div>
            </div>
            <div id="302" class="square square-three red">
              <div v-bind="this.pawns[10]" class="red-pawn 3"></div>
            </div>
            <div id="303" class="square square-four red">
              <div v-bind="this.pawns[11]" class="red-pawn 4"></div>
            </div>
          </div>
        </div>
        <div class="house blue" style="bottom: 0;right: 0">
          <div class="box">
            <div id="400" class="square square-one blue">
              <div v-bind="this.pawns[12]" class="blue-pawn 1"></div>
            </div>
            <div id="401" class="square square-two blue">
              <div v-bind="this.pawns[13]" class="blue-pawn 2"></div>
            </div>
            <div id="402" class="square square-three blue">
              <div v-bind="this.pawns[14]" class="blue-pawn 3"></div>
            </div>
            <div id="403" class="square square-four blue">
              <div v-bind="this.pawns[15]" class="blue-pawn 4"></div>
            </div>
          </div>
        </div>

        <div class="home"></div>
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
      <h2 class="dice-output">{{ diceoutput }}</h2>
      <button class="btn btn-primary" @click="ThrowDice">Gooi je dobbelsteen</button>
    </div>
  </div>


  <div class="background">
    <img src="../assets/Ludobackground.png">
  </div>


</template>

<script>
import NavBar from "@/components/NavBar.vue";
import {pawn} from "@/models/pawn"

export default {
  name: "LoginScreen",
  components: {NavBar},
  data() {
    return {
      pawns: [],
      diceoutput: null,
      pawnSteps: 0,
    };
  },

  created() {
    for (let i = 1000; i < 1004; i++) {
      this.pawns.push(pawn.createGreenpawn(i))
    }
    for (let i = 2000; i < 2004; i++) {
      this.pawns.push(pawn.createYellowpawn(i))
    }
    for (let i = 3000; i < 3004; i++) {
      this.pawns.push(pawn.createRedpawn(i))
    }
    for (let i = 4000; i < 4004; i++) {
      this.pawns.push(pawn.createbluePawn(i))
    }
  },

  methods: {

    newPawn(result) {
      const pawnMove = this.$refs.gpawn1;

      if (this.pawns[0].onField === 1){
        this.pawns[0].previousPosition = 100;
        this.pawns[0].position = this.pawns[0].path[0];
        let prevPosBox = document.getElementById(this.pawns[0].previousPosition);
        let nextPosBox = document.getElementById(this.pawns[0].position);
        prevPosBox.removeChild(pawnMove);
        nextPosBox.appendChild(pawnMove);
        this.pawns[0].onField = 2;
      } else {
        this.movePawn(result)
      }
    },

    movePawn(result) {
      const pawnMove = document.getElementById(1000);
      if (this.pawns[0].onField === 2) {
        const posValue = this.pawns[0].position;
        const currPosIndex = this.pawns[0].path.indexOf(posValue);
        let newPosIndex = currPosIndex + result;
        const arrLength = this.pawns[0].path.length;
        if (newPosIndex > arrLength) {
          newPosIndex = arrLength - 1;
          this.pawns[0].onField = 3;
        }
        this.pawns[0].previousPosition = this.pawns[0].position;

        const newPos = this.pawns[0].path[newPosIndex];
        this.pawns[0].position = newPos;

        let prevPosBox = document.getElementById(this.pawns[0].previousPosition);
        let nextPosBox = document.getElementById(this.pawns[0].position);
        prevPosBox.removeChild(pawnMove);
        nextPosBox.appendChild(pawnMove);
      }
    },


    ThrowDice() {
      let result = Math.floor((Math.random() * 6) + 1);
      this.diceoutput = result
      if (result === 6) {
        this.newPawn(result)
      } else {
        this.movePawn(result);
      }
      }

    },
  }
</script>


<style scoped>

/* Variables */

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
  color: white;
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
  -webkit-clip-path: polygon(50% 0%, 61% 35%, 98% 35%, 68% 57%, 79% 91%, 50% 70%, 21% 91%, 32% 57%, 2% 35%, 39% 35%);
  clip-path: polygon(50% 0%, 61% 35%, 98% 35%, 68% 57%, 79% 91%, 50% 70%, 21% 91%, 32% 57%, 2% 35%, 39% 35%);
}

.g-start {
  background-color: #66bb6a;
  -webkit-clip-path: polygon(20% 0%, 0% 20%, 30% 50%, 0% 80%, 20% 100%, 50% 70%, 80% 100%, 100% 80%, 70% 50%, 100% 20%, 80% 0%, 50% 30%);
  clip-path: polygon(20% 0%, 0% 20%, 30% 50%, 0% 80%, 20% 100%, 50% 70%, 80% 100%, 100% 80%, 70% 50%, 100% 20%, 80% 0%, 50% 30%);

}

.y-start {
  background-color: #fff176;
  -webkit-clip-path: polygon(20% 0%, 0% 20%, 30% 50%, 0% 80%, 20% 100%, 50% 70%, 80% 100%, 100% 80%, 70% 50%, 100% 20%, 80% 0%, 50% 30%);
  clip-path: polygon(20% 0%, 0% 20%, 30% 50%, 0% 80%, 20% 100%, 50% 70%, 80% 100%, 100% 80%, 70% 50%, 100% 20%, 80% 0%, 50% 30%);

}

.r-start {
  background-color: #e53935;
  -webkit-clip-path: polygon(20% 0%, 0% 20%, 30% 50%, 0% 80%, 20% 100%, 50% 70%, 80% 100%, 100% 80%, 70% 50%, 100% 20%, 80% 0%, 50% 30%);
  clip-path: polygon(20% 0%, 0% 20%, 30% 50%, 0% 80%, 20% 100%, 50% 70%, 80% 100%, 100% 80%, 70% 50%, 100% 20%, 80% 0%, 50% 30%);

}

.b-start {
  background-color: #29b6f6;
  -webkit-clip-path: polygon(20% 0%, 0% 20%, 30% 50%, 0% 80%, 20% 100%, 50% 70%, 80% 100%, 100% 80%, 70% 50%, 100% 20%, 80% 0%, 50% 30%);
  clip-path: polygon(20% 0%, 0% 20%, 30% 50%, 0% 80%, 20% 100%, 50% 70%, 80% 100%, 100% 80%, 70% 50%, 100% 20%, 80% 0%, 50% 30%);
}


</style>