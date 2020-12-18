<template>
  <div id="homepage" class="body">
    <div v-if="token == null" class="main">
      <h1>Veuillez vous connecter svp</h1>
    </div>
    <div v-else class="main">
      <div class="user">
        <div class="title-user">Bonjour {{ pseudo }}, comment allez-vous aujourd'hui ?</div>
      </div>

      <div class="main-events" v-if="this.data[0]">
        <div class="titletitle">Vos évenements</div>
        <div class="events">
          <div class="event" v-for="event in data" v-if="event.creator == username">
            <div class="evenement" v-on:click="store.state.event = event,$router.push({ path: '/vote'})">
              <div class="title">{{ event.name }}</div>
              <div class="event-info">
                <div class="text">lieu : {{event.place}}</div>
                <div class="text">date : {{event.date}}</div>
                <div class="text">Participants : {{ event.participant }}</div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="main-events" v-if="this.data[0]">
        <div class="titletitle">Les évenements auxquels vous êtes invités</div>
        <div class="events">
          <div class="event" v-for="event in data" v-if="event.creator != username">
            <div class="evenement" v-on:click="store.state.event = event,$router.push({ path: '/vote'})">
              <div class="title">{{ event.name }}</div>
              <div class="event-info">
                <div class="text">lieu : {{event.place}}</div>
                <div class="text">date : {{event.date}}</div>
                <div class="text">Participants : {{ event.participant }}</div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="main-events" v-else>
        <div class="titletitle">Vos évenements</div>
        <div class="events">
          <div class="event">
            <div class="evenement" v-on:click="$router.push({ path: '/plannif'})">
              <div class="title">Désolé, vous n'avez pas encore d'évenements. <br> clic sur ce cadre pour aller en créer un dès maintenant !</div>
              </div>
            </div>
          </div>
        </div>
      </div>

    </div>
  </div>
</template>

<script>
import Vue from "vue";
import VueCookies from "vue-cookies";
import store from '../store/store.js'
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
      store: store,
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
.evenement {
  cursor: pointer;
}

.evenement:hover {
  background-color: rgba(29, 30, 28, 0.05);
}

.main {
  display: flex;
  flex-direction: column;
  align-items: center;

}

.user {
  display: flex;
  flex-direction: column;
}

.event {
  display: flex;
  flex-direction: row;
  border: 1px solid black;
  min-width: 300px;
  background-color: #fff;
  margin: 0.5rem 0.5rem;
  box-shadow: -0.6rem 0.6rem 0 rgba(29, 30, 28, 0.26);
}

.events{
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: center;
}

.main-events {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 2rem;
}

.title {
  text-align: center;
  padding: 8px;
  font-weight: 700;
  border-bottom: 1px solid black;
}

.titletitle {
  text-align: center;
  padding: 8px;
  font-weight: 700;
  border-bottom: 1px solid black;
  font-size: 1.6rem;
}

.title-user {
  text-align: center;
  padding: 8px;
  font-weight: 700;
  font-size: 1.6rem;
  margin-bottom: 2rem;
}

.event-info{
  margin: 0.2rem;
  flex-direction: column;
  flex-wrap: wrap;
  
}

.text{
  display: flex;
  flex-wrap: wrap;
}

.body{
  margin-left: 5%;
  margin-right: 5%;
}
</style>