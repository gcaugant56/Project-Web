<template>
  <div id="signup">
    <div class="main-signup">
      <div class="form-div-signup">
        <!--formulaire d'inscription-->
        <div class="title-signup">Sign up</div>

        <form action="" class="sign-up-form">
          <input type="text" id="username" placeholder="userName" />

          <input type="mail" id="mail" placeholder="mail" />

          <input type="text" id="pseudo" placeholder="Pseudo" />

          <input type="password" id="password" placeholder="password" />

          <button v-on:click="postUser" value="Login" class="btn-signup">Envoyer</button>
        </form>
      </div>
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
    postUser() {
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

      fetch("http://localhost:8085/user/registration", {
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
      }).then((response) => {
        response.json().then((data) => {
          if (data == true){
            console.log("inscription réussie");
            this.$confirm("inscription réussie ! \n Vous pouvez mainteant vous connecter").then(()=>{this.$router.push({ path: "/signin" });});
          }else{
            console.log("erreur dans l'inscription");
            this.$alert("erreur de l'inscription. Merci de bien vouloir recommencer");
          }
        });
      });
    },
  },
};
</script>

<style>
.form-div-signup {
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

.title-signup {
  text-align: center;
  padding: 8px;
  font-weight: 700;
  border-bottom: 1px solid black;
}

.sign-up-form {
  padding: 20px;
  display: flex;
  flex-direction: column;
}

.btn-signup {
  margin-top: 10px;
  align-self: flex-end;
  cursor: pointer;
  font-weight: 500;
  border: 2px solid rgba(0, 0, 0, 0.6);
  background-image: none;
  background-color: #dadad3;
  -webkit-box-shadow: none;
  -moz-box-shadow: none;
  box-shadow: none;
  padding: 5px;
  margin-top: 10px;
}

.signup {
  top: 0%;
  left: 0%;
  width: 100%;
  height: 100%;
}

.main-signup {
  left: 0%;
  top: 0%;
}
</style>