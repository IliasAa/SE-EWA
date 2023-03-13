<template>
  <body>
  <nav class="navbar">
    <a class="navbar-brand" href="#">
      <img src="../assets/ludo-board.jpg" width="30" height="30" class="d-inline-block align-top" alt="">
      LUDO uitleg
    </a>
    <a class="navbar-brand" href="#">
      <p>home</p>
    </a>
  </nav>
  <div class="container">
    <div class="row">

      <div class="col-sm">
        <div>
          <img src="../assets/ludo-board.jpg" class="img-fluid" alt="Responsive image">
        </div>
        <h1>Zes dobbelen</h1>

        <div>
          <button @click="showText1 = !showText1">{{ buttonText1 }}</button>
          <p v-if="showText1">{{ textToShow1 }}</p>
        </div>
      </div>


      <div class="col-sm">
        <div>
          <img src="../assets/ludo-board.jpg" class="img-fluid" alt="Responsive image">
        </div>
        <h1>aantal spelers</h1>
        <div>
          <button @click="showText2 = !showText2">{{ buttonText2 }}</button>
          <p v-if="showText2">{{ textToShow2 }}</p>
        </div>
      </div>


      <div class="col-sm">
        <div>
          <img src="../assets/ludo-board.jpg" class="img-fluid" alt="Responsive image">
        </div>
        <h1>kleuren van spelers</h1>
        <div>
          <button @click="showText3 = !showText3">{{ buttonText3 }}</button>
          <p v-if="showText3">{{ textToShow3 }}</p>
        </div>
      </div>
    </div>

    <div class="row">


      <div class="col-sm">
        <div>
          <img src="../assets/ludo-board.jpg" class="img-fluid" alt="Responsive image">
        </div>
        <h1>poinen slaan</h1>
        <div>
          <button @click="showText4 = !showText4">{{ buttonText4 }}</button>
          <p v-if="showText4">{{ textToShow4 }}</p>
        </div>
      </div>


      <div class="col-sm">
        <div>
          <img src="../assets/ludo-board.jpg" class="img-fluid" alt="Responsive image">
        </div>
        <h1>geslagen worden</h1>
        <div>
          <button @click="showText5 = !showText5">{{ buttonText5 }}</button>
          <p v-if="showText5">{{ textToShow5 }}</p>
        </div>
      </div>


      <div class="col-sm">
        <div>
          <img src="../assets/ludo-board.jpg" class="img-fluid" alt="Responsive image">
        </div>
        <h1>plaaten van pionen</h1>
        <div>
          <button @click="showText6 = !showText6">{{ buttonText6 }}</button>
          <p v-if="showText6">{{ textToShow6 }}</p>
        </div>
      </div>
    </div>

    <div class="row">


      <div class="col">
        <div>
          <img src="../assets/ludo-board.jpg" class="img-fluid" alt="Responsive image">
        </div>
        <h1>eind veld</h1>
        <div>
          <button @click="showText7 = !showText7">{{ buttonText7 }}</button>
          <p v-if="showText7">{{ textToShow7 }}</p>
        </div>
      </div>


      <div class="col">
        <div>
          <img src="../assets/ludo-board.jpg" class="img-fluid" alt="Responsive image">
        </div>
        <h1>veld posities</h1>
        <div>
          <button @click="showText8 = !showText8">{{ buttonText8 }}</button>
          <p v-if="showText8">{{ textToShow8 }}</p>
        </div>
      </div>
    </div>
  </div>
  </body>
</template>

<script>
export default {
  name: 'rulePage',
  data() {
    return {
      showText1: false,
      buttonText1: 'Klik hier om regels te tonen',
      textToShow1: '1. Wanneer je met je dobbelsteen 6 gooit gaat 1 van je pionnen uit je startplaats naar het eerste veldplaats (als niet alle 4 pionnen al op veld liggen) \n 2. Vervolgens mag je nog een keer gooien en is de nieuw in veld gekomen pion de pion die je moet verplaatsen \n 3. Gooi je drie keer 6 gaat je verste pion terug maar het startplaats',

      showText2: false,
      buttonText2: 'Klik hier om regels te tonen',
      textToShow2: 'Het spel speel je met minimaal 2 tot maximaal 4 spelers',

      showText3: false,
      buttonText3: 'Klik hier om regels te tonen',
      textToShow3: '1. Elke speler krijt zijn eigen pionnen kleur toe gewezen \n 2. de pionnen moeten ook in hun eigen kleurfinish eindigen',

      showText4: false,
      buttonText4: 'Klik hier om regels te tonen',
      textToShow4: '1. Wanneer je met je dobbelsteen genoeg oogjes gooit om te landen op een veld punt waar al een andere speler staat, mag je die speler slaan \n 2. Eigen pionnen kan je niet slaan',

      showText5: false,
      buttonText5: 'Klik hier om regels te tonen',
      textToShow5: 'wordt je geslagen gaat je pion weer terug naar zijn startveld',

      showText6: false,
      buttonText6: 'Klik hier om regels te tonen',
      textToShow6: '1. je kan je eigen pion plaatsen op lege velden \n 2. je kan niet een pion plaatsen waar al 1 van je eigen pionen staan',

      showText7: false,
      buttonText7: 'Klik hier om regels te tonen',
      textToShow7: '1. je moet alle pionnen op je eindveld plaatsen \n 2. staan er al pionnen in kan je over je pionnen heen sprinngen \n 3. je mag aan het einde al je bijvoorbeeld een oneven getal nodig (3 bijvoorbeeld) hebt het eind veld ook in gaan met een ander oneven getal (1 of 5). (zelfde telt voor even getallen)',

      showText8: false,
      buttonText8: 'Klik hier om regels te tonen',
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
  border: solid purple;
}

.col-sm {
  background: rgba(0,0,0,0.2);
  border-radius: 20px;
  border: solid purple;
  margin: 10px;
}
.col {
  background: rgba(0,0,0,0.2);
  border-radius: 20px;
  border: solid purple;
  margin: 10px;
}

button {
  border-radius: 10px;
  background-color: purple;
  border-color: blueviolet;
  margin-bottom: 10px;
}
.navbar {
  background-color: blueviolet;
  border-bottom: solid;
  border-bottom-color: purple;
}
body {
  background-color: blueviolet;
}
</style>