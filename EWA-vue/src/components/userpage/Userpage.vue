<template>
  <NavBar></NavBar>

  <div class="profile-card">
    <button class="delete-button" @click="onDelete">Delete Account</button>
    <div class="profile-avatar">
      <img src="@/assets/icon.png">
    </div>
    <div class="profile-info">
      <h1 class="profile-username">TheDoomedChicken</h1>
      <p v-if="!editing" class="profile-fullname">{{ fullName }}</p>
      <input v-else class="profile-fullname editing" v-model="fullName" :class="{ error: fullNameError }" @change="onFullNameChange"/>
      <div v-if="fullNameError" class="error-message">{{ fullNameError }}</div>
      <p v-if="!editing" class="profile-email">{{ email }}</p>
      <input v-else class="profile-email editing" v-model="email" :class="{ error: emailError }" @change="onEmailChange"/>
      <div v-if="emailError" class="error-message">{{ emailError }}</div>
      <div class="profile-stats">
        <div class="profile-wins">
          <p class="stat-label">Wins</p>
          <p class="stat-value">10</p>
        </div>
        <div class="profile-coins">
          <p class="stat-label">Coins</p>
          <p class="stat-value">200</p>
        </div>
      </div>
      <button class="edit-button" @click="toggleEditing" :disabled="fullNameError || emailError">{{ editing ? 'Save' : 'Edit Profile' }}</button>
    </div>
  </div>




  <div class="background">
    <img src="../userpage/Ludobackground.png">
  </div>

</template>

<script>
import NavBar from "@/components/NavBar.vue";
export default {
  name: "UserPage",
  components: {NavBar},
  inject: ['userService'],
  data() {
    return {
      fullName: 'ibrahim ghzawi',
      email: 'Test@gmail.com',
      editing: false,
      emailError: null,
      fullNameError: null,
    };
  },
  methods: {
    toggleEditing() {
      this.editing = !this.editing;
    },
    onEmailChange() {
      this.emailError = null;
    },
    onFullNameChange() {
      this.fullNameError = null;
    },
    emailValidation() {
      if (!this.email.match("/^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-]+$/")) {
        this.emailError = 'Please enter a valid email address.';
      } else {
        this.emailError = null;
      }
    },
    fullNameValidation() {
      if (!this.fullName.match("/^[a-zA-Z]+$/")) {
        this.fullNameError = 'Please enter a valid full name.';
      } else {
        this.fullNameError = null;
      }
    },

    async onDelete() {
      const confirmationMessage = confirm("Weet je zeker dat u het account wilt verwijderen?")

      if (confirmationMessage === true) {
        try {
          alert("Account verwijderen mislukt! Check de console en probeer later nog eens.")
          // await this.userService.asyncDeleteById(67);
          // this.$router.push("/Dashboard");
        } catch (e) {
          console.log(e);
          alert("Account verwijderen mislukt! Check de console en probeer later nog eens.")
        }
      }
    },
  },
  watch: {
    email: function () {
      this.emailValidation();
    },
    fullName: function() {
      this.fullNameValidation();
    },
    name: "UserPage",
    components: {NavBar},
  }
}
</script>

<style scoped>

.profile-card {
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: #fff;
  border-radius: 10px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.15);
  padding: 1rem;
  margin: 50px auto 0;
  max-width: 600px;
  text-align: center;
}

.profile-avatar {
  width: 150px;
  height: 150px;
  border-radius: 50%;
  overflow: hidden;
  margin-bottom: 1rem;
}

.profile-avatar img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.profile-info {
  flex: 1;
  margin-bottom: 1rem;
  margin-top: 1rem;
}

.profile-username {
  font-size: 2rem;
  margin-bottom: 2rem;
}

.profile-fullname {
  font-size: 1rem;
  font-weight: bold;
  margin-bottom: 0.5rem;

}

.profile-email {
  font-size: 1rem;
  margin-bottom: 1rem;
}

.profile-stats {
  display: flex;
  flex-direction: row;
  margin-bottom: 2rem;
  margin-top: 2rem;
  justify-content: center;
}

.profile-wins,
.profile-coins {
  display: flex;
  flex-direction: column;
  margin: 1rem;
}

.stat-label {
  font-size: 1rem;
  font-weight: bold;
  margin-bottom: 0.25rem;
}

.stat-value {
  font-size: 1.5rem;
}

/**
Editing css
 */

.edit-button {
  background-color: #007aff;
  color: #fff;
  border: none;
  border-radius: 5px;
  padding: 0.5rem;
  font-size: 1rem;
  cursor: pointer;
}

.delete-button {
  display: flex;
  justify-self: center;
  background-color: red;
  color: white;
  border: none;
  padding: 5px 10px;
  margin-bottom: 2rem;
  border-radius: 10px;
  cursor: pointer;
}

.delete-button:hover {
  background-color: lightcoral;
}

.editing {
  border: 2px solid yellow;
  background-color: #ffffcc;
  margin: 1rem;
}

.edit-button:hover {
  background-color: #0065cc;
}

.error {
  border-color: red;
}
.error-message {
  color: red;
}

.background, .background img {
  width: 100vw;
  height: 100vh;
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