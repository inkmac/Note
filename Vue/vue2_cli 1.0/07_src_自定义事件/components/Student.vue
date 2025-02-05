<template>
  <div class="student">
    <h2>学生名称: {{ name }}</h2>
    <h2>学生性别: {{ gender }}</h2>
    <button @click="sendStudentName">把学生名给App</button>
    <button @click="unbind">解绑receive事件</button>
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
    },
    methods: {
      sendStudentName() {
        // 触发Student组件实例上的receive事件
        this.$emit('receive', this.name)
      },
      unbind() {
        this.$off('receive')
        // this.$off(['receive', 'other'])  // 解绑多个事件
        // this.$off()  // 解绑所有自定义事件
      }
    }
  }
</script>

<style scoped>

</style>