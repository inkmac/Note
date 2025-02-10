import { createApp } from 'vue'
import App from './App.vue'
import {createPinia} from "pinia";

const app = createApp(App)

// 创建pinia
const pinia = createPinia()
// 使用pinia
app.use(pinia)

app.mount('#app')