<template>
	<ul>
		<li>消息编号: {{ $route.query.id }}</li>
		<li>消息编号: {{ $route.query.title }}</li>
		<li>消息编号: {{ null }}</li>
	</ul>
</template>

<script>
	export default {
		name: "Detail",
	}
</script>