import {createRouter, createWebHistory} from "vue-router"
import Home from "@/pages/Home.vue"
import About from "@/pages/About.vue"
import News from "@/pages/News.vue"
import Detail from "@/pages/News/Detail.vue";

// 创建路由器
const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      name: "home",
      path: '/home',
      component: Home
    },
    {
      name: "about",
      path: '/about',
      component: About
    },
    {
      name: "news",
      path: '/news',
      component: News,
      children: [
        {
          name: "news-detail",
          path: 'detail',
          component: Detail,
        }
      ]
    }
  ]
})

export default router