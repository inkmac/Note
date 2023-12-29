package BinarySearch;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4};

        assertEquals(0, search(arr, 0));
        assertEquals(1, search(arr, 1));
        assertEquals(2, search(arr, 2));
        assertEquals(3, search(arr, 3));
        assertEquals(4, search(arr, 4));
        System.out.println("Finished~");
    }

    //前提: 从小到大的有序数组
    public static int search(int[] arr, int target) {
        int i = 0, j = arr.length - 1;  //定义两个指针, 指向数组两端

        while (i <= j) {            //i ~ j中间有东西, 进行寻找
            int m = (i + j) >>> 1;        //取中间的索引
            if (target < arr[m]) {          //目标在左边
                j = m - 1;
            } else if (arr[m] < target) {   //目标在右边
                i = m + 1;
            } else {        //找到了
                return m;
            }

        }

        return -1;
    }
}


/*
问题1: 为什么while条件是 i<=j 而不是 i<j ?
    如果没有=, 那么i,j同时指向的元素就不会进行判断, 会漏掉某些元素

问题2: (i + j) / 2 是否有问题?
    有, 建议使用 (i + j) >>> 1, 防止最高位被当做符号位来处理

问题3: 都写成 < 有什么好处?
    可以让target的位置更清晰, 因为数组是从小到大

问题4: 如果是倒序的数组怎么修改?
    将if和else if里面的代码调换一下即可
 */