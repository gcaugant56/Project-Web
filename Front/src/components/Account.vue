<template>
  <div id="account" class="main">
    <div class="container">
      <div class="title">Mon compte</div>
      <div class="user">
        <div class="ligne">
          <div class="text">ID : </div>
          <div class="text">{{}}</div>
        </div>
        <div class="ligne">
          <div class="text">Username : </div>
          <div class="text">{{}}</div>
        </div>
        <div class="ligne">
          <div class="text">Pseudo : </div>
          <div class="text">{{}}</div>
        </div>
        <div class="ligne">
          <div class="text">Password : </div>
          <div class="text"> **************</div>
          <button v-on:click="" class="btn">Modifier</button>
        </div>
        <div class="ligne">
          <div class="text">Mail : </div>
          <div class="text">{{}}</div>
          <button v-on:click="" class="btn">Modifier</button>
        </div>
        

      </div>
    </div>

  </div>
</template>

<script>
import Vue from "vue";
import VueSimpleAlert from "vue-simple-alert";
Vue.use(VueSimpleAlert);

export default {
  name: "Account",
  data: () => {
    return {};
  },
  methods: {
  }
};
</script>

<style>
.main{
  display: flex;
  align-items: center;
  border: 1px solid black;
  background-color: #fff;
  margin: 0 auto;
  width: 400px;
  box-shadow: -0.6rem 0.6rem 0 rgba(29, 30, 28, 0.26);
  margin-top: 50px;
}

.title {
  text-align: center;
  padding: 8px;
  font-weight: 700;
  border-bottom: 1px solid black;
   justify-content: center;
}

.container{

}

.user{
  display: flex;
  flex-direction: column;
}

.ligne{
  display: flex;
  flex-direction: row;
  align-items: center;
  padding-top: 0.5rem;
  height: 40px;
}
</style>