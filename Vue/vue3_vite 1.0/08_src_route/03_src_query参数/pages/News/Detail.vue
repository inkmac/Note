<template>
	<ul class="news-list">
		<li>编号: {{ route.query.id }}</li>
		<li>标题: {{ route.query.title }}</li>
		<li>内容: {{ route.query.content }}</li>
	</ul>
</template>

<script setup lang="ts">
import {useRoute} from "vue-router";

const route = useRoute()
</script>

<style scoped>

</style>