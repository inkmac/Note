<template>
  <div class="school">
    <h2>学校名称: {{ name }}</h2>
    <h2>学校地址: {{ address }}</h2>
  </div>
</template>

<script>
  export default {
    name: 'School',
    data() {
      return {
        name: 'Vue',
        address: 'Vue Road'
      }
    },
    methods: {
      receiveData(data) {
        console.log('我是School组件, 收到了数据', data)
      }
    },
    mounted() {
      this.$bus.$on('hello', this.receiveData)
    },
    beforeDestroy() {
      this.$bus.$off('hello')
    }
  }
</script>

<style scoped>

</style>