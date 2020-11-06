import axios from 'axios'
<template>
  <div id="app">
    <div class="container">
      <div class="row">
        <p class="jumbotron">Se connecter sur : <input type="text" id="usernamefield" name="usernamefield"></p>
        <button v-on:click="getUser()">Envoyer</button>
        <p class="jumbotron">Vous êtes connecté en tant que : </p>

        <p>name : {{name}}</p>
        <p>username : {{username}}</p>
        <p>mot de passe : {{password}}</p>
        <p>id : {{id}}</p>
      </div>

    </div>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  data: function() {
    return {
    id:"",
    username: "",
    password:"",
    name:"",
    field:""
  };
},
  methods:{
    getUser: function () {
        var nameUser = document.getElementById("usernamefield").value;
        fetch("http://localhost:8085/user/root?username="+ nameUser)
        .then( response => {
            response.json().then(data => {
                console.log(data.username);
                this.username = data.username;
                this.password = data.password;
                this.id = data.id;
                this.name = data.name;
                console.log(nameUser)
            })
        }
      );
    },
    test: function () {
      console.log("ça fonctionne")
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
