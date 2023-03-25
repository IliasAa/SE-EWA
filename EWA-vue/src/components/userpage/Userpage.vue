<template>
  <NavBar></NavBar>

  <div class="profile-card">
    <div class="profile-avatar">
      <img :src="avatarUrl" alt="Avatar">
    </div>
    <div class="profile-info">
      <h1 class="profile-username">TheDoomedChicken</h1>
      <p class="profile-fullname">ibrahim ghzawi</p>
      <p class="profile-email">Test@gmail.com</p>
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
      <button class="edit-button">Edit Profile</button>
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
}

.profile-username {
  font-size: 2rem;
  margin-bottom: 0.5rem;
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
  flex-direction: column;
  margin-bottom: 1rem;
}

.profile-wins,
.profile-coins {
  display: flex;
  flex-direction: column;
  margin-right: 1rem;
}

.stat-label {
  font-size: 1rem;
  font-weight: bold;
  margin-bottom: 0.25rem;
}

.stat-value {
  font-size: 1.5rem;
}

.edit-button {
  background-color: #007aff;
  color: #fff;
  border: none;
  border-radius: 5px;
  padding: 0.5rem;
  font-size: 1rem;
  cursor: pointer;
}

.edit-button:hover {
  background-color: #0065cc;
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