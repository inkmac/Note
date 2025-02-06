<template>
	<h2>当前鼠标坐标为: (x: {{ point.x }}, y: {{ point.y }})</h2>
</template>

<script>
	import {ref} from "vue";
	import usePoint from "@/hooks/usePoint";
	
	export default {
		name: 'Point',
		
		setup() {
			const sum = ref(0)
			const point = usePoint()
			
			return {
				sum,
				point
			}
		}
	}
</script>