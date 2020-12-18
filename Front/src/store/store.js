import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)


const mutations = {
    event(state,name) {
     state.event = name
    } 
}


let store =  new Vuex.Store({
    state: name,
    mutations : mutations,
});

global.store = store;
export default store 