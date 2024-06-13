package Object_High;

/*  解释main()入口:
1.JVM需要调用main()方法, 所以访问权限需要是public
2.JVM在调用main()的时候无需创建对象, 因此必须是static
3.方法接收的String类型的数组, 形参名为args, 执行程序的时候可传入参数
 */

/*  细节:
1.main方法可以直接访问本类static成员
2.不能直接访问本类的非静态成员, 只能创建对象后访问(原因: main方法是static方法,不能直接调用实例对象)
3.若想给main传递参数, 右上角Run -> Edit Configurations -> Program arguments
 */

class Main {
}