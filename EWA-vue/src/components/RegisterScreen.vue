<template>
  <div class="container-center-horizontal">
    <div class="macbook-pro-16-sign-up screen">
      <div class="overlap-group">
        <img class="image-11" src="../assets/Hvalogo.png" alt="image 11" /> <div class="flex-col">
        <div class="overlap-group1">
          <button class="submit valign-text-middle" :disabled="!hasChanged" @click="redirect">registreren</button>
          <div class="rectangle-48"></div>
          <img class="rectangle-51" src="../assets/Rectangle.png"
               alt="Rectangle 51" />
          <h1 class="title valign-text-middle poetsenone-regular-normal-white-64px">Sign up</h1>
          <div class="rectangle-50"></div>
          <div class="username valign-text-middle poetsenone- regular-normal-white-40px"><input  v-model="username" type="text"
                                                                                                 placeholder="username"></div>
          <div class="rectangle-52"></div>
          <div class="email-address valign-text-middle poetsenone- regular-normal-white-40px"><input v-model="email" type="email"
                                                                                                     placeholder="email">
          </div>
          <div class="rectangle-54"></div>
          <div class="password valign-text-middle poetsenone- regular-normal-white-40px"><input  v-model="password" type="password"
                                                                                                 placeholder="password"></div>
        </div>
        <p class="already-have-an-account-login valign-text-middle poetsenone-regular-normal-white-40px">
          Already have an Account? <router-link to="/Loginpage">Log in</router-link>
        </p></div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "RegisterScreen",
  data() {
    return {
      email: '',
      password: '',
      username: '',
    };
  },

  computed: {
    hasChanged() {
      if (this.email !== '' && this.password !== ''&& this.username !== ''){
        return true;
      } else {
        return false;
      }
    }
  },

  methods: {
    redirect(){
      this.$router.push("/Dashboard");
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

/* Classes */

.poetsenone-regular-normal-white-64px {
  color: white;
  font-family: var(--font-family-poetsenone-regular);
  font-size: 64px;
  font-weight: 400;
  font-style: normal;
}


.poetsenone-regular-normal-white-40px {
  color: white;
  font-family: var(--font-family-poetsenone-regular);
  font-size: 40px;
  font-weight: 400;
  font-style: normal;
}

@font-face {
  font-family: "PoetsenOne-Regular";
  font-style: normal;
  font-weight: 400;
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

.macbook-pro-16-sign-up {
  align-items: flex-start;
  background-color: rgba(5,11,98,1);
  border: 1px solid;
  border-color: rgba(5,11,98,1);
  display: flex;
  width: 1728px;
}

.overlap-group {
  align-items: flex-start;
  background-image: url("@/assets/Ludo background.png");
  background-position: 50% 50%;
  background-size: cover;
  display: flex;
  gap: 138px;
  height: 1117px;
  min-width: 1728px;
  padding: 18px 54px;
}

.image-11 {
  height: 111px;
  margin-top: 31px;
  object-fit: cover;
  width: 98px;
}

.flex-col {
  align-items: center;
  align-self: flex-end;
  display: flex;
  flex-direction: column;
  gap: 24px;
  min-height: 994px;
  width: 1147px;
}

.overlap-group1 {
  height: 896px;
  position: relative;
  width: 1147px;
}


.submit {
  background-color: white;
  border-radius: 25px;
  box-shadow: 0px 4px 4px #00000040;
  height: 70px;
  left: 389px;
  position: absolute;
  z-index: 999;
  top: 772px;
  width: 368px;
  text-align: center;
  align-items: center;
}

.rectangle-48 {
  border: 4px solid;
  border-color: black;
  border-radius: 25px;
  box-shadow: 0px 4px 4px #00000040;
  height: 896px;
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
  height: 64px; left: 309px; letter-spacing: 0; line-height: 18px; position: absolute;
  text-align: center; top: 54px;
  width: 529px;
}
.rectangle-50 {
  background-color: rgba(196,196,196,0.271);
  border: 4px solid;
  border-color: rgba(119,181,221,1);
  border-radius: 25px;
  box-shadow: 0px 4px 4px #00000040;
  height: 117px;
  left: 169px;
  position: absolute;
  top: 235px;
  width: 809px;
}

.rectangle-52 {
  background-color: rgba(196,196,196,0.271);
  border: 4px solid;
  border-color: rgba(119,181,221,1);
  border-radius: 25px;
  box-shadow: 0px 4px 4px #00000040;
  height: 117px;
  left: 169px;
  position: absolute;
  top: 395px;
  width: 809px;
}

.email-address {
  height: 64px;
  left: 309px;
  letter-spacing: 0;
  line-height: 18px;
  position: absolute;
  text-align: center;
  top: 425px;
  width: 529px;
}

.username {
  height: 64px;
  left: 312px;
  letter-spacing: 0;
  line-height: 18px;
  position: absolute;
  text-align: center;
  top: 261px;
  width: 529px;
}

.rectangle-54 {
  background-color: rgba(196,196,196,0.271);
  border: 4px solid;
  border-color: rgba(119,181,221,1);
  border-radius: 25px;
  box-shadow: 0px 4px 4px #00000040;
  height: 117px;
  left: 169px;
  position: absolute;
  top: 555px;
  width: 809px;
}

.password {
  height: 64px;
  left: 312px;
  letter-spacing: 0;
  line-height: 18px;
  position: absolute;
  text-align: center;
  top: 581px;
  width: 529px;
}

.already-have-an-account-login {
  height: 74px;
  letter-spacing: 0;
  line-height: 18px;
  margin-right: 21px;
  text-align: center;
  width: 636px;
}

</style>