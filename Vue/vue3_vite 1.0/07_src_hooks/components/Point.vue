<template>
	<h2>当前鼠标坐标为: (x: {{ point.x }}, y: {{ point.y }})</h2>
</template>

<script setup lang="ts">
import usePoint from "@/hooks/usePoint.ts"

const point = usePoint()
</script>