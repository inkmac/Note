<template>
	<button @click="isShow = !isShow">切换隐藏/显示</button>
	<Person v-if="isShow"/>
</template>

<script>
	import Person from "@/components/Count.vue"
	import {ref} from "vue";
	export default {
		name: "App",
		components: { Person },
		setup() {
			const isShow = ref(true)
			return {
				isShow,
			}
		}
	}
</script>