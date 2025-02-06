<template>
	<h1>个人信息</h1>
	<h2>姓名: {{ person.name }}</h2>
	<h2>年龄: {{ person.age }}</h2>
	<button @click="triggerHelloEvent">测试触发hello事件</button>
</template>

<script>
	import {reactive} from "vue"
	export default {
		name: 'Person',
		props: ['msg'],
		emits: ['hello'],
		setup(props, context) {
			
			console.log('props: ', props)
			console.log('context: ', context)
			
			const person = reactive({
				name: '张三',
				age: 18,
			})
			
			function triggerHelloEvent() {
				context.emit('hello', 'Hello World')
			}
			
			
			return {
				person,
				triggerHelloEvent
			}
		}
	}
</script>