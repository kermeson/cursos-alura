import Vue from 'vue'
import App from './App.vue'
// importando o módulo
import VueResource from 'vue-resource';
import VueRouter from 'vue-router';
import routes from './routes';

Vue.use(VueResource);
Vue.use(VueRouter);
let router = new VueRouter({ routes });
new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
