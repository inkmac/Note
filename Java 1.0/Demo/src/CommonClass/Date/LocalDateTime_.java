package CommonClass.Date;
import java.util.Date;
import java.time.*;
import java.time.format.DateTimeFormatter;


//LocalDate 只有日期
//LocalTime 只有时间
//LocalDateTime 日期 + 时间

public class LocalDateTime_ {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();    //获取当前时间并且创造实例
        System.out.println("now=" + ldt);

        System.out.println("年=" + ldt.getYear());
        System.out.println("月=" + ldt.getMonth());
        System.out.println("月=" + ldt.getMonthValue());     //得到月份对应的数字
        System.out.println("日=" + ldt.getDayOfMonth());
        System.out.println("时=" + ldt.getHour());
        System.out.println("分=" + ldt.getMinute());
        System.out.println("秒=" + ldt.getSecond());


        //2. 使用DateTimeFormatter 对时间进行格式化
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm:ss E");
        String format = dtf.format(ldt);
        System.out.println(format);


        //3. 提供plus和minus方法对时间进行加或减
        LocalDateTime ldtPlus = ldt.plusDays(365);
        System.out.println("365天前=" + ldtPlus);


        //4. Instant时间戳 用于转换date和localDateTime
        Instant now = Instant.now();
        System.out.println(now);
        Date date = Date.from(now);     //from: date --> instant
        Instant instant = date.toInstant();     //toInstant: instant --> date


        //5.其他方法自己去查
    }
}
