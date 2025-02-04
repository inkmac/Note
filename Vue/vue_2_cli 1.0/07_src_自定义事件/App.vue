<template>
  <div class="app">
    <h2>{{ msg }}</h2>
    <!-- 通过props实现子组件给父组件传递数据: props中传递函数 -->
    <School :getSchoolName="getSchoolName"/>
    <!-- 通过自定义事件实现子组件给父组件传递数据 (第一种写法) -->
    <!-- receive事件就挂载到Student组件上, 只能由Student组件触发 -->
    <Student @receive="getStudentName"/>

    <!-- (第二种写法) -->
    <!-- <Student ref="student"/> -->

    <!-- 对于组件, 绑定原生DOM事件, 需要加上native, 否则会被认为是自定义事件 -->
    <!-- <Student @click.native="show"/> -->
  </div>
</template>

<script>
  import School from './components/School.vue'
  import Student from './components/Student.vue'

  export default {
    name: 'App',
    components: {School, Student},
    data() {
      return {
        msg: 'Hello!'
      }
    },
    methods: {
      getSchoolName(name) {
        console.log('App receive School Name:', name) 
      },
      getStudentName(name) {
        console.log('App receive Student Name:', name) 
      }
    },

    // 第二种写法
    // mounted() {
    //   this.$refs.student.$on('receive', this.getStudentName)
    // }
  }
</script>

<style>
  .app {
    background-color: grey;
  }
</style>