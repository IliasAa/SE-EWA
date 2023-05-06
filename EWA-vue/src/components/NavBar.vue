<template>
  <header>
    <nav>
      <div class="logo">
        <router-link to="/Dashboard"><a href="#"><img src="../assets/Hvalogo.png" height="70" alt="Hva logo"></a>
        </router-link>
      </div>
      <h3 class="logo">Hva Ludo King</h3>
      <ul>
        <router-link to="/LeaderboardPage">
          <li><a href="#">Leaderboard</a></li>
        </router-link>
        <router-link to="Dashboard">
          <li><a href="#">Invite a friend</a></li>
        </router-link>
      </ul>
      <img src="../assets/icon.png" class="user-pic" @click="toggleMenu()">

      <div ref="subMenu" class="sub-menu-wrap" id="subMenu">
        <div class="sub-menu">
          <div class="user-info">
            <img src="../assets/icon.png">
            <h3> {{ checkPage }}</h3>
          </div>
          <hr>

          <router-link to="UserPage">
            <a href="#" class="sub-menu-link">
              <img src="../assets/profile.png">
              <p>Edit Profile</p>
              <span> > </span>
            </a>
          </router-link>

          <router-link to="/adminPage" v-if="isAdmin">
            <a href="#" class="sub-menu-link">
              <img src="../assets/profile.png">
              <p>Admin Dashboard</p>
              <span> > </span>
            </a>
          </router-link>

          <router-link to="settings">
            <a href="#" class="sub-menu-link">
              <img src="../assets/setting.png">
              <p>Settings</p>
              <span> > </span>
            </a>
          </router-link>

          <router-link to="/rulePage" target="_blank">
            <a href="#" class="sub-menu-link">
              <img src="../assets/help.png">
              <p>Rules</p>
              <span> > </span>
            </a>
          </router-link>

          <router-link to="/LoginPage">
            <a v-on:click="handleLogout()" href="#" class="sub-menu-link">
              <img src="../assets/logout.png">
              <p>Logout</p>
              <span> > </span>
            </a>
          </router-link>


        </div>
      </div>

    </nav>
  </header>
</template>

<script>

export default {
  name: "NavBar.vue",
  props: ["isLoggedIn"],
  inject: ['SessionService'],
  data() {
    return {
      drawer: null,
    }
  },

  methods: {
    handleLogout() {
      this.SessionService.signOut();
    },
    toggleMenu() {
      this.$refs.subMenu.classList.toggle("open-menu");
    }
  },
  computed: {
    checkPage() {
      if (this.isLoggedIn === false) {
        return "Log in"
      } else {
        if (this.SessionService.currentAccount != null) {
          return this.SessionService.currentAccount.username.toString();
        }
        return ""
      }
    },
    isAdmin() {
      return this.SessionService.isAdmin();
    }

  }
}
</script>

<style scoped>

* {
  margin: 0;
  padding: 0;
  font-family: sans-serif;
  box-sizing: border-box;
}

nav {
  background: black;
  width: 100%;
  padding: 10px 10%;
  display: flex;
  align-items: center;
  justify-content: space-between;
  position: relative;
}

.logo {
  width: 300px;
  color: white;
}


.user-pic {
  width: 40px;
  border-radius: 50%;
  cursor: pointer;
  margin-left: 30px;
}

nav ul {
  width: 100%;
  text-align: right;
}

nav ul li {
  display: inline-block;
  list-style: none;
  margin: 10px 20px;
}

nav ul li a {
  color: white;
  text-decoration: none;
}

nav ul li a:hover {
  color: yellow;
}

.sub-menu-wrap {
  position: absolute;
  top: 100%;
  right: 10%;
  width: 320px;
  max-height: 0px;
  overflow: hidden;
  transition: max-height 0.5s;
  z-index: 2;
}

.sub-menu-wrap.open-menu {
  max-height: 400px;
  position: absolute;
}

.sub-menu {
  background: white;
  padding: 20px;
  margin: 10px;
}

.user-info {
  display: flex;
  align-items: center;
}

.user-info h3 {
  font-weight: bold;
}

.user-info img {
  width: 60px;
  border-radius: 50%;
  margin-right: 15px;
}

.sub-menu hr {
  border: 0;
  height: 2px;
  width: 100%;
  background: #ccc;
  margin: 15px 0 10px;
}

.sub-menu-link {
  display: flex;
  align-items: center;
  text-decoration: none;
  color: #525252;
  margin: 12px 0;
}

.sub-menu-link p {
  width: 100%;
}

.sub-menu-link img {
  width: 40px;
  background: #e5e5e5;
  border-radius: 50%;
  padding: 8px;
  margin-right: 15px;
}

.sub-menu-link span {
  font-size: 22px;
  transition: transform 0.5s;
}

.sub-menu-link:hover span {
  transform: translate(5px);
}

.sub-menu-link:hover p {
  font-weight: 600;
}

</style>