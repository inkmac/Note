package Enum;

/*
1.如果使用enum实现枚举, 要求将定义常量对象写在enum类的最前面
2.枚举类成员默认是final static的
3.若有多个常量, 用,间隔即可

4.enum类不可以继承其它类, 但是可以实现接口
 */

enum Season {

    SPRING("春天", "温暖"), WINTER("冬天", "寒冷");
    private String name;
    private String describe;

    private Season(String name, String describe) {
        this.name = name;
        this.describe = describe;
    }

}

class Keyword {
    public static void main(String[] args) {
        Season winter = Season.WINTER;
        //输出enum对象的名字
        System.out.println(winter.name());
        //输出enum对象的次序, 从0开始
        System.out.println(winter.ordinal());
        //values方法: 返回一个包含枚举类型所有常量的数组
        Season[] values = Season.values();
        for (int i = 0; i < values.length; i++) {
            System.out.print("Season["+i+"] = " + values[i] + "\t");
        }
        System.out.println();
        //valueOf: 输入一个字符串, 然后就会找到enum类中的相同名字的对象
        Season spring = Season.valueOf("SPRING");
        System.out.println("找到了" + spring);
        //CompareTo: 比较两个enum对象的编号, 并将结果相减
        System.out.println(Season.WINTER.compareTo(Season.SPRING));
    }
}

