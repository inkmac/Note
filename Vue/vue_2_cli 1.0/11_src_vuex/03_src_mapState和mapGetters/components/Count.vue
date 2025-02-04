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
		<button @click="increment">+</button>
		<button @click="decrement">-</button>
		<button @click="incrementOdd">当前求和为奇数再加</button>
		<button @click="incrementWait">等一等再加</button>
	</div>
</template>

<script>
	import { mapState, mapGetters } from "vuex"

	export default {
		name: 'Count',
		data() {
			return {
				n: 1,
			}
		},
		computed: {
			// 手动去写 this.$store.state 的计算属性
			// sum() {
			// 	return this.$store.state.sum
			// },
			// school() {
			// 	return this.$store.state.school
			// },
			// student() {
			// 	return this.$store.state.subject
			// },
			
			// 使用mapState生成this.$store.state的计算属性，从state中读取数据 (对象写法)
			// ...mapState({sum: 'sum', school: 'school', subject: 'subject'}),
			
			// (数组写法)
			...mapState(['sum', 'school', 'subject']),
			

			// bigSum() {
			// 	return this.$store.getters.bigSum
			// },

			// 使用mapGetters生成this.$store.getters的计算属性，从getters中读取数据 (数组写法)
			...mapGetters(['bigSum'])
		},
		methods: {
			increment() {
				this.$store.commit('ADD', this.n)
			},
			decrement() {
				this.$store.commit('SUBTRACT', this.n)
			},
			incrementOdd() {
				this.$store.dispatch('addOdd', this.n)
			},
			incrementWait(){
				this.$store.dispatch('addWait', this.n)
			},
		},
		mounted() {
			console.log(mapState({sum: 'sum', school: 'school', subject: 'subject'}))
		},
	}
</script>

<style scoped>
	button {
		margin-left: 5px;
	}
</style>
