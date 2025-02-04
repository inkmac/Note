<template>
  <div>
    <h2 @click="showName">学校姓名: {{name}}</h2>
    <h2>学校地址: {{address}}</h2>
  </div>
</template>

<script>
  import { mixin } from "../mixin"

  export default {
    name: 'School',
    data() {
      return {
        name: 'Vue',
        address: 'Vue Road'
      }
    },
    mixins: [mixin]
  }
</script>