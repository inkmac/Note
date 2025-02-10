<template>
	<h2>App组件内容</h2>
	<h4>sum: {{ sum }}</h4>
	<hr>
	<Count @receive="getSum"/>
</template>

<script setup lang="ts">
import Count from "@/components/Count.vue";
import {ref} from "vue";

const sum = ref(0)

function getSum(value: number) {
	sum.value = value
}
</script>

<style scoped>

</style>