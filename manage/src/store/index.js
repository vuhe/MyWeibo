import Vuex from 'vuex'
import Vue from 'vue'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    isLogin: false
  },
  getters: {
    isLogin () {
      let token = Vue.$cookies.get('token')
      return !(!token || !/\S/.test(token))
    }
  }
})

export default store
