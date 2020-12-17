<template>
  <div id="signup">

    <div class="form-div">

      <!--formulaire d'inscription-->
      <div class="title">Sign up</div>

      <form action="" class="sign-up-form">

        <input type="text" id="username" placeholder="userName" />

        <input type="mail" id="mail" placeholder="mail" />

        <input type="text" id="pseudo" placeholder="Pseudo" />

        <input type="password" id="password" placeholder="password" />

        <button v-on:click="postUser" value="Login" class="btn">Envoyer</button>

      </form>
    </div>
  </div>
</template>

<script>
import Vue from "vue";
import VueSimpleAlert from "vue-simple-alert";
Vue.use(VueSimpleAlert);

export default {
  name: "Signup",
  data: () => {
    return {};
  },
  methods: {
    postUser: async () => {
      var username = document.getElementById("username").value;
      var password = document.getElementById("password").value;
      var pseudo = document.getElementById("pseudo").value;
      var mail = document.getElementById("mail").value;
      console.log(
        "username : " +
          username +
          "\npassword : " +
          password +
          "\npseudo : " +
          pseudo +
          "\nmail : " +
          mail
      );

      const rawResponse = await fetch(
        "http://localhost:8085/user/registration",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            username: username,
            password: password,
            name: pseudo,
            email: mail,
          }),
        }
      );
      const content = await rawResponse.json();
      console.log("réponse de la requete de création d'un utilisateur : ");
      console.log(content);
      if (content == true) {
        console.log(
          "Votre compte à bien été créé. Vous pouvez maintenant vous connecter avec vos identifiants"
        );
      } else {
        console.log(
          "Erreur dans la création de votre compte, veuillez réessayer s'il vous plaît"
        );
      }
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

.sign-up-form{
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