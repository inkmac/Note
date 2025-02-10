<template>
	<h2>App组件内容</h2>
	<h4>sum: {{ sum }}</h4>
	<hr>
	<Count/>
</template>

<script setup lang="ts">
import Count from "@/components/Count.vue";
import {onUnmounted, ref} from "vue";
import emitter from "@/utils/emitter.ts";

const sum = ref(0)

emitter.on('send-sum', (value: number) => {
	console.log('send-sum', value)
	sum.value = value
})

// 在组件卸载时解绑事件
onUnmounted(() => {
	emitter.off('send-sum')
})
</script>

<style scoped>

</style>