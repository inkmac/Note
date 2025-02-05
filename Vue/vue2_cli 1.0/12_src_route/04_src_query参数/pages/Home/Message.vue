<template>
	<div>
		<ul>
			<li v-for="message in messages" :key="message.id">
				<!-- query参数, to的字符串写法 -->
<!--					<router-link :to="`/home/message/detail?id=${message.id}&title=${message.title}`">{{ message.title }}</router-link>&nbsp;&nbsp;-->
				<!-- to的对象写法 -->
				<router-link :to="{
					path: '/home/message/detail',
					query: {
						id: message.id,
						title: message.title,
					}
				}">
					{{ message.title }}
				</router-link>
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
	}
</script>