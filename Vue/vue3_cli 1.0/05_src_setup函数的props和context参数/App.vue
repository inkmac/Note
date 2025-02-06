<template>
	<Person @hello="showHelloMessage" msg="Hello World">
		<template #frame>
			<span>Vue</span>
		</template>
	</Person>
</template>

<script>
	import Person from "@/components/Person.vue"
	export default {
		name: "App",
		components: { Person },
		setup() {
		  function showHelloMessage(message) {
				alert(`触发了Hello事件, 接收到的message为: ${message}`)
			}
			
			return {
				showHelloMessage,
			}
		}
	}
</script>