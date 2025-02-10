import {createRouter, createWebHistory} from "vue-router"
import Home from "@/pages/Home.vue"
import About from "@/pages/About.vue"
import News from "@/pages/News.vue"

// 创建路由器
const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      name: "Home",
      path: '/home',
      component: Home
    },
    {
      name: "About",
      path: '/about',
      component: About
    },
    {
      name: "News",
      path: '/news',
      component: News
    }
  ]
})

export default router