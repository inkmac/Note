<template>
  <div class="demo">
    <h2>学校姓名: {{name}}</h2>
    <h2>学校地址: {{address}}</h2>
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
    }
  }
</script>

<style scoped>
  .demo {
    background-color: orange;
  }
</style>