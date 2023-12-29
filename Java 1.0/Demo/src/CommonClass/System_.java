package CommonClass;

import java.util.Arrays;

public class System_ {
    public static void main(String[] args) {

        //arraycopy拷贝数组
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = new int[5];
        /*
          Params:
          src – the source array - 来源的数组
          srcPos – starting position in the source array - 从源数组哪一个索引开始拷贝
          dest – the destination array - 目标数组
          destPos – starting position in the destination data - 从目标数组哪一个索引开始粘贴
          length – the number of array elements to be copied - 拷贝几个数据到新数组
          */
        System.arraycopy(src, 0, dest,0,src.length - 1);
        System.out.println(Arrays.toString(dest));


        //currentTimeMillis 返回当前时间距离1970-1-1的毫秒数
        System.out.println(System.currentTimeMillis());


        //exit 退出当前程序
        System.out.println("ok1");
        System.exit(0);     //0表示一种退出状态
        System.out.println("ok1");

        //gc() 调用垃圾回收机制, finalize有讲
    }
}


