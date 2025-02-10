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
  }
});


export default useCountStore;