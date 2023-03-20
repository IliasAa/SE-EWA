<template>
  <NavBar></NavBar>
 <body>
  <div class="container">
    <div class="row">

      <div class="col-sm">
        <div>
          <img src="../assets/ludo-board.jpg" class="img-fluid" alt="Responsive image">
        </div>
        <h1>Zes dobbelen</h1>

        <div>
          <button class="btn btn-dark" @click="showText1 = !showText1">{{ buttonText1 }}</button>
          <p v-if="showText1">{{ textToShow1 }}</p>
        </div>
      </div>


      <div class="col-sm">
        <div>
          <img src="../assets/ludo-board.jpg" class="img-fluid" alt="Responsive image">
        </div>
        <h1>Aantal spelers</h1>
        <div>
          <button class="btn btn-dark" @click="showText2 = !showText2">{{ buttonText1 }}</button>
          <p v-if="showText2">{{ textToShow2 }}</p>
        </div>
      </div>


      <div class="col-sm">
        <div>
          <img src="../assets/ludo-board.jpg" class="img-fluid" alt="Responsive image">
        </div>
        <h1>Kleuren van spelers</h1>
        <div>
          <button class="btn btn-dark" @click="showText3 = !showText3">{{ buttonText1 }}</button>
          <p v-if="showText3">{{ textToShow3 }}</p>
        </div>
      </div>
    </div>

    <div class="row">


      <div class="col-sm">
        <div>
          <img src="../assets/ludo-board.jpg" class="img-fluid" alt="Responsive image">
        </div>
        <h1>Pionen slaan</h1>
        <div>
          <button class="btn btn-dark" @click="showText4 = !showText4">{{ buttonText1 }}</button>
          <p v-if="showText4">{{ textToShow4 }}</p>
        </div>
      </div>


      <div class="col-sm">
        <div>
          <img src="../assets/ludo-board.jpg" class="img-fluid" alt="Responsive image">
        </div>
        <h1>Geslagen worden</h1>
        <div>
          <button class="btn btn-dark"  @click="showText5 = !showText5">{{ buttonText1 }}</button>
          <p v-if="showText5">{{ textToShow5 }}</p>
        </div>
      </div>


      <div class="col-sm">
        <div>
          <img src="../assets/ludo-board.jpg" class="img-fluid" alt="Responsive image">
        </div>
        <h1>Plaaten van pionen</h1>
        <div>
          <button class="btn btn-dark"  @click="showText6 = !showText6">{{ buttonText1 }}</button>
          <p v-if="showText6">{{ textToShow6 }}</p>
        </div>
      </div>
    </div>

    <div class="row">


      <div class="col">
        <div>
          <img src="../assets/ludo-board.jpg" class="img-fluid" alt="Responsive image">
        </div>
        <h1>Eind veld</h1>
        <div>
          <button class="btn btn-dark"  @click="showText7 = !showText7">{{ buttonText1 }}</button>
          <p v-if="showText7">{{ textToShow7 }}</p>
        </div>
      </div>


      <div class="col">
        <div>
          <img src="../assets/ludo-board.jpg" class="img-fluid" alt="Responsive image">
        </div>
        <h1>Veld posities</h1>
        <div>
          <button class="btn btn-dark"  @click="showText8 = !showText8">{{ buttonText1 }}</button>
          <p v-if="showText8">{{ textToShow8 }}</p>
        </div>
      </div>
    </div>
  </div>
  </body>
</template>

<script>
import NavBar from "@/components/NavBar.vue";
export default {
  name: 'rulePage',
  components: {NavBar},
  data() {
    return {
      showText1: false,
      buttonText1: 'Klik hier om regels te tonen',
      textToShow1: '1. Wanneer je met je dobbelsteen 6 gooit gaat 1 van je pionnen uit je startplaats naar het eerste veldplaats (als niet alle 4 pionnen al op veld liggen) \n 2. Vervolgens mag je nog een keer gooien en is de nieuw in veld gekomen pion de pion die je moet verplaatsen \n 3. Gooi je drie keer 6 gaat je verste pion terug maar het startplaats',

      showText2: false,
      textToShow2: 'Het spel speel je met minimaal 2 tot maximaal 4 spelers',

      showText3: false,
      textToShow3: '1. Elke speler krijt zijn eigen pionnen kleur toe gewezen \n 2. de pionnen moeten ook in hun eigen kleurfinish eindigen',

      showText4: false,
      textToShow4: '1. Wanneer je met je dobbelsteen genoeg oogjes gooit om te landen op een veld punt waar al een andere speler staat, mag je die speler slaan \n 2. Eigen pionnen kan je niet slaan',

      showText5: false,
      textToShow5: 'wordt je geslagen gaat je pion weer terug naar zijn startveld',

      showText6: false,
      textToShow6: '1. je kan je eigen pion plaatsen op lege velden \n 2. je kan niet een pion plaatsen waar al 1 van je eigen pionen staan',

      showText7: false,
      textToShow7: '1. je moet alle pionnen op je eindveld plaatsen \n 2. staan er al pionnen in kan je over je pionnen heen sprinngen \n 3. je mag aan het einde al je bijvoorbeeld een oneven getal nodig (3 bijvoorbeeld) hebt het eind veld ook in gaan met een ander oneven getal (1 of 5). (zelfde telt voor even getallen)',

      showText8: false,
      textToShow8: 'plaats 1: Dit zijn je start plaatsen \n plaats 2: Dit is je start veld \n plaats 3: Dit Zijn je eind velden \n (plaats matchen met je pionnen kleur)',

    }
  },
}
</script>

<style scoped>

.img-fluid {
  max-height: 200px;
  max-width: 200px;
  border-radius: 5px;
  margin-top: 10px;
}

.col-sm {
  background: rgba(0,0,0,0.2);
  border-radius: 20px;
  border: solid black 1px;
  margin: 10px;
}
.col {
  background: rgba(0,0,0,0.2);
  border-radius: 20px;
  border: solid black 1px;
  margin: 10px;
}

.container {
  background: white;
  border-radius: 10px;
}

body {
  background-color: rgba(5, 11, 98, 1);
  background-image: url("../assets/Ludo background.png")
}
</style>