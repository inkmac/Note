<template>
	<h2 ref="name">姓名: {{ name }}</h2>
	<h2 ref="age">年龄: {{ age }}</h2>
	<h2 ref="salary">薪资: {{ salary }}K</h2>
</template>

<script setup lang="ts">

// 接收数据
// defineProps(["name", "age", "salary"])

// 接收数据并限制类型
// defineProps<{ name: string, age: number, salary: number }>()

// 接收数据并限制类型 + 限制必要性 + 指定默认值
withDefaults(
	defineProps<{
		name: string,
		age: number,
		salary?: number,  // 限制必要性
	}>(),
	{
		name: "李四",
		age: 48,
		salary: 30   // 指定默认值
	}
);

</script>