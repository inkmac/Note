<template>
  <div class="category">
    <h3>{{ title }}</h3>
    <slot :games="games">默认值, 当没有传递具体结构时, 我会出现</slot>
  </div>
</template>

<script>
  export default {
    name: 'Category',
    props: ['title'],
    data() {
      return {
        games: ['A', 'B', 'C']
      }
    },
  }
</script>

<style>
  .category{
		background-color: skyblue;
		width: 200px;
		height: 300px;
	}
	h3{
		text-align: center;
		background-color: orange;
	}
</style>