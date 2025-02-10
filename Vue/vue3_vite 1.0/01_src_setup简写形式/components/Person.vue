<template>
	<h2>姓名: {{ name }}</h2>
	<h2>年龄: {{ age }}</h2>
	<h2>薪资: {{ job.salary }}K</h2>
</template>

<script setup lang="ts">
import {reactive, ref} from "vue"

// setup 会自动将所有的变量自动导出

const name = ref('张三')
const age = ref(18)
const job = reactive({
	name: '前端工程师',
	salary: 20
})
</script>

<style scoped>

</style>