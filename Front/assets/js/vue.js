const products = [
    {text: "blablabla"},
    {text: "azazazazaz"},
    {text: "qsqsqsqsqs"},
    {text: "wxwxwxwxwx"},
    {text: "rtrtrtrt"},
    {text: "fgfgfgfg"},
];

const Home = {
    template: "<h1>HOME</h1>",
    name: 'Home'
};
const Login = {
    template: '#login',
    name: "Login",
        data: ()=> {
            return {
                products,
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
            console.log("username : " + username + "\npassword : " + password + "\npseudo : " + pseudo);
      
            const rawResponse = await fetch('http://localhost:8085/registration', {
              method: 'POST',
              headers: {
                'Content-Type': 'application/json'
              },
            body: JSON.stringify({username: username, password: password, name: pseudo})
            });
            const content = await rawResponse.json();
            console.log(content);
            }
    }
  
};
const Connect = {
    template: '#connect',
    name: 'Connect',
    computed: {
    },
    methods: {
        getUser() {
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
                    this.$router.push({ path: '/'})
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
        { path: '/login', component: Login, name: 'Login' },
        { path: '/connect', component: Connect, name: 'Connect' },
        { path: '/plannif', component: Planif, name: 'Planif' },
    ]
});

const vue = new Vue({
    router
}).$mount("#app");


