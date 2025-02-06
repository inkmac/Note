<template>
	<h2>当前求和为: {{ sum }}</h2>
	<button @click="sum++">点我+1</button>
</template>

<script>
	import {onBeforeMount, onBeforeUnmount, onBeforeUpdate, onMounted, onUnmounted, onUpdated, ref} from "vue";
	
	export default {
		name: 'Count',
		
		setup() {
			console.log('---setup---')
			const sum = ref(0)
			
			// 通过组合式API的形式去使用生命周期钩子
			onBeforeMount(() => {
				console.log('---onBeforeMount---')
			})
			onMounted(() => {
				console.log('---onMounted---')
			})
			onBeforeUpdate(() => {
				console.log('---onBeforeUpdate---')
			})
			onUpdated(() => {
				console.log('---onUpdated---')
			})
			onBeforeUnmount(() => {
				console.log('---onBeforeUnmount---')
			})
			onUnmounted(() => {
				console.log('---onUnmounted---')
			})
			
			return {
				sum
			}
		}
	}
</script>