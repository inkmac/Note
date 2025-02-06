<template>
	<h1>我是App组件</h1>
	<h2>姓名: {{ person.name }}</h2>
	<h2>年龄: {{ person.age }}</h2>
	<h3>工作种类: {{ person.job.type }}</h3>
	<h3>工作薪水: {{ person.job.salary }}</h3>
	<button @click="changeInfo">修改人的信息</button>
</template>

<script>
import {reactive, ref} from "vue"

export default {
	name: 'App',
	setup() {
		const person = reactive({
			name: '张三',
			age: 18,
			job: {
				type: '前端工程师',
				salary: '30K',
			}
		})
		
		function changeInfo() {
			person.name = '李四'
			person.age = 48
			person.job = {
				type: '后端工程师',
				salary: '40K',
			}
		}
		
		return {
			person,
			changeInfo
		}
	}
}
</script>