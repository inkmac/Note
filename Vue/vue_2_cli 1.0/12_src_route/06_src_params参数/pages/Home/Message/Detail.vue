<template>
	<ul>
		<li>消息编号: {{ $route.params.id }}</li>
		<li>消息编号: {{ $route.params.title }}</li>
		<li>消息编号: {{ null }}</li>
	</ul>
</template>

<script>
	export default {
		name: "Detail",
		mounted() {
			console.log(this.$route)
		}
	}
</script>