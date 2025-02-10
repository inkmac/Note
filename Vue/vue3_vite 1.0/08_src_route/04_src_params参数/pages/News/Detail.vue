<template>
	<ul class="news-list">
		<li>编号: {{ route.params.id }}</li>
		<li>标题: {{ route.params.title }}</li>
		<li>内容: {{ route.params.content }}</li>
	</ul>
</template>

<script setup lang="ts">
import {useRoute} from "vue-router";

const route = useRoute()
</script>

<style scoped>

</style>