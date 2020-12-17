<template>
  <div id="account" class="main-account">
    <div class="container-account">
      <div class="title-account">Mon compte</div>
      <div class="user-account">
        <div class="ligne-account">
          <div class="text">ID : </div>
          <div class="text">{{}}</div>
        </div>
        <div class="ligne-account">
          <div class="text">Username : </div>
          <div class="text">{{}}</div>
        </div>
        <div class="ligne-account">
          <div class="text">Pseudo : </div>
          <div class="text">{{}}</div>
        </div>
        <div class="ligne-account">
          <div class="text">Password : </div>
          <div class="text"> **************</div>
          <button v-on:click="" class="btn-account">Modifier</button>
        </div>
        <div class="ligne-account">
          <div class="text">Mail : </div>
          <div class="text">{{}}</div>
          <button v-on:click="" class="btn-account">Modifier</button>
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
.main-account{
  display: flex;
  align-items: center;
  border: 1px solid black;
  background-color: #fff;
  margin: 0 auto;
  width: 400px;
  box-shadow: -0.6rem 0.6rem 0 rgba(29, 30, 28, 0.26);
  margin-top: 50px;
  justify-content: center;
}

.title-account {
  text-align: center;
  padding: 8px;
  font-weight: 700;
  border-bottom: 1px solid black;
   
}

.container-account{
  width: 400px;
}

.user-account{
  display: flex;
  flex-direction: column;
  margin: 0.5rem;
}

.ligne-account{
  display: flex;
  flex-direction: row;
  align-items: center;
  padding-top: 0.5rem;
  height: 40px;
}

.btn-account{
  display: flex;
  justify-content: flex-end;
  border: 2px solid rgba(0, 0, 0, 0.6);
  background-image: none;
  background-color: #dadad3;
  -webkit-box-shadow: none;
  -moz-box-shadow: none;
  box-shadow: none;
  padding: 5px;
  margin-top: 0px;
  margin-bottom: 0px;
  margin-left: 0.5rem;
  margin-right: 0.5rem;

}

</style>