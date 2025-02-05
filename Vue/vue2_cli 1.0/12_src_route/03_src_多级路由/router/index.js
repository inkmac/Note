import VueRouter from "vue-router"
import About from "@/pages/About.vue";
import Home from "@/pages/Home.vue";
import News from "@/pages/Home/News.vue";
import Message from "@/pages/Home/Message.vue";

// 创建路由器
const router = new VueRouter({
  routes: [
    {
      path: "/about",
      component: About,
    },
    {
      path: "/home",
      component: Home,
      children: [
        {
          path: "news",
          component: News,
        },
        {
          path: "message",
          component: Message,
        }
      ]
    },
  ]
})

export default router