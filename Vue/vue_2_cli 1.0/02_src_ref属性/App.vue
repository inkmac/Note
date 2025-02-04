<template>
  <div>
    <h1 v-text="msg" ref="title"></h1>
    <button ref="btn" @click="showDOM">点我输出上方DOM元素</button>
    <School ref="sch"/>
  </div>
</template>

<script>
  import School from "./components/School"
  export default {
    name: 'App',
    data() {
      return {
        msg: 'Welcome to Vue'
      }
    },
    methods: {
      showDOM() {
        console.log(this.$refs.title)  // 获取真实DOM元素
        console.log(this.$refs.btn)   // 获取真实DOM元素
        console.log(this.$refs.sch)   // 获取VueComponent组件
      }
    },
    components : {School}
  }
</script>

