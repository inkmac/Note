package CommonClass;

public class Math_ {
    public static void main(String[] args) {
        // abs 绝对值
        int abs = Math.abs(-10);
        System.out.println(abs);

        // pow 求幂
        double pow = Math.pow(2, 4);    //2的4次方
        System.out.println(pow);

        // ceil 向上取整
        double ceil = Math.ceil(4.5);
        System.out.println(ceil);

        // floor 向下取整
        double floor = Math.floor(4.5);
        System.out.println(floor);

        // round 四舍五入
        long round = Math.round(5.71);
        System.out.println(round);

        // sqrt 开方
        double sqrt = Math.sqrt(9);
        System.out.println(sqrt);

        // random 返回一个随机数, 范围[0,1)
        double random = Math.random();
        System.out.println(random);         //可以用java.util.Random生成更高质量的随机数序列

        // max, min 返回两个数的最大值和最小值
        int min = Math.min(10, 90);
        int max = Math.max(10, 90);
        System.out.println(min + " " + max);

    }
}