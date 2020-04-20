import Vue from 'vue'
import App from './App'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
import router from './router'

Vue.use(Vuetify)
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  // 定义Vue绑定的根元素
  el: '#app',
  // 将上面声明的路由器传递到根Vue实例
  router,
  // store, // 使用store
  // 初始化Vuetify
  vuetify: new Vuetify(),
  // 声明App组件，这样<App/>元素就可以生效
  components: {
    App
  },
  // 用<App/>代替根元素
  template: '<App/>'
}).$mount('#app') // 将这个实例挂载到id=app的根元素上
