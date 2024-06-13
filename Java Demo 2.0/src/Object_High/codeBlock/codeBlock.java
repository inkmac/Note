package Object_High.codeBlock;

//代码块:
/*  基本语法:
1. (static) {代码}
2. 使用static叫静态代码块, 没有static的叫普通代码块, 写在class中
3. 使用: 如果多个构造器都有重复的语句, 可抽取到普通代码块中, 代码块是对构造器的补充
 */


/*  调用细节:
1.static代码块作用是对类进行初始化, 且随着类的加载而执行, 并且只会执行一次
  如果只是普通代码块,只有创建对象才会执行, 并且每创建一个对象, 都会执行
2.①static代码块最优先 ②父类先于子类 ③普通代码块/属性/方法先于构造器; 相同类型的情况下,谁在前,谁优先执行
 */


/* 类什么时候被加载?   答:class或其内部被调用的时候
① 创建对象实例时(new)
② 创建子类对象实例时, 父类也会被加载, 而且父类先被加载
③ 使用类的静态成员时
 */

/*
static代码块就是类加载时候初始化用
普通代码块就是对象加载时候初始化用
 */

class AA {
    static {
        System.out.println("AA Static codeBlock executed~");
    }
    {
        System.out.println("AA Normal codeBlock executed~");
    }
}

class BB extends AA {
    static int n1 = 1;
    static {
        System.out.println("BB Static codeBlock executed~");
    }
    {
        System.out.println("BB Normal codeBlock executed~");
    }
}

class blockDetail01 {
    public static void main(String[] args) {
        new BB();
        System.out.println("=================");
        new BB();
    }
}

/* ================================================================= */

class Parent {
    static {
        System.out.println("父类static代码块");
    }

    {
        System.out.println("父类普通代码块");
    }

    public Parent() {
//        (1)隐藏一个普通代码块{} 和对象属性/方法
        System.out.println("父类构造方法");
    }
}

class Son extends Parent {
    static {
        System.out.println("子类static代码块");
    }

    {
        System.out.println("子类普通代码块");
    }

    public Son() {
//        (1)隐藏一个super()
//        (2)隐藏一个普通代码块{} 和对象属性/方法
        System.out.println("子类构造方法");
    }
}

class blockDetail02 {
    public static void main(String[] args) {
        new Son();
    }
}


