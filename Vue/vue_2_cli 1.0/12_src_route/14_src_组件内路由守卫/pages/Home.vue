<template>
	<div>
		<h2>我是Home的内容</h2>
		<div>
			<ul class="nav nav-tabs">
				<li>
					<router-link class="list-group-item" active-class="active" :to="{name: 'home-news'}">News</router-link>
				</li>
				<li>
					<router-link class="list-group-item" active-class="active" :to="{name: 'home-message'}">Message</router-link>
				</li>
			</ul>
			<!-- 只缓存News组件 include中的为组件名 -->
			<keep-alive include="News">
				<router-view></router-view>
			</keep-alive>
		</div>
	</div>
</template>

<script>
  export default {
    name: 'Home',
  }
</script>

<style>

</style>