<template>
  <div id="signin">

    <div class="form-div">

      <!--formulaire de connexion-->
      <div class="title">Sign in</div>

      <form action="" class="sign-in-form">

        <input type="text" id="username-login" placeholder="userName" />

        <input type="password" id="password-login" placeholder="password" />

        <button v-on:click="login" value="login" class="btn">Envoyer</button>
      </form>
    </div>
  </div>
</template>

<script>
import Vue from "vue";
import VueSimpleAlert from "vue-simple-alert";
Vue.use(VueSimpleAlert);

export default {
  name: "Signin",
  data: () => {
    return {};
  },
  methods: {
    login() {
      console.log();
      var nameUser = document.getElementById("username-login").value;
      var passwordUser = document.getElementById("password-login").value;
      fetch("http://localhost:8085/user/authentification", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ username: nameUser, password: passwordUser }),
      }).then((response) => {
        response.json().then((data) => {
          console.log(data.token);
          if (response.status == 200) {
            $cookies.set("token", data.token);
            this.$router.push({ path: "/" });
          } else {
            this.$alert(
              "Nom d'utilisateur/Mot de passe incorrecte, Veuillez réessayer"
            );
          }
        });
      });
    },
  },
};
</script>

<style>

.form-div {
  border: 1px solid black;
  max-width: 300px;
  background-color: #fff;
  margin: 0 auto;
  box-shadow: -0.6rem 0.6rem 0 rgba(29, 30, 28, 0.26);
  display: flex;
  justify-content: center;
  flex-direction: column;
  margin-top: 50px;
}

.title {
  text-align: center;
  padding: 8px;
  font-size: 14px;
  font-weight: 700;
  border-bottom: 1px solid black;
}

.sign-in-form{
  padding: 20px;
  display: flex;
  flex-direction: column;
}

.btn{
  margin-top: 10px;
  align-self: flex-end;
  cursor: pointer;
  font-weight: 500;
}
</style>