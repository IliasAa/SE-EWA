<template>
 <NavBar></NavBar>

    <div>
        <link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"/>
        <hr/>
        <div class="container bootstrap snippets bootdey">
            <div class="row">
                <div class="col-lg-10">
                    <div class="main-box no-header clearfix">
                        <div class="main-box-body clearfix">
                            <div class="table-responsive">
                                <table class="table user-list">
                                    <thead>
                                    <tr>
                                        <th><span>Username</span></th>
                                        <th><span>Firstname</span></th>
                                        <th><span>Lastname</span></th>
                                        <th><span>Email</span></th>
                                        <th>&nbsp;</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr v-for="user in users" :key="user">
                                        <td>
                                            <img src="https://bootdey.com/img/Content/user_1.jpg" alt=""/>
                                            <a href="#/" class="user-link">{{user.username}}</a>
                                            <span class="user-subhead">{{user.role}}</span>
                                        </td>
                                        <td>{{user.firstname}}</td>
                                        <td>{{user.lastname}}</td>
                                        <td>{{user.email}}</td>
                                        <td>
                                            <a href="#/" class="table-link text-info">
                                                <span class="fa-stack">
                                                    <i class="fa fa-square fa-stack-2x"></i>
                                                    <i class="fa fa-pencil fa-stack-1x fa-inverse"></i>
                                                </span>
                                            </a>
                                            <a href="#/" class="table-link danger">
                                                <span class="fa-stack">
                                                    <i class="fa fa-square fa-stack-2x"></i>
                                                    <i class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
                                                </span>
                                            </a>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-2">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">New User</h5>
                            <button class="btn btn-success">Add User</button>
                        </div>
                    </div>
                </div>
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
      },
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

body{
    background:#eee;
}
.main-box.no-header {
    padding-top: 20px;
}
.main-box {
    background: #FFFFFF;
    -webkit-box-shadow: 1px 1px 2px 0 #CCCCCC;
    -moz-box-shadow: 1px 1px 2px 0 #CCCCCC;
    -o-box-shadow: 1px 1px 2px 0 #CCCCCC;
    -ms-box-shadow: 1px 1px 2px 0 #CCCCCC;
    box-shadow: 1px 1px 2px 0 #CCCCCC;
    margin-bottom: 16px;
    -webikt-border-radius: 3px;
    -moz-border-radius: 3px;
    border-radius: 3px;
}
.table a.table-link.danger {
    color: #e74c3c;
}

.label {
    border-radius: 3px;
    font-size: 0.875em;
    font-weight: 600;
}
.user-list tbody td .user-subhead {
    font-size: 0.875em;
    font-style: italic;
}
.user-list tbody td .user-link {
    display: block;
    font-size: 1.25em;
    padding-top: 3px;
    margin-left: 60px;
}
a {
    color: #3498db;
    outline: none!important;
}
.user-list tbody td>img {
    position: relative;
    max-width: 50px;
    float: left;
    margin-right: 15px;
}

.table thead tr th {
    text-transform: uppercase;
    font-size: 0.875em;
}
.table thead tr th {
    border-bottom: 2px solid #e7ebee;
}
.table tbody tr td:first-child {
    font-size: 1.125em;
    font-weight: 300;
}
.table tbody tr td {
    font-size: 0.875em;
    vertical-align: middle;
    border-top: 1px solid #e7ebee;
    padding: 12px 8px;
}
a:hover{
    text-decoration:none;
}


</style>