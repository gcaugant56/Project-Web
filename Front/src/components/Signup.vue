<template>
    <div class="forms-container">
            <div class="signin-signup">


              <!--formulaire de connexion-->
              <form action="" class="sign-in-form">
                <h2 class="title">Sign in</h2>
                <div class="input-field">
                  <i class="fas fa-user"></i>
                  <input type="text" id="username-login" placeholder="userName">
                </div>
                <div class="input-field">
                  <i class="fas fa-lock"></i>
                  <input type="password" id="password-login" placeholder="password">
                </div>
                <button v-on:click="login" value="Login" class="btn solid">Envoyer</button>
              </form>


              <!--formulaire d'inscription-->
              <form action="" class="sign-up-form">
                <h2 class="title">Sign up</h2>
                <div class="input-field">
                  <i class="fas fa-user"></i>
                  <input type="text" id="username" placeholder="userName">
                </div>
                <div class="input-field">
                  <i class="fas fa-at"></i>
                  <input type="mail" id="mail" placeholder="mail">
                </div>
                <div class="input-field">
                  <i class="fas fa-user-tag"></i>
                  <input type="text" id="pseudo" placeholder="Pseudo">
                </div>
                <div class="input-field">
                  <i class="fas fa-lock"></i>
                  <input type="password" id="password" placeholder="password">
                </div>
                <button v-on:click="postUser" value="Login" class="btn solid">Envoyer</button>
                </form>
            </div>
          </div>
</template>

<script>
export default {
    name:'Signup',
    data: () => {
        return {

        }
    },
     methods: {
        postUser: async() => {
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var pseudo = document.getElementById("pseudo").value;
            var mail = document.getElementById("mail").value;
            console.log("username : " + username + "\npassword : " + password + "\npseudo : " + pseudo + '\nmail : ' + mail);
      
            const rawResponse = await fetch('http://localhost:8085/user/registration', {
              method: 'POST',
              headers: {
                'Content-Type': 'application/json'
              },
            body: JSON.stringify({username: username, password: password, name: pseudo, email: mail})
            });
            const content = await rawResponse.json();
            console.log(content);
            },

        login() {

            console.log()
            var nameUser = document.getElementById("username-login").value;
            var passwordUser = document.getElementById("password-login").value;
                fetch("http://localhost:8085/user/authentification", {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({username: nameUser, password: passwordUser})
                })
                .then( response => {
                    response.json().then(data => {
                    console.log(data.token);
                    if(response.status == 200){
                        $cookies.set('token', data.token);
                        this.$router.push({ path: '/'});
                    }else{
                    }
                    })})
            }
    }

}
</script>

<style>

</style>