import Vue from 'vue'
import App from './App'
import plugin from './plugin'

Vue.config.productionTip = false

// 使用插件
Vue.use(plugin)

new Vue({
  render: h => h(App),
}).$mount('#app')