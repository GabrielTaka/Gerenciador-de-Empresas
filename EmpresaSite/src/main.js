import 'babel-polyfill'
import Vue from 'vue'
import Vuex from "vuex"
import VueRouter from 'vue-router'
import VueResource from "vue-resource/dist/vue-resource"

import vuetify from './packs/plugins/vuetify'
import i18n from '@/locales/i18n'

//store functions
import store from './store'
import router from '@/packs/router_by_path'
import App from './packs/app_by_path'

Vue.use(VueRouter)
Vue.use(VueResource)
Vue.use(Vuex)

//import 'material-design-icons-iconfont/dist/material-design-icons.css'
import '@mdi/font/css/materialdesignicons.css' // Ensure you are using css-loader

document.addEventListener('DOMContentLoaded', () => {
  document.body.appendChild(document.createElement('app'))
  new Vue({
    render: h => h(App),
    router,
    el: 'app',
    template: '<App/>',
    components: { App },
    vuetify,
    store,
    i18n
  }).$mount("#app")
})
