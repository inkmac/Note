package Keyword;

/*
1.输出对象时会默认调用 toString()
2.默认返回: 全类名 + @ + hashcode的16进制
3.子类往往会重写toString(), IDEA自带重写toString, 用于返回对象属性信息
4.直接输出一个对象时,toString方法会被默认调用
 */

class Monster {
    private final String name;
    private final int age;

    public Monster(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class toString {
    public static void main(String[] args) {
        Monster bob = new Monster("Bob", 10);
        System.out.println(bob);            //输出对象引用会默认调用toString方法
        System.out.println(bob.toString());
    }
}