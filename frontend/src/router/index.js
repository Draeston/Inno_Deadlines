import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import store from '../store/index'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/signin',
    name: 'SignIn',
    component: () => import('../views/SignIn.vue')
  },
  {
    path: '/signup',
    name: 'SignUp',
    component: () => import('../views/SignUp.vue')
  },
  {
    path: '/assignment/:assignmentId',
    name: 'Assignment',
    component: () => import('../views/Assignment.vue')
  },
  {
    path: '/add',
    name: 'Add',
    component: () => import('../views/Add.vue')
  }
]

const router = new VueRouter({
  routes
})

router.beforeEach((to, from, next) => {
  if (!store.state.isLogged && to.path !== '/signin' && to.path !== '/signup') {
    next('/signin')
  } else {
    next()
  }
})

export default router
