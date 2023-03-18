<template>
  <div class="container-center-horizontal">
    <div class="macbook-pro-16-log-in screen">
      <div class="overlap-group">
        <img class="image-11" src="../assets/Hvalogo.png" alt="image 11"/>
        <div class="overlap-group1">
          <div class="rectangle-48"></div>
          <button class="submit valign-text-middle" :disabled="!hasChanged" @click="redirect">inloggen</button>

          <img class="rectangle-51" src="../assets/Rectangle.png" alt="Rectangle 51"/>
          <h1 class="title valign-text-middle">Log in</h1>
          <div class="rectangle-50"></div>
          <div class="email-address valign-text-middle poetsenone- regular-normal-white-40px"><input v-model="email" type="email"
                                                                                                     placeholder="email">
          </div>
          <div class="rectangle-52"></div>
          <div class="password valign-text-middle poetsenone- regular-normal-white-40px"><input  v-model="password" type="password"
                                                                                                placeholder="password"></div>
        </div>
        <p class="new-here-create-an-account valign-text- middle poetsenone-regular-normal-white-40px">
          New Here? <router-link to="/Registerpage">Create an account</router-link>
        </p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "LoginScreen",
  data() {
    return {
      email: '',
      password: '',
    };
  },

  computed: {
    hasChanged() {
      if (this.email !== '' && this.password !== ''){
        return true;
      } else {
        return false;
      }
    }
  },

  methods: {
    redirect(){
      this.$router.push("/gamepage");
    }
  }
}
</script>



<style scoped>

/* Variables */

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

/* Css */

.screen a {
  display: contents;
  text-decoration: none;
}

.container-center-horizontal {
  display: flex;
  flex-direction: row;
  justify-content: center;
  pointer-events: none;
  width: 100%;
}

.container-center-horizontal > * {
  flex-shrink: 0;
  pointer-events: auto;
}

.valign-text-middle {
  display: flex;
  flex-direction: column;
  justify-content: center;
}

/*Screen css*/
.macbook-pro-16-log-in {
  align-items: flex-start;
  background-color: rgba(5, 11, 98, 1);
  border: 2px solid;
  border-color: black;
  display: flex;
  height: 1117px;
  width: 1728px;
}


.overlap-group {
  align-items: center;
  background-image: url("@/assets/Ludo background.png");
  background-position: 50% 50%;
  background-size: cover;
  display: flex;
  flex-direction: column;
  min-height: 1117px;
  padding: 40px 54px;
  width: 1728px;
}

.image-11 {
  align-self: flex-start;
  height: 111px;
  margin-top: 9px;
  object-fit: cover;
  width: 98px;
}

.overlap-group1 {
  height: 650px;
  margin-left: 1px;
  margin-top: 105px;
  position: relative;
  width: 1147px;
}



.submit {
  background-color: white;
  border-radius: 25px;
  box-shadow: 0px 4px 4px #00000040;
  font-size: 32px;
  font-weight: 400;
  z-index: 999;
  letter-spacing: 0;
  line-height: 18px;
  position: absolute;
  text-align: center;
  align-items: center;



  height: 70px;
  left: 389px;

  top: 555px;
  width: 368px;
}

.rectangle-48 {
  border: 4px solid;
  border-color: black;
  border-radius: 25px;
  box-shadow: 0px 4px 4px #00000040;
  height: 650px;
  left: 4px;
  position: absolute;
  top: 0;
  width: 1139px;
}

.rectangle-51 {
  height: 181px;
  left: 0;
  position: absolute;
  top: 0;
  width: 1147px;
}

.title {
  color: white;
  font-weight: 400;
  height: 64px;
  left: 309px;
  letter-spacing: 0;
  line-height: 18px;
  position: absolute;
  text-align: center;
  top: 54px;
  width: 529px;
}

.rectangle-50 {
  background-color: rgba(196, 196, 196, 0.271);
  border: 4px solid;
  border-color: rgba(119, 181, 221, 1);
  border-radius: 25px;
  box-shadow: 0px 4px 4px #00000040;
  height: 117px;
  left: 169px;
  position: absolute;
  top: 235px;
  width: 809px;
}

.email-address {
  height: 64px;
  left: 296px;
  letter-spacing: 0;
  line-height: 18px;
  position: absolute;
  text-align: center;
  top: 261px;
  width: 529px;
  color: white;
}

.rectangle-52 {
  background-color: rgba(196, 196, 196, 0.271);
  border: 4px solid;
  border-color: rgba(119, 181, 221, 1);
  border-radius: 25px;
  box-shadow: 0px 4px 4px #00000040;
  height: 117px;
  left: 169px;
  position: absolute;
  top: 395px;
  width: 809px;
}

.password {
  height: 64px;
  left: 309px;
  letter-spacing: 0;
  line-height: 18px;
  position: absolute;
  text-align: center;
  top: 421px;
  width: 529px;
  color: white;
}

.new-here-create-an-account {
  height: 74px;
  color: white;
  border-color: black;
  font-size: small;
  font-weight: bold;
  letter-spacing: 0;
  line-height: 18px;
  margin-top: 88px;
  text-align: center;
  width: 636px;
}
</style>