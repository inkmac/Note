package CommonClass.ThreeString;


/*
1.StringBuilder是char[] value的,所以可以直接更改
2.Builder比Buffer更快, 但是StringBuilder所有方法都没有实现线程安全,多线程有风险 -> 推荐单线程情况下使用
3.使用方法跟StringBuffer差不多
 */


public class StringBuilder_ {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
    }
}
