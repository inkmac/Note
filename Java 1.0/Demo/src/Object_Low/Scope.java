package Object_Low;

/* 作用域判断:
1.每一个类都是一个单独作用域, 类与类之间互不干扰
2.如果变量是在类中(但不在任何方法,代码块)声明的,那么它是一个全局变量
3.如果变量是在一个方法内部声明的,那么它是一个局部变量,只能在方法中使用,与外界互不干扰
 */


/* 作用域细节:
1.全局变量: 如果你在类中定义一个变量,但没有明确地给它赋初值,Java会给它一个默认的初始值
2.局部变量: 必须在使用之前显式地赋初始值, 否则Java编译器会报错,因为它不会自动为局部变量赋初始值
3.变量调用遵循就近原则!!
 */


class Scope {
    static int n1;

    public static void main(String[] args) {
        int m;
//        System.out.println(m);    //使用前需要显式的赋值
        System.out.println(n1);
    }
}