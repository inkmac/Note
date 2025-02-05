<template>
  <div class="student">
    <h2>学生名称: {{ name }}</h2>
    <h2>学生性别: {{ gender }}</h2>
  </div>
</template>

<script>
  export default {
    name: 'Student',
    data() {
      return {
        name: '张三',
        gender: '男'
      }
    }
  }
</script>

<style scoped>

</style>