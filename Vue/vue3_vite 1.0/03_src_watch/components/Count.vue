<template>
	<h2>当前求和为: {{ sum }}</h2>
	<button @click="sum++">点我sum+1</button>
	<hr>
	<h2>姓名: {{ person.name }}</h2>
	<h2>年龄: {{ person.age }}</h2>
	<h2>薪资: {{ person.job.salary }}K</h2>
	<button @click="person.name += '~'">修改姓名</button>
	<button @click="person.age++">增长年龄</button>
	<button @click="person.job.salary++">涨薪</button>
</template>

<script setup lang="ts">
import {reactive, ref, watch, watchEffect} from "vue"

const sum = ref(0)
const person = reactive({
	name: '张三',
	age: 18,
	job: {
		salary: 20,
	}
})

// 监视ref属性
const watchHandle = watch(sum, (newValue, oldValue) => {
	console.log('sum值变化了', newValue, oldValue)
	
	if (newValue > 10) watchHandle()   // 关闭监视器
})

// 同时监视多个ref
// watch([sum, ...], () => {})


// 监视reactive
// 1.注意: 无法正确的获取oldValue
// 2.注意: 强制开启深度监视 (deep配置无效)
watch(person, (newValue, oldValue) => {
	console.log('changed', newValue, oldValue)
})

// 监视reactive中一个属性 (此时deep配置有效, 默认为false)
// 需要写成函数形式
watch(() => person.name, (newValue, oldValue) => {
	console.log('person.name changed', newValue, oldValue)
})

// 监视reactive中多个属性
// watch([() => person.name, () => person.job], () => console.log('changed'))


// watchEffect: 函数中使用的数据变化时就会触发
watchEffect(() => {
	`${person.name}`
	console.log('watchEffect is invoked')
})

</script>