<template>
  <div>
    <h2 @click="showName">学生姓名: {{name}}</h2>
    <h2>学生性别: {{gender}}</h2>
  </div>
</template>

<script>
  import { mixin } from "../mixin"

  export default {
    name: 'Student',
    data() {
      return {
        name: '张三',
        gender: '男'
      }
    },
    mixins: [mixin]
  }
</script>