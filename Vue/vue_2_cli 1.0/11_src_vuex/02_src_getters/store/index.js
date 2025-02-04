import Vue from 'vue'
import Vuex from "vuex"

// 使用Vuex插件
Vue.use(Vuex)

// 创建actions: 用于响应组件中的动作
const actions = {
  // add(context, value) {
  //   console.log('actions中的add被调用了')
  //   context.commit('ADD', value)
  // },
  // subtract(context, value) {
  //   console.log('actions中的subtract被调用了')
  //   context.commit('SUBTRACT', value)
  // },
  addOdd(context, value) {
    console.log('actions中的addOdd被调用了')
    if (context.state.sum % 2) {
      context.commit('ADD', value)
    }
  },
  addWait(context, value) {
    console.log('actions中的addWait被调用了')
    setTimeout(() => {
      context.commit('ADD', value)
    }, 500)
  }
}

// 准备mutations: 用于操作数据 (state)
const mutations = {
  ADD(state, value) {
    state.sum += value
  },
  SUBTRACT(state, value) {
    state.sum -= value
  },
}

// 准备state: 用于存储数据
const state = {
  sum: 0
}

// 准备getters: 用于将state中的数据进行加工
const getters = {
  bigSum(state) {
		return state.sum*10
	}
}

// 创建Vuex中的store
const store = new Vuex.Store({
  actions,
  mutations,
  state,
  getters
})

export default store