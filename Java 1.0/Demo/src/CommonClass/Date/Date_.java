package CommonClass.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


class Date_ {
    public static void main(String[] args) throws ParseException {

        //创建一个标准格式的Date
        Date date = new Date();
        System.out.println("当前时间=" + date);


        // SimpleDateFormat 可以制定相应的格式 (有规定,自己去查找)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");

        //format 将日期转换为指定格式的字符串
        String format = sdf.format(date);
        System.out.println("format当前时间=" + format);

        //parse 可以将格式化的String转成相应的Date, 前提需要与创建的sdf对象格式相同
        String s = format;
        Date parse = sdf.parse(s);
        System.out.println(parse);
    }
}
