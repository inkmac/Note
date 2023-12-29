package Object_High.SingleMode;

//单例模式饿汉式: 直接创建对象
/*  如何创建:
1.构造器私有化
2.类的内部创建私有static对象, 并赋给对象引用
3.向外界提供一个公共static方法
 */

class SingleTon {
    public static void main(String[] args) {
        girlfriend a1 = girlfriend.getInstance();
        System.out.println(a1);

//        girlfriend a2 = girlfriend.getInstance();
//        System.out.println(a2);
    }
}

class girlfriend {
    private String name;

    private girlfriend(String name) {
        System.out.println("构造器被调用");
        this.name = name;
    }

    private static girlfriend gf = new girlfriend("小红");

    public static girlfriend getInstance() {
        return gf;
    }

    @Override
    public String toString() {
        return "girlfriend{" +
                "name='" + name + '\'' +
                '}';
    }
}