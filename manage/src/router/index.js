import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/common/Login'
import Data from '@/components/common/Data'
import Edit from '@/components/common/Edit'
import Api from '@/components/common/Api'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Data',
      component: Data
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/edit/:id',
      name: 'Edit',
      component: Edit
    },
    {
      path: '/api',
      name: 'Api',
      component: Api
    }
  ]
})

router.beforeEach((to, from, next) => {
  if (to.path === '/login') {
    next()
  } else {
    let token = Vue.$cookies.get('token')

    if (!token || !/\S/.test(token)) {
      next('/login')
    } else {
      next()
    }
  }
})

export default router
