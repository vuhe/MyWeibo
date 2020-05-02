import Vue from 'vue'
import Router from 'vue-router'
import MainContent from '../components/content/MainContent'
import InfoContent from '../components/content/InfoContent'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'MainContent',
      component: MainContent
    },
    {
      path: '/info',
      name: 'InfoContent',
      component: InfoContent
    }
  ]
})
