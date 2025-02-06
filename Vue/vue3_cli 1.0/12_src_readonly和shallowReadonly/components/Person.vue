<template>
	<h2>当前求和为: {{ sum }}</h2>
	<button @click="sum++">点我+1</button>
	<hr>
	<h2>姓名: {{ name }}</h2>
	<h2>年龄: {{ age }}</h2>
	<h2>薪资: {{ job.salary }}K</h2>
	<button @click="name += '~'">修改姓名</button>
	<button @click="age++">增长年龄</button>
	<button @click="job.salary++">涨薪</button>
</template>

<script>
import {reactive, readonly, ref, shallowReadonly, toRefs} from "vue";
	
	export default {
		name: 'Count',
		
		setup() {
			let sum = ref(0)
			let person = reactive({
				name: '张三',
				age: 18,
				job: {
					salary: 20,
				}
			})
			
			// readonly: 整个person对象都不允许修改
			// shallowReadonly: person对象的第一层数据不允许修改
			person = readonly(person)
			// person = shallowReadonly(person)
			sum = readonly(sum)
			// sum = shallowReadonly(sum)
			
			return {
				sum,
				...toRefs(person)
			}
		}
	}
</script>