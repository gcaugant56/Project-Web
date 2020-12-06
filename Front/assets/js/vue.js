
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
            id: '',
            username: '',
            pseudo: '',
            mail: '',
            events: {
                id: '',
                name: '',
                place:'',
                participant: [],
                date:'',
                creator:'',
                
            },
            tab: [],
        }
    },
    methods: {
        getUser() {
            if (store.token == "" || store.token == "null"){
                console.log("aucun token");
            }else{
                console.log('Bearer ' + store.token);
                fetch("http://localhost:8085/user", {
                method: 'GET',
                headers: {
                    'Authorization': 'Bearer ' + store.token,
                }})
            .then( response => {
                response.json().then(data => {
                console.log(data);
                this.id = data.id;
                this.username = data.username;
                this.pseudo = data.name;
                this.mail = data.email;
                })})
            }
        },
        getEvent() {
                fetch("http://localhost:8085/event/all", {
                method: 'GET',
                headers: {
                    'Authorization': 'Bearer ' + store.token,
                }})
            .then( response => {
                response.json().then(data => {
                console.log(data);
                data.forEach(element => {
                    var event = new Object();
                    event.id = element.id;
                    event.username = element.username;
                    event.name = element.name;
                    event.participant = element.participant;
                    event.date = element.date;
                    event.creator = element.creator;
                    this.tab.push(event);
                });
                console.log(this.tab);
                console.log("fin affichage tab");
            })})
        },
    },
    mounted() {
        store.commit('getCookie');
        console.log("home | fin mounted | valeur token store | " + store.token);
        this.token = store.token;
        this.getUser();
        this.getEvent();

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
                        $cookies.set('token', JSON.stringify(data.token));
                        this.$router.push({ path: '/'});
                    }else{
                    }
                    })})
            }
    }
  
};


const Planif = {
    template: '#planif',
    name: 'Planif',
    data: ()=> {
        return {
            token: "",

        }
    },
    methods: {

    },
    mounted() {
        
    }
};


//router
const router = new VueRouter({
    routes: [
        { path: '/', component: Home, name: 'Home' },
        { path: '/sign-up', component: Signup, name: 'Signup' },
        { path: '/plannif', component: Planif, name: 'Planif' },
    ]
});

const vue = new Vue({
    router
}).$mount("#app");


