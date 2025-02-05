<template>
	<ul>
		<li>news001 <input type="text"></li>
		<li>news002 <input type="text"></li>
		<li>news003 <input type="text"></li>
	</ul>
</template>

<script>
	export default {
		name: "News",
		
		// 通过路由规则, 进入该组件时被调用
		beforeRouteEnter(to, from, next) {
			console.log('News - beforeRouteEnter', to, from)
			
			if (to.meta.requiresAdmin && localStorage.getItem("user") !== "admin") {
				alert("You are not an admin!")
				return next(false)
			}

			next()
		},
		
		// 通过路由规则, 离开该组件时被调用
		beforeRouteLeave(to, from, next) {
			console.log('About beforeRouteLeave', to, from)
			next()
		}
	}
</script>