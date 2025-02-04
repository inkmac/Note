<template>
  <div class="school">
    <h2>学校名称: {{ name }}</h2>
    <h2>学校地址: {{ address }}</h2>
  </div>
</template>

<script>
  import pubsub from 'pubsub-js'
  export default {
    name: 'School',
    data() {
      return {
        name: 'Vue',
        address: 'Vue Road'
      }
    },
    methods: {
      demo(msgName, msg) {
        console.log('接收到了hello消息', msgName, msg)
      }
    },
    mounted() {
      this.pubId = pubsub.subscribe('hello', this.demo)
    },
    beforeDestroy() {
      pubsub.unsubscribe(this.pubId)
    }
  }
</script>

<style scoped>

</style>