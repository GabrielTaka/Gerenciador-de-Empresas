/**
 * Vue Router
 *
 * @library
 *
 * https://router.vuejs.org/en/
 */

// Lib imports
import Vue from 'vue'
import VueRouter from 'vue-router'

//Components
import Product from '@/components/Product'

Vue.use(VueRouter);
const router = new VueRouter({
  routes: [
    { path: "/products/:id", component: Product, props: true },
  ]
})

export default router
