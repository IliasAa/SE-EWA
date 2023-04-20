<template>
  <header>
    <nav>
      <div class="logo">
        <router-link to="/Dashboard"><a href="#"><img src="../assets/Hvalogo.png" alt="Hva logo"></a></router-link>
      </div>
      <ul class="menu">
        <router-link to="/LoginPage"><li v-on:click="handleLogout()"><a href="#">Logout</a></li></router-link>
        <router-link to="/LeaderboardPage"><li><a href="#">Leaderboard</a></li></router-link>
        <div class="dropdown">
        <router-link to="settings"><button class="dropbtn">Settings</button></router-link>
        <div class="dropdown-content">
          <router-link to="rulePage" target="_blank">Rules</router-link>
          <router-link to="Dashboard">Invite friend</router-link>
          <router-link to="Dashboard">Leave Game</router-link>
        </div>
      </div>
        <div class="username">
          <div class="logo">
            <a href="#"><img src="../assets/icon.png" alt="Hva logo"></a>
          </div>
          <router-link to="UserPage"><p>{{checkPage}}</p></router-link>
        </div>
      </ul>
    </nav>
  </header>
</template>

<script>

export default {
  name: "NavBar.vue",
  props: ["isLoggedIn"],
  inject: ['SessionService'],
  data(){
    return {
    }
  },

  methods: {
    handleLogout(){
      this.SessionService.signOut();
    }
  },
  computed: {
    checkPage(){
      if (this.isLoggedIn === false){
        return "Log in"
      }else{
        if (this.SessionService.currentAccount != null){
          return this.SessionService.currentAccount.username.toString();
        }
        return ""


      }
    }
  }
}
</script>

<style scoped>

header{
  background-color: #333;
  padding-inline: 10px;
  margin: 0;
}
nav {
  display: flex;
  justify-content: space-between;
  align-items: center;
  height: 100%;
  padding-bottom: 5px;
  padding-top: 5px;
  margin: 0;
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  display: flex;
  justify-content: flex-end;
  align-items: center;
  height: 100%;
}

.username {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  background-color:  #002B7F;
  border-radius: 10px;
  margin-left: 50px;
}

.username p{
  color: white;
  margin-bottom: 0;
  margin-right: 10px;
}


li:first-child {
  margin-left: 0;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  margin: 0;
  text-decoration: none;
  border-right: 1px solid white;
}

li a:hover {
  background-color: #111;
}

.logo {
  padding: 10px;
}

.logo img {
  height: 50px;
}
/* Style The Dropdown Button */
.dropbtn {
  color: white;
  background-color: #333;
  font-size: 16px;
  padding: 14px 16px;
  margin-right: 5px;
  border: none;
  cursor: pointer;
  border-right: 1px solid white;
  border-left: 1px solid white;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
  position: relative;
  display: inline-block;
  margin: 0;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 120px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
  margin: 0;
}

/* Links inside the dropdown */
.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  margin: 0;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {background-color: #f1f1f1}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
  display: block;
}

/* Change the background color of the dropdown button when the dropdown content is shown */
.dropdown:hover .dropbtn {
  background-color: #111;
}


</style>