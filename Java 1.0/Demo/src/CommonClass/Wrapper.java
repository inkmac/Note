package CommonClass;

/*  Wrapper类的特性(Integer举例):
1.Integer a = 10; 先从常量池看是否有 10 ,如果有,直接指向; 如果没有就创建一个,并且指向
2.new Integer() 不管有没有, 都会直接开新空间创建一个新的Integer对象,并且指向

3.Integer对象其中的值不能修改, 所以Integer a = 10;  a = 20;
  本质上不是 10 被改变了, 而是创建一个对象 20 并且指向, 10 和 20 都在
  所以说每次修改都会重开空间
 */


class Wrapper {
    public static void main(String[] args) {
        int n1 = 10;

        //自动装箱
        Integer integer = n1;
        //自动拆箱
        int n2 = integer;
    }
}



class WrapperToString {
    public static void main(String[] args) {
        // Integer 和 String 相互转换
        Integer i = 10;
        String str1 = i + "";
        String str2 = i.toString();
        String str3 = String.valueOf(i);

        String str = "123";
        Integer i1 = Integer.parseInt(str);
    }
}


class WrapperMethod {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);  //返回Integer类型的最大值和最小值
        System.out.println(Integer.MIN_VALUE);

        System.out.println(Character.isDigit('a'));         //判断是否为数字
        System.out.println(Character.isLetter('a'));        //判断是否为字母
        System.out.println(Character.isUpperCase('a'));     //判断是否为大写
        System.out.println(Character.isLowerCase('a'));     //判断是否为小写
        System.out.println(Character.isWhitespace('a'));    //判断是否为空格

        System.out.println(Character.toUpperCase('a'));     //转化为大写
        System.out.println(Character.toLowerCase('a'));     //转化为小写
    }
}


@SuppressWarnings({"ALL"})
class IntegerExercise {
    public static void main(String[] args) {
        Integer i1 = new Integer(127);
        Integer i2 = new Integer(127);
        System.out.println(i1 == i2);   //F  只要是new,就开辟新空间,地址不一样

        Integer i3 = 127;
        Integer i4 = 127;
        System.out.println(i3 == i4);   //T  Integer在 -128~127 之间不会创建对象

        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println(i5 == i6);   //F  Integer在 -128~127 之外会创建对象

        Integer i7 = 127;
        Integer i8 = new Integer(127);
        System.out.println(i7 == i8);   //F  因为new,所以地址不一样

        Integer i9 = 127;
        int i10 = 127;
        System.out.println(i9 == i10);  //T  有一个为基本数据类型,就比较的值


    }
}




