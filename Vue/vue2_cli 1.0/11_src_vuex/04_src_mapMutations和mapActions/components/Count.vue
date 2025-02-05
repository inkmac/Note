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
			...mapState(['sum', 'school', 'subject']),
			...mapGetters(['bigSum'])
		},
		methods: {
			// increment() {
			// 	this.$store.commit('ADD', this.n)
			// },
			// decrement() {
			// 	this.$store.commit('SUBTRACT', this.n)
			// },
			// incrementOdd() {
			// 	this.$store.dispatch('addOdd', this.n)
			// },
			// incrementWait(){
			// 	this.$store.dispatch('addWait', this.n)
			// },
			
			// 使用mapMutations生成this.$store.commit的methods (对象写法)
			...mapMutations({increment: 'ADD', decrement: 'SUBTRACT'}),
			
			// 使用mapActions生成this.$store.dispatch的methods (对象写法)
			...mapActions({incrementOdd: 'addOdd', incrementWait: 'addWait'})
		},
	}
</script>

<style scoped>
	button {
		margin-left: 5px;
	}
</style>
