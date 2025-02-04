import Vue from 'vue'
import App from './App'

// 引入ElementUI组件库
import { Button, Row, DatePicker } from 'element-ui'

Vue.config.productionTip = false

// 使用ElementUI组件
Vue.component(Button.name, Button)
Vue.component(Row.name, Row)
Vue.component(DatePicker.name, DatePicker)

new Vue({
  render: h => h(App),
}).$mount('#app')