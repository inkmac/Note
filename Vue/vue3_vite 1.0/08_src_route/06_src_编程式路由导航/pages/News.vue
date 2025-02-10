<template>
	<h2>我是News组件</h2>
	<!-- 导航区 -->
	<ul>
		<li v-for="news in newsList">
			<button @click="pushShow(news)">push查看</button>
			<button @click="replaceShow(news)">replace查看</button>
			<RouterLink :to="{
				name: 'news-detail',
				query: {
					id: news.id,
					title: news.title,
					content: news.content
				}
			}">{{ news.title }}</RouterLink>
		</li>
	</ul>
	<!-- 展示区 -->
	<div class="news-content">
		<RouterView></RouterView>
	</div>
</template>

<script setup lang="ts">
	import {reactive} from "vue";
	import {useRouter} from "vue-router";
	
	const newsList = reactive([
		{id: '1', title: 'News1', content: 'Content 1'},
		{id: '2', title: 'News2', content: 'Content 2'},
		{id: '3', title: 'News3', content: 'Content 3'},
	])
	
	const router = useRouter()
	
	function pushShow(news: any) {
		router.push({
			name: 'news-detail',
			query: {
				id: news.id,
				title: news.title,
			}
		})
	}
	
	function replaceShow(news: any) {
		router.replace({
			name: 'news-detail',
			query: {
				id: news.id,
				title: news.title,
			}
		})
	}
</script>

<style scoped>

</style>