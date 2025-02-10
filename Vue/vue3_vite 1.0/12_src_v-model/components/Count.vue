<template>
	<input type="text" :value="modelValue" @input="updateValue">
</template>

<script setup lang="ts">

defineProps(['modelValue'])
const emit = defineEmits(['update:modelValue'])

function updateValue(event: any) {
	emit('update:modelValue', event.target.value)
}
</script>

<style scoped>

</style>