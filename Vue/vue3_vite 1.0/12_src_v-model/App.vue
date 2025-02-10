<template>
	<h2>App组件内容</h2>
	<h4>sum: {{ sum }}</h4>
	<hr>
	<Count v-model="sum"/>
	<!-- 相当于 -->
<!--	<Count :modelValue="sum" @update:modelValue="(value) => sum = value"/>-->
</template>

<script setup lang="ts">
import Count from "@/components/Count.vue";
import {ref} from "vue";

const sum = ref(0)

</script>

<style scoped>

</style>