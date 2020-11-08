<template>
      <get-user id="getUser"/>
      <post-user id="postUser"/>
</template>

<script>

import getUser from './components/getUser.vue';
import postUser from "./components/postUser.vue";

export default {
  name: 'App',
  components: {
    getUser,
    postUser,
  }
}
</script>
getUser.vue
postUser.vue
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
#getUser {
  background-color: antiquewhite;
  display: flex;
  grid-template-columns: 200px 200px 200px;
}

#postUser {
  background-color: aquamarine;
  display: flex;
}
</style>


