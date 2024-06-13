package Collections.Map;
import java.util.*;
@SuppressWarnings({"all"})

/*
HashMap底层结构是数组+单向链表, 并用key-value的方式存储或查找
添加时候hash和equals的是k-v的key, 添加的是value
线程不安全
 */


public class HashMap_ {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("No1", "BOB");
        map.put("No2", "Steve");
        map.put("No3", "jack");
        map.put("No3", "jeb");      //一个key只能对应一个value, 否则就覆盖
        map.put(4, "jeb");

        System.out.println("map=" + map);

        System.out.println(map.get("No1"));
        System.out.println(map.get(4));

    }
}
