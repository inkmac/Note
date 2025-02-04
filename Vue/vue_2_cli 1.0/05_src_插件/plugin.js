export default {
  install(Vue) {
    console.log('install', Vue)

    // 定义全局指令
    Vue.directive()

    // 定义混入
    Vue.mixin({})
  }
}