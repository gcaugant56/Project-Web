const Home = {
    template: '<h1>HOME</h1>',
    name: 'Home'
};
const Login = {
    template: '<h1>inscrire</h1>',
    name: "Login"
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
