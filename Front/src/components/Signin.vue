<template>

  <div id="signin">
    
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
        <button v-on:click="login" value="login" class="btn solid">Envoyer</button>
      </form>
    </div>
  </div>

</template>

<script>
export default {
    name:'Signin',
    data: () => {
        return {

        }
    },
     methods: {
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