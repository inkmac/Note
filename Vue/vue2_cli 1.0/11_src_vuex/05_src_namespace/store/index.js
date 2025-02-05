import Vue from 'vue'
import Vuex from "vuex"

Vue.use(Vuex)

// 求和相关的配置
const countOptions = {
  namespaced: true,
  actions: {
    add(context, value) {
      console.log('actions中的add被调用了')
      context.commit('ADD', value)
    },
    subtract(context, value) {
      console.log('actions中的subtract被调用了')
      context.commit('SUBTRACT', value)
    },
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
  },
  mutations: {
    ADD(state, value) {
      state.sum += value
    },
    SUBTRACT(state, value) {
      state.sum -= value
    },
  },
  state: {
    sum: 0,
    school: 'Vue',
    subject: 'computer'
  },
  getters: {
    bigSum(state) {
      return state.sum * 10
    }
  }
}

const store = new Vuex.Store({
  modules: {
    count: countOptions
  }
})

export default store