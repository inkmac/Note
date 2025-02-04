<template>
	<div>
		<ul>
			<li v-for="message in messages" :key="message.id">
				<router-link :to="{
					name: 'home-message-detail',
					query: {
						id: message.id,
						title: message.title,
					}
				}">
					{{ message.title }}
				</router-link>
				<button @click="pushShow(message)">push查看</button>
				<button @click="replaceShow(message)">replace查看</button>
			</li>
		</ul>
		<hr>
		<router-view></router-view>
	</div>
</template>

<script>
	export default {
		name: "Message",
		data() {
			return {
				messages: [
					{id: '001', title: 'message001', content: 'message001'},
					{id: '002', title: 'message002', content: 'message002'},
					{id: '003', title: 'message003', content: 'message003'},
				]
			}
		},
		methods: {
			pushShow(message) {
				this.$router.push({
					name: 'home-message-detail',
					query: {
						id: message.id,
						title: message.title,
					}
				})
			},
			replaceShow(message) {
				this.$router.replace({
					name: 'home-message-detail',
					query: {
						id: message.id,
						title: message.title,
					}
				})
			}
		},
		beforeDestroy() {
			console.log('Message beforeDestroy');
		}
	}
</script>