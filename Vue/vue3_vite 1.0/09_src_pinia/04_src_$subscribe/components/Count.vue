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

countStore.$subscribe((mutation, state) => {
	console.log('countStore中的数据发生变化了')
	console.log('mutation', mutation)
	console.log('state', state)
})

function add() {
	countStore.sum += n.value
}

function subtract() {
	countStore.sum -= n.value
}

</script>

<style scoped>

</style>