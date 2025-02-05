<template>
	<div>
		<h1>当前求和为: {{ sum }}</h1>
		<h3>当前求和放大10倍为: {{ bigSum }}</h3>
		<h3>School: {{ school }}</h3>
		<h3>Subject: {{ subject }}</h3>
		<select v-model.number="n">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
		</select>
		<button @click="increment(n)">+</button>
		<button @click="decrement(n)">-</button>
		<button @click="incrementOdd(n)">当前求和为奇数再加</button>
		<button @click="incrementWait(n)">等一等再加</button>
	</div>
</template>

<script>
	import { mapState, mapGetters, mapMutations, mapActions } from "vuex"

	export default {
		name: 'Count',
		data() {
			return {
				n: 1,
			}
		},
		computed: {
			...mapState('count', ['sum', 'school', 'subject']),
      ...mapGetters('count', ['bigSum'])
		},
		methods: {
			...mapMutations('count', {increment: 'ADD', decrement: 'SUBTRACT'}),
			...mapActions('count', {incrementOdd: 'addOdd', incrementWait: 'addWait'})
		},
		mounted() {
			console.log(this, this.$store)
		},
	}
</script>

<style scoped>
	button {
		margin-left: 5px;
	}
</style>
