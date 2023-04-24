<template>
    <NavBar></NavBar>

    <div class="screen">

        <div class="card">
            <div class="input">
                <v-banner>
                    <div class="container">
                        <div class="row">
                            <h3>Welkom</h3>
                            <p>Hieronder staan een paar uitgelichte gegevens!</p>
                        </div>
                    </div>
                </v-banner>
            </div>


        </div>

    </div>


    <div class="background">
        <img src="../adminpage/Ludobackground.png">
    </div>


</template>

<script>
import NavBar from "@/components/NavBar.vue";

export default {
    name: "AdminDashboard",
    components: {NavBar}
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

.card {
    display: flex;
    flex-direction: column;
    margin-top: 50px;
    align-items: center;
    background: white;
    width: 50%;
}

</style>