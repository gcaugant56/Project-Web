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
}

.container{
  display: flex;
  flex-direction: column;
  width: 400px;
}

.ligne{
  display: flex;
  flex-direction: row;
  align-items: center;
  padding-top: 0.5rem;
  height: 40px;
}
</style>