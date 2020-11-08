import {Renderer as Vue} from "@vue/runtime-core";
import VueRouter from "vue-router";


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
        { path: '/', component: Home },
        { path: '/login', component: Login },
        { path: '/connect', component: Connect },
        { path: '/plannif', component: Planif },
    ]
});


Vue.createApp ({
    router
}).mount('#app');

