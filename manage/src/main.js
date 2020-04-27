import Vue from 'vue'
import ElementUI from 'element-ui'
import VueCookie from 'vue-cookies'
import 'element-ui/lib/theme-chalk/index.css'
import httpRequest from '@/utils/httpRequest'
import App from './App'
import router from './router'
import store from './store'

Vue.use(ElementUI)
Vue.use(VueCookie)
Vue.config.productionTip = false

// 挂载全局
Vue.prototype.$http = httpRequest // Ajax 请求方法

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store: store,
  components: { App },
  template: '<App/>'
})
