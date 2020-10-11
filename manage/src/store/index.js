import Vuex from 'vuex'
import Vue from 'vue'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    isLogin: false,
    username: '请登录'
  },
  getters: {
    isLogin () {
      let token = Vue.$cookies.get('token')
      return !(!token || !/\S/.test(token))
    }
  }
})

export default store
