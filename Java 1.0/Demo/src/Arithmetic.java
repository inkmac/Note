class Arithmetic{
    public static void main(String[] args) {

        //单个变量自增
        int i = 10;
        i++;       				//自增 相当于i = i + 1
        i--;					//自减 相当于i = i - 1
        System.out.println("i=" + i);


        //多个变量自增
        int a1 = 8;
        int b1 = a1++; 		    // i++：先进行操作 再自增
        int c1 = ++a1;		    // ++i：先自增 再进行后续的操作
        System.out.println("a1=" + a1);
        System.out.println("b1=" + b1);
        System.out.println("c1=" + c1);
        //只要有++(无论在什么地方),就自增, 所以此时a1也已经增加 a1 = a1 + 1

    }
}


class Divide {
    public static void main(String[] args) {

        //整数计算结果默认为int, 会直接舍弃小数部分, 相当于向0取整
        int a = -7/2;
        System.out.println(a);

        //解决: 带小数点或换成double类型
        System.out.println(5.0 / 9);
        System.out.println((double)5 / 9);  // 将5换成double类型, 即5.0
    }
}



class BitOperation {
    public static void main(String[] args) {
        // >> 和 << 是带符号移动, 默认最高位是符号位
        // >>> 是无符号移动, 默认结果没有符号位, 因此可以处理更大的正数(仅限正数)

        int y = 0b10110;
        int result2 = y >> 2;    //向右移动两位,会直接舍弃溢出的数,得到结果为0b101
        System.out.println(result2);

        byte a = (byte) 0b10000000;    //java计算默认都是按补码来算, 且有符号位(1为负, 0为正)
        System.out.println(a);
    }
}