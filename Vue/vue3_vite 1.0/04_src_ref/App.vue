<template>
	<button @click="showCount">点我输出Count组件标签</button>
	<Count ref="count"/>
</template>

<script setup lang="ts">
import Count from "@/components/Count.vue"
import {ref} from "vue"

const count = ref()

function showCount() {
	console.log('Count', count.value)  // 需要子组件暴露数据, 否则无法获取子组件数据
}

</script>

<style scoped>

</style>