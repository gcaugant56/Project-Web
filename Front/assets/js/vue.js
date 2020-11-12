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
        },
        data: ()=> {
            return {
                products,
            }
        }
  
};
const Connect = {
    template: '<h1>Se connecter</h1>',
    name: 'Connect'
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


