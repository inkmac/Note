import java.util.Arrays;
@SuppressWarnings({"ALL"})

/*  赋值细节:
1.Java中的赋值(=)是按值传递的
2.基本数据类型: 因为是直接赋值, 两个变量互不影响
3.引用数据类型(对象): 因为实际赋的是地址, 只有引用指向的内容被改变(eg: arr[1]), 才会互相影响
                   如果只是单纯地修改引用, 改变的只是该引用的指向, 原来指向的内容并未改变, 不会互相影响
 */

public class DataType {
    public static void main(String[] args) {
        String a = "Jeb";   //a实际上就是一个地址, 这个地址里面是"Jeb"

        String b = a;       //a的地址赋给b
        b = "BOB";          //相当于b改变了指向, 指向了"BOB", 而a仍指向"Jeb"
        System.out.println(b);

        int[] arr = {1, 2, 3};
        int[] arr1 = arr;   //arr1指向了arr
        arr1[0] = 10;       //arr1[0]就已经是一个值了, 可以直接修改成10
        System.out.println(Arrays.toString(arr));
    }
}

