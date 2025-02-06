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
import {reactive, toRef, toRefs} from "vue";
	
	export default {
		name: 'Count',
		
		setup() {
			const person = reactive({
				name: '张三',
				age: 18,
				job: {
					salary: 20,
				}
			})
			
			console.log(toRef(person, 'name'))
			console.log(toRefs(person))
			
			// toRef: 将对象中的一个属性封装成一个ref对象 (与原数据关联)
			// toRefs: 将对象中的所有属性全部封装成ref对象 (与原数据关联)
			return {
				person,
				// name: toRef(person, "name"),   // toRef 写法
				// age: toRef(person, "age"),
				// salary: toRef(person.job, "salary"),
				
				...toRefs(person)
			}
		}
	}
</script>