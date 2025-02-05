<template>
	<div class="container">
		<Category title="games">
			<template scope="data">
				<ol>
					<li v-for="(game, i) in data.games" :key="i">{{ game }}</li>
				</ol>
			</template>
		</Category>

		<Category title="games">
			<template scope="data">
				<ul>
					<li v-for="(game, i) in data.games" :key="i">{{ game }}</li>
				</ul>
			</template>
		</Category>

		<Category title="games">
			<template slot-scope="{games}">
				<h4 v-for="(game, i) in games" :key="i">{{ game }}</h4>
			</template>
		</Category>
	</div>
</template>

<script>
  import Category from './components/Category.vue'

  export default {
    name: 'App',
    components: {Category},
  }
</script>

<style>
  .container{
		display: flex;
		justify-content: space-around;
	}
</style>