package Object_Low;

//Overload: 成员方法名称相同, 但形参不同的方法, 称为重载
/*  细节:
1.方法名必须相同
2.形参列表必须不同(名称不算)
3.返回类型不算
 */
class Overload {
    public void calc(int a) {
        System.out.println(a);
    }

    public void calc(int a, int b) {
        System.out.println(a + b);
    }
}



//可变参数: 不知道传入的参数有几个的时候可以使用
class VarPara {
    /*
    老韩解读 + 细节:
    1. int... 表示接收的的是可变参数, 为int类型, 即可接收多个int[0,多], 也可为int型数组
    2. 可变参数本质是数组, 即nums可以当做数组来使用
    3. 可变参数可以与普通类型参数一起放在形参列表, 但必须放在最后
    4. 一个形参列表最多有一个可变参数
     */
    public int sumUpgrade(int... nums) {
        System.out.println("接收参数个数=" + nums.length);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        VarPara m = new VarPara();
        int res = m.sumUpgrade(1, 2, 4, 3);
        System.out.println("result=" + res);
    }
}



