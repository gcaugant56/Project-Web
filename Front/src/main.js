/* eslint-disable */ 
// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import router from './router'
import Home from './components/Home'
import Signup from './components/Signup'
import Signin from './components/Signin'
import Account from './components/Account'
import Planif from './components/Planif'
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { Home, Signup, Signin, Account, Planif },
})
