package CommonClass.Array_;
import java.util.*;

class Method {
    public static void main(String[] args) {
        Integer[] arr = {2, 3, 4, 1, 5};

        // Arrays的toString方法打印数组
        System.out.println(Arrays.toString(arr));

        // 用sort方法进行排序, 默认从小到大
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        //定制排序, 使用Comparator接口, 并且用匿名内部类实现compare方法
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}


class Method02 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};

        //binarySearch要求数组是有序的, 如果是无序的不能使用
        int index = Arrays.binarySearch(arr, 5);

        //copyOf数组拷贝, 从索引0开始拷贝newLength个元素到新的数组; 一般用于复制整个数组
        int[] arr02 = Arrays.copyOf(arr, arr.length + 5);

        //fill会将全部数组元素填充为同一个元素
        Arrays.fill(arr, -1);

        //equals 比较两个数组元素内容是否一样
        boolean equals = Arrays.equals(arr, arr02);

        //asList 可以将一组值转换成list
        List<Integer> list = Arrays.asList(2, 3, 4, 5, 6);   // 慎用, 有坑
    }
}