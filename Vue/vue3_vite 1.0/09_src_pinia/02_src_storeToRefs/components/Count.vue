<template>
	<h2>当前求和为: {{ countStore.sum }}</h2>
	<select v-model.number="n">
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
	</select>
	<button @click="add">加</button>
	<button @click="subtract">减</button>
	<hr>
	<h2>其他数据</h2>
	<h4>所用语言: {{ language }}</h4>
	<h4>所用框架: {{ frame }}</h4>
</template>

<script setup lang="ts">
import {ref} from "vue";
import useCountStore from "@/store/count.ts";
import {storeToRefs} from "pinia";

const countStore = useCountStore()
// storeToRefs 只会对store中数据进行ref处理
const {sum, language, frame} = storeToRefs(countStore)
const n = ref(1)   // 获取用户选择的值

function add() {
	sum.value += n.value
}

function subtract() {
	sum.value -= n.value
}

</script>

<style scoped>

</style>