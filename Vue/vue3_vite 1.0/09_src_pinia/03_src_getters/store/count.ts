import {defineStore} from "pinia";

const useCountStore = defineStore('count', {
  // actions
  actions: {
    increment(value: number) {
      // this 指向当前store
      this.sum += value
    }
  },

  // state: 用于存储数据
  state() {
    return {
      sum: 0,
      language: 'javascript',   // 其他数据
      frame: 'Vue'
    }
  },

  getters: {
    bigSum(): number {
      // this 指向当前store
      return this.sum * 10
    }

    // 函数的第一个参数为state, 和this一样都指向当前store
    // bigSum(state): number {
    //   return state.sum * 1000
    // }
  }
});


export default useCountStore;