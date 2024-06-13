package CommonClass.Array_;
import java.util.Arrays;
import java.util.Comparator;


public class sortCustom {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 4, 2};
        bubbleSort(arr, new Comparator<Integer>() {   //底层会自动调用对象的compare方法
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;    //因为return > 0时候交换, 所以return o2 - o1, 即 o2 > o1时候交换, 从而实现从大到小排序
            }
        });
        System.out.println(Arrays.toString(arr));
    }


    public static void bubbleSort(int[] arr, Comparator<Integer> c) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (c.compare(arr[j], arr[j+1]) > 0) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}



// 如果提供了Comparator接口, sort方法就会根据compare方法return的结果来排序, 实现自定义排序
// return > 0 时候交换


// 如果没有实现Comparator接口,sort方法会根据元素的自然顺序进行排序,即从小到大

