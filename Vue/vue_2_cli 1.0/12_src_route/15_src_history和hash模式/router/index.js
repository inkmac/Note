import VueRouter from "vue-router"
import About from "@/pages/About.vue";
import Home from "@/pages/Home.vue";
import News from "@/pages/Home/News.vue";
import Message from "@/pages/Home/Message.vue";
import Detail from "@/pages/Home/Message/Detail.vue";

// 创建路由器
const router = new VueRouter({
  mode: "history",
  routes: [
    {
      name: "about",
      path: "/about",
      component: About,
      meta: {
        title: "About",
      }
    },
    {
      name: "home",
      path: "/home",
      component: Home,
      meta: {
        title: "Home",
      },
      children: [
        {
          name: "home-news",
          path: "news",
          component: News,
          meta: {
            title: "News",
            requiresAdmin: true
          },
          // 独享路由守卫只有beforeEnter
          // beforeEnter: (to, from, next) => {
          //   console.log(to, from);
          //
          //   if (to.meta.requiresAdmin && localStorage.getItem("user") !== "admin") {
          //     alert("You are not an admin!")
          //     return next(false)
          //   }
          //
          //   next()
          // }
        },
        {
          name: "home-message",
          path: "message",
          component: Message,
          meta: {
            title: "Message",
            requiresAdmin: true
          },
          children: [
            {
              name: "home-message-detail",
              path: "detail/",
              component: Detail,
              meta: {
                title: "Detail",
              },
              
              // props 对象写法: 组件使用props接收
              // props: {a: 1, b: 'Hello'}
              
              // props bool写法: 若为true, 会将路由收到的所有params参数, 以props形式传递给Detail组件
              // props: true
              
              // props function写法
              props(route) {
                return {
                  id: route.query.id,
                  title: route.query.title
                };
              }
              // 补充: 解构赋值写法
              // props({query: {id, title}}) {
              //   return {id, title};
              // }
            }
          ]
        }
      ]
    },
  ]
})

// 全局前置路由守卫: 初始化时被调用, 每次路由切换之前被调用
// router.beforeEach((to, from, next) => {
//   console.log(to, from);
//
//   if (to.meta.requiresAdmin && localStorage.getItem("user") !== "admin") {
//     alert("You are not an admin!")
//     return next(false)
//   }
//
//   next()
// })

// 全局后置路由守卫: 初始化时被调用, 每次路由切换之后被调用
// router.afterEach((to, from) => {
//   console.log(to, from);
//   document.title = to.meta.title || 'vue_cli'
// })

export default router