
const store = new Vuex.Store({
    token: "",
    mutations: {
        getCookie() {
            if($cookies.get('token')){
                cookie = JSON.parse($cookies.get('token'));
                console.log("store | getcookie() | valeur token | " + cookie);
                store.token = cookie;
                return cookie;
            }else{
                console.log("il n'y a pas de cookie token");
            }
        },
    }
})

const Home = {
    template: "#home",
    name: 'Home',
    data:() => {
        return {
            token: '',
        }
    },
    methods: {
        getUser() {
            if (store.token == "" || store.token == "null"){
                console.log("aucun token");
            }else{
                fetch("http://localhost:8085/user", {
                method: 'GET',
                headers: {
                    'Authorization': 'Bearer ' + store.token,
                }})
            .then( response => {
                response.json().then(data => {
                console.log(data);
                })})
            }
        }
    },
    mounted() {
        store.commit('getCookie');
        console.log("home | fin mounted | valeur token store | " + store.token);
        this.token = store.token;
        this.getUser();
    }
};
const Signup = {
    template: '#signup',
    name: "Signup",
        data: ()=> {
            return {
            }
        },
    computed: {
    },
    methods: {
        test() {
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var pseudo = document.getElementById("pseudo").value;
            console.log("username : " + username + "\npassword : " + password + "\npseudo : " + pseudo);
          },
          postUser: async() => {
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var pseudo = document.getElementById("pseudo").value;
            var mail = document.getElementById("mail").value;
            console.log("username : " + username + "\npassword : " + password + "\npseudo : " + pseudo + '\nmail : ' + mail);
      
            const rawResponse = await fetch('http://localhost:8085/registration', {
              method: 'POST',
              headers: {
                'Content-Type': 'application/json'
              },
            body: JSON.stringify({username: username, password: password, name: pseudo, email: mail})
            });
            const content = await rawResponse.json();
            console.log(content);
            }
    }
  
};
const Login = {
    template: '#login',
    name: 'Login',
    computed: {
    },
    methods: {
        login() {
           var nameUser = document.getElementById("usernamefield").value;
           var passwordUser = document.getElementById("passwordfield").value;
            fetch("http://localhost:8085/authentification", {
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
                    $cookies.set('token', JSON.stringify(data.token));
                    this.$router.push({ path: '/'});
                }else{
                }
                })})
        }
    }
};
const Planif = {
    template: '<h1>Plannifier une réunion</h1>',
    name: 'Planif'
};


//router
const router = new VueRouter({
    routes: [
        { path: '/', component: Home, name: 'Home' },
        { path: '/sign-up', component: Signup, name: 'Signup' },
        { path: '/login', component: Login, name: 'Login' },
        { path: '/plannif', component: Planif, name: 'Planif' },
    ]
});

const vue = new Vue({
    router
}).$mount("#app");


