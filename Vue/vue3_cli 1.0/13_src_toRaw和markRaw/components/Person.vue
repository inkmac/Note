<template>
	<h2>姓名: {{ name }}</h2>
	<h2>年龄: {{ age }}</h2>
	<h2>薪资: {{ job.salary }}K</h2>
	<button @click="name += '~'">修改姓名</button>
	<button @click="age++">增长年龄</button>
	<button @click="job.salary++">涨薪</button>
	<button @click="showRawPerson">输出最原始的person</button>
</template>

<script>
import {markRaw, reactive, toRaw, toRefs} from "vue";

export default {
	name: 'Count',
	
	setup() {
		const person = reactive({
			name: '张三',
			age: 18,
			job: markRaw({   // 标记一个对象, 使其永远不会变为响应式对象
				salary: 20,
			}),
		})
		
		function showRawPerson() {
			const rawPerson = toRaw(person)  // 将reactive生成的响应式对象变为普通对象 (不能用于ref生成的响应式对象)
			console.log(rawPerson)
		}
		
		return {
			...toRefs(person),
			showRawPerson,
		}
	}
}
</script>