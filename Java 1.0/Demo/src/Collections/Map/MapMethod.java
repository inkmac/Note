package Collections.Map;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"all"})

/*
put()  放入k-v对
remove(k)  根据k删除v
get(k)  根据k得到v
size()  获取元素个数
isEmpty()  判断map是否为空
clear()  清空map
containsKey(k)  判断k是否存在
 */


public class MapMethod {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("No1", "BOB");
        map.put("No2", "jack");
        map.put("No2", "jeb");      //会直接覆盖
        map.put(4, "jeb");
    }
}
