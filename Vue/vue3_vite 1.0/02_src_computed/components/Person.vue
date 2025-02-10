<template>
	<h1>个人信息</h1>
	姓: <input type="text" v-model="person.firstName"> <br>
	名: <input type="text" v-model="person.lastName"> <br>
	<span>全名: {{ person.fullName }}</span> <br>
	全名: <input type="text" v-model="person.fullName"> <br>
</template>

<script setup lang="ts">
import {computed, reactive} from "vue"

const person = reactive({
	firstName: "张",
	lastName: "三",
})

// computed 简写形式
// person.fullName = computed(() => `${person.firstName}-${person.lastName}`)

person.fullName = computed({
	get() {
		return `${person.firstName}-${person.lastName}`
	},
	set(value) {
		[person.firstName, person.lastName] = value.split('-')
	}
})

</script>

<style scoped>

</style>