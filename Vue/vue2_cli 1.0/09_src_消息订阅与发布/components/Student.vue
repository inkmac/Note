<template>
  <div class="student">
    <h2>学生名称: {{ name }}</h2>
    <h2>学生性别: {{ gender }}</h2>
    <button @click="sendStudentName">把学生名发送给School组件</button>
  </div>
</template>

<script>
  import pubsub from 'pubsub-js'
  export default {
    name: 'Student',
    data() {
      return {
        name: '张三',
        gender: '男'
      }
    },
    methods: {
      sendStudentName() {
        pubsub.publish('hello', 123)
      }
    }
  }
</script>

<style scoped>

</style>