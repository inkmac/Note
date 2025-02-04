import VueRouter from "vue-router"
import About from "@/pages/About.vue";
import Home from "@/pages/Home.vue";
import News from "@/pages/Home/News.vue";
import Message from "@/pages/Home/Message.vue";
import Detail from "@/pages/Home/Message/Detail.vue";

// 创建路由器
const router = new VueRouter({
  routes: [
    {
      name: "about",
      path: "/about",
      component: About,
    },
    {
      name: "home",
      path: "/home",
      component: Home,
      children: [
        {
          name: "home-news",
          path: "news",
          component: News,
        },
        {
          name: "home-message",
          path: "message",
          component: Message,
          children: [
            {
              name: "home-message-detail",
              path: "detail/:id/:title",
              component: Detail,
            }
          ]
        }
      ]
    },
  ]
})

export default router