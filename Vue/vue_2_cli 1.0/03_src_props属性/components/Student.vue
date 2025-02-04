<template>
  <div>
    <h1>{{msg}}</h1>
    <h2>学生姓名: {{name}}</h2>
    <h2>学生性别: {{gender}}</h2>
    <h2>学生年龄: {{age}}</h2>
  </div>
</template>

<script>
  export default {
    name: 'Student',
    data() {
      return {
        msg: '我是一个学生',
      }
    },
    props: ['name', 'gender', 'age']  // 简单接收
    
    // 接收同时对数据类型进行限制
    // props: {   
    //   name: String,
    //   gender: String,
    //   age: Number,
    // }

    // 接收同时对数据类型进行限制 + 默认值指定 + 必要性的限制
    // props: {
    //   name: {
    //     type: String,  // 类型为String
    //     required: true  // 必须传入name值 
    //   },
    //   gender: {
    //     type: String,
    //     required: true
    //   },
    //   age: {
    //     type: Number,
    //     default: 100  // 默认值
    //   }
    // }
  }
</script>