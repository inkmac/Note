<template>
	<h2>当前求和为: {{ countStore.sum }}</h2>
	<select v-model.number="n">
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
	</select>
	<button @click="add">加</button>
	<button @click="subtract">减</button>
</template>

<script setup lang="ts">
import {ref} from "vue";
import useCountStore from "@/store/count.ts";

const countStore = useCountStore()
const n = ref(1)   // 获取用户选择的值

function add() {
	// 第一种方式
	countStore.sum += n.value
	
	// 第二种方式(修改多个数据), 部分更新
	// countStore.$patch({
	// 	sum: countStore.sum + n.value,
	// })
	
	// 第三种方式
	// countStore.increment(n.value)
}

function subtract() {
	countStore.sum -= n.value
}

</script>

<style scoped>

</style>