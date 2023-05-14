<template>
 <NavBar></NavBar>

    <div class="screen">

        <div class="user-list-card">
            <h1 class="user-list-title">User List</h1>
            <p class="user-list-subtitle">Edit or delete users</p>
            <div class="user-table">
                <table>
                    <thead>
                    <tr>
                        <th>Username</th>
                        <th>Firstname</th>
                        <th>Lastname</th>
                        <th>Email</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr v-for="user in users" :key="user">
                        <td>{{ user.username }}</td>
                        <td>{{ user.firstname }}</td>
                        <td>{{ user.lastname }}</td>
                        <td>{{ user.email }}</td>
                        <td>
                            <v-btn>Edit</v-btn>
                            <v-btn @click="deleteUser(user.userId)">Delete</v-btn>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

    </div>




    <div class="background">
        <img src="../adminpage/Ludobackground.png">
    </div>
</template>


<script>
import NavBar from "@/components/NavBar.vue";
import {toast} from "vue3-toastify";


export default {
    name: "AdminUsersList",
    components: {NavBar},
    inject: ['userService'],
    data() {
        return {
            users: [],
        }
    },
    async created() {
        this.users = await this.userService.asyncFindAll();
    },

    methods: {

      async deleteUser(id) {
        const confirmationMessage = confirm("Are you sure you want to delete this account?")

        if (confirmationMessage === true) {
          try {
            await this.userService.asyncDeleteById(id);
            location.reload();
            toast.success("Account successfully deleted!");
          } catch (e) {
            console.log(e)
            toast.error("Account couldn't be deleted, please check the console.");
          }
        }
      }
  }
}


</script>


<style scoped>

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

.screen {
    display: flex;
    flex-direction: column;
    align-items: center;
}

.user-list-card {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    background: white;
    width: 80%;
    padding: 20px;
    margin-top: 50px;
}

.user-list-title {
    font-size: 24px;
    font-weight: bold;
    margin-bottom: 10px;
}

.user-list-subtitle {
    font-size: 16px;
    margin-bottom: 20px;
}

.user-list-card {
    background-color: #fff;
    border-radius: 10px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.15);
    padding: 1rem;
    margin: 50px auto 0;
    max-width: 600px;
    text-align: center;
}

.user-table {
    overflow-x: auto;
}

table {
    border-collapse: collapse;
    width: 100%;
    margin-top: 1rem;
}

th, td {
    padding: 0.75rem;
    text-align: left;
}

th {
    font-weight: bold;
    background-color: #f7f7f7;
}

td button {
    margin-right: 0.5rem;
}


</style>