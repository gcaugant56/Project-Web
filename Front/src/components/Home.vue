<template>
  <div id="homepage">
    <h1>Home Page</h1>
    <div v-if="token == null">
      <h1>Veuillez vous connecter svp</h1>
    </div>
    <div v-else>
      <h1>Bonjour {{ pseudo }}</h1>
      <h2>UserName : {{ username }}</h2>
      <h2>Mail : {{ mail }}</h2>

      <h1>Vos évenements</h1>
      <div class="event" v-for="event in data">
        <p>Nom : {{ event.name }}</p>
        <p>Participants : {{ event.participant }}</p>
      </div>
    </div>
  </div>
</template>

<script>
import Vue from "vue";
import VueCookies from "vue-cookies";
Vue.use(require("vue-cookies"));
Vue.use(VueCookies);

export default {
  name: "Home",
  data: () => {
    return {
      token: "",
      id: "",
      username: "",
      pseudo: "",
      mail: "",
      data: [],
    };
  },
  methods: {
    getUser() {
      if (this.token == "" || this.token == "null") {
        console.log("aucun token");
      } else {
        console.log("Bearer " + this.token);
        fetch("http://localhost:8085/user", {
          method: "GET",
          headers: {
            Authorization: "Bearer " + this.token,
          },
        }).then((response) => {
          response.json().then((data) => {
            console.log(data);
            this.id = data.id;
            this.username = data.username;
            this.pseudo = data.name;
            this.mail = data.email;
          });
        });
      }
    },
    getEvent() {
      fetch("http://localhost:8085/event/all", {
        method: "GET",
        headers: {
          Authorization: "Bearer " + this.token,
        },
      }).then((response) => {
        response.json().then((data) => {
          this.data = data;
          console.log(this.data);
          console.log("fin affichage tab");
        });
      });
    },
  },
  mounted() {
    this.token = $cookies.get("token");
    console.log("home | fin mounted | valeur token store | " + this.token);
    this.getUser();
    this.getEvent();
  },
};
</script>
<style>
.event {
  padding-top: 20px;
  padding-bottom: 20px;
}
</style>