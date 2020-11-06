import axios from 'axios'
<template>
  <div id="app">
    <div class="container">
      <div class="row">
        <p>Créer votre compte : </p>
        <br/>
        <label for="username">UserName :</label>
        <input type="text" id="username" name="username">
        <br/>
        <label for="Pseudo">Pseudo :</label>
        <input type="text" id="pseudo" name="pseudo">
        <br/>
        <label for="password">Password :</label>
        <input type="password" id="password" name="password">
        <br/>
        <button v-on:click="postUser()">Envoyer</button>

      </div>

    </div>
  </div>
</template>


<script>
export default {
  name: 'postUser',
  props: {
    msg: String
  },
  data: function() {
    return {
    username: "",
    password:"",
    pseudo:"",
  };
},
  methods:{
    test: function () {
      console.log("ça fonctionne")
    },
    postUser: async function () {
      var username = document.getElementById("username").value;
      var password = document.getElementById("password").value;
      var pseudo = document.getElementById("pseudo").value;
      console.log("username : " + username + "\npassword : " + password + "\npseudo : " + pseudo);

      const rawResponse = await fetch('http://localhost:8085/user/root?'+ "username=" + username + "&password=" + password + "&name=" + pseudo, {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }});
      const content = await rawResponse.json();
      console.log(content);
    }
  }
}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
