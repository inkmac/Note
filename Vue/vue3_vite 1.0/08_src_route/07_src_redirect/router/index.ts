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

          // 1. 以props形式给组件传递params参数
          // props: true

          // 2. 可以自己决定将什么数据作为props传递给组件
          props(route) {
            return route.query   // Vue3 会自动将返回值解构, 然后传递给组件
          }
        }
      ]
    },
    {
      path: '/',
      redirect: '/home'
    }
  ]
})

export default router