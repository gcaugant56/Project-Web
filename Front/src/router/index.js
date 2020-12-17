/* eslint-disable */ 
import Vue from 'vue'
import Router from 'vue-router'
import Home from '../components/Home'
import Signup from '../components/Signup'
import Signin from '../components/Signin'
import Account from '../components/Account'
import Planif from '../components/Planif'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/signup',
      name: 'Signup',
      component: Signup
    },
    {
      path: '/signin',
      name: 'Signin',
      component: Signin
    },
    {
      path: '/my-account',
      name: 'account',
      component: Account
    },
    {
      path: '/plannif',
      name: 'Planif',
      component: Planif
    }
      
  ]
})
