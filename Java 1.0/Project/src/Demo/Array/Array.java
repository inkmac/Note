package Demo.Array;

//定义一个数组, 并从中找到最大的数
class Array01 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 19, 43, 5};
        int max = arr[0];                            //先假设第一个数最大, 并赋给max
        for (int j : arr) {
            if (j > max) {                      //当数组中的元素大于max时, 把max换为当前元素
                max = j;
            }
        }
        System.out.println("max=" + max);
    }
}


//打印杨辉三角
class Array02 {
    public static void main(String[] args) {
        int[][] arr = new int[5][];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1];
            for (int j = 0; j < arr[i].length; j++) {
                if (j == 0 || j == arr[i].length - 1) {
                    arr[i][j] = 1;
                }else {
                    arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
                }
            }
        }

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}

