<template>
	<h2 ref="name">姓名: 张三</h2>
	<h2 ref="age">年龄: 18</h2>
	<h2 ref="salary">薪资: 20K</h2>
	<button @click="showName">点我输出ref标签</button>
</template>

<script setup lang="ts">
import {ref} from "vue"

// 获取ref标签, 需要在组件挂载后才可以使用 (setup执行时还没有挂载完成)
const [name, age, salary] = [ref(), ref(), ref()]

function showName() {
	console.log('name', name.value)
	console.log('age', age.value)
	console.log('salary', salary.value)
}

// 对父组件暴露数据
defineExpose({name, age, salary})

</script>