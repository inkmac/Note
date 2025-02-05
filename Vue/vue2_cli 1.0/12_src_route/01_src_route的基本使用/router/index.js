import VueRouter from "vue-router"
import About from "@/pages/About.vue";
import Home from "@/pages/Home.vue";

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
    }
  ]
})

export default router