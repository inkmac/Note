<template>
	<div class="container">
		<Category title="food">
			
		</Category>

		<Category title="games">
			<ul>
				<li v-for="(game, i) in games" :key="i">{{ game }}</li>
			</ul>
		</Category>

		<Category title="hobbies">
			
		</Category>
	</div>
</template>

<script>
  import Category from './components/Category.vue'

  export default {
    name: 'App',
    components: {Category},
    data() {
      return {
        games: ['A', 'B', 'C']
      }
    },
  }
</script>

<style>
  .container{
		display: flex;
		justify-content: space-around;
	}
</style>