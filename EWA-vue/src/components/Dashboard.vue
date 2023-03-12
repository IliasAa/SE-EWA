<template>
  <div class="container-center-horizontal">
    <div class="macbook-pro-16-log-in screen">
      <div class="overlap-group">
        <img class="image-11" src="../assets/Hvalogo.png" alt="image 11"/>
        <div class="overlap-group1">

      </div>
    </div>
  </div>
  </div>
</template>

<script>
export default {
  name: 'DashboardScreen',
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
      this.$router.push("/StartScreen");
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


</style>