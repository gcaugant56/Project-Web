<template>
    <div>
        <p>{{event.name}}</p>
        <p> {{ event.place }}</p>
        <p> {{ event.participant }}</p>
        <p> Veuillez choisir votre date : </p>
        <button   v-for="dates in date" v-on:click="vote" name=dates> {{ dates }}</button>
        <p v-if="result === false"> Vous avez deja choisie cette option veuillez en choisir une autre</p>
        <p>Recapitulatif des votes :</p>
        <p  v-for="cou in count"> {{cou.date}} ---> {{cou.count}}</p>
    </div>
</template>

<script>
import Vue from "vue";
import VueCookies from "vue-cookies";
import store from '../store/store.js'
Vue.use(require("vue-cookies"));
Vue.use(VueCookies);

export default {
    name: "Vote",
    store:store,
    data: () => {
    return {
        event : store.state.event,
        date: store.state.event.date.split(","),
        result: '',
        count:''
    };
    
  },
  methods :{
      vote(event){
          fetch("http://localhost:8085/survey/create", {
            method: "POST",
            headers: {
            "Content-Type": "application/json",
            Authorization: "Bearer " + $cookies.get("token"),
            },
            body: JSON.stringify({voterChoice: event.target.innerHTML, voterEventId: this.event.id, voterName : ''}),
            }).then((response) => {
            response.json().then((data) => {
            this.result = data;
            this.counter();
         });
        });
      },
        counter(){
          fetch("http://localhost:8085/survey/count", {
            method: "POST",
            headers: {
            "Content-Type": "application/json",
            Authorization: "Bearer " + $cookies.get("token"),
            },
            body: JSON.stringify({id: this.event.id}),
            }).then((response) => {
            response.json().then((data) => {
            this.count = data;
         });
        });
      },
    },
   mounted(){
      this.counter();
  }
}
</script>

<style>

</style>