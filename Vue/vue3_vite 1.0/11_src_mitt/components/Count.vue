<template>
	<h2>当前求和为: {{ sum }}</h2>
	<select v-model.number="n">
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
	</select>
	<button @click="add">加</button>
	<button @click="subtract">减</button>
	<button @click="emitter.emit('send-sum', sum)">点击将Count中的sum值传递给App</button>
</template>

<script setup lang="ts">
import {ref} from "vue";
import emitter from "@/utils/emitter.ts";

const sum = ref(0)
const n = ref(1)

function add() {
	sum.value += n.value
}

function subtract() {
	sum.value -= n.value
}
</script>

<style scoped>

</style>