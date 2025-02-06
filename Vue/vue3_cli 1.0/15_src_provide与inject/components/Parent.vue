<template>
	<div class="child">
		<h3>我是Parent组件 (父)</h3>
		<Son/>
	</div>
</template>

<script>
	import Son from './Son.vue'
	
	export default {
		name: 'Child',
		components: {Son},
		/* setup() {
			const x = inject('car')
			console.log(x, 'Parent-----')
		} */
	}
</script>

<style>
	.child {
		background-color: skyblue;
		padding: 10px;
	}
</style>