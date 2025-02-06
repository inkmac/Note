<template>
	<h4>{{ person }}</h4>
	<h2>姓名: {{ name }}</h2>
	<h2>年龄: {{ age }}</h2>
	<h2>薪资: {{ job.salary }}K</h2>
	<button @click="name += '~'">修改姓名</button>
	<button @click="age++">增长年龄</button>
	<button @click="job.salary++">涨薪</button>
</template>

<script>
	import {shallowReactive, toRefs} from "vue";
	
	export default {
		name: 'Count',
		
		setup() {
			// shallowReactive: 只有第一层数据的响应式
			const person = shallowReactive({
				name: '张三',
				age: 18,
				job: {
					salary: 20,
				}
			})
			
			// shallowRef: 只能处理基本数据类型的响应式, 或者对对象本身进行响应式处理(不进行对象内部属性的响应式处理)

			return {
				person,
				...toRefs(person)
			}
		}
	}
</script>