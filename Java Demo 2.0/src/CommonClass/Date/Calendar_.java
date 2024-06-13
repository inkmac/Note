package CommonClass.Date;

import java.util.Calendar;

public class Calendar_ {
    public static void main(String[] args) {

        /*
        1. Calendar构造器是private, 因此要通过getInstance()获得实例
        2. Calendar没有固定格式, 可以自定义格式
         */

        Calendar c = Calendar.getInstance();

        System.out.println("年:" + c.get(Calendar.YEAR));
        System.out.println("月:" + (c.get(Calendar.MONTH) + 1));      //需要+1 因为Calendar返回月的时候是从0开始
        System.out.println("日:" + c.get(Calendar.DAY_OF_MONTH));
        System.out.println("小时:" + c.get(Calendar.HOUR));       //想获取24小时制的可以使用 HOUR_OF_DAY
        System.out.println("分钟:" + c.get(Calendar.MINUTE));
        System.out.println("秒:" + c.get(Calendar.SECOND));
    }
}
