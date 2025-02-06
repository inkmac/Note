<template>
	<input type="text" v-model="keyWord">
	<h3>{{ keyWord }}</h3>
</template>

<script>
import {customRef, ref} from "vue";
	
	export default {
		name: "App",
		setup() {
			// const keyWord = ref('hello') // 使用Vue提供的ref
			
			// 自定义ref
			function myRef(value, delay) {
				console.log(value)
				let timer
				return customRef((track, trigger) => ({
					get() {
						console.log(`读取myRef中的数据了, 读取的数据为: ${value}`)
						track()   // 通知Vue追踪value的变化
						return value
					},
					set(newValue) {
						console.log(`修改了myRef中的数据, 改为了: ${newValue}`)
						clearTimeout(timer)
						timer = setTimeout(() => {
							value = newValue
							trigger()  // 通知Vue重新解析模板
						}, delay)
					}
				}))
			}
			
			const keyWord = myRef('hello', 500)
			return {
				keyWord,
			}
		}
	}
</script>