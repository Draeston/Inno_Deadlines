import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    isLogged: localStorage.getItem('authToken') !== null,
    groups: [],
    currentElement: null,
    assignments: [],
    role: 'user'
  },
  mutations: {
  },
  actions: {
  },
  modules: {
  }
})
