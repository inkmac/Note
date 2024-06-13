package Collections.Map;
import java.util.*;
@SuppressWarnings({"all"})

// ①增强for ②iterator

/*  几个常用方法
map.keySet()  取出所有的key  --> map.get(key)
map.values()  取出所有的value
map.entrySet()  取出所有的k-v对 --> 向下转型成Map.Entry, 调用getKey和getValue方法
 */


class iterate_keySet {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("No1", "BOB");
        map.put("No2", "jack");
        map.put("No2", "jeb");      //会直接覆盖
        map.put(3, "jeb");


        //第一组: 用keySet方法获取所有的key
        //enhanced_for循环
        for (Object key : map.keySet()) {
            System.out.println(key + "=" + map.get(key));
        }
        System.out.println("=========================");


        //迭代器
        Set keySet = map.keySet();
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println(key + "=" + map.get(key));
        }


    }
}



@SuppressWarnings({"all"})
class iterate_entrySet {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("No1", "BOB");
        map.put("No2", "jack");
        map.put("No2", "jeb");      //会直接覆盖
        map.put(3, "jeb");


        //第二组: 通过enterSet获取k-v对 (不推荐!!!!!)
        //enhanced_for
        Set set = map.entrySet();
        for (Object obj : set) {
            Map.Entry entry = (Map.Entry) obj;      //向下转型,调用Map.Entry的getKey和getValue方法
            System.out.println(entry + "\t" + entry.getKey() + "\t" + entry.getValue());
        }
        System.out.println("===========================");


        //迭代器
        Set set02 = map.entrySet();
        Iterator iterator = set02.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Map.Entry obj = (Map.Entry) next;
            System.out.println(obj + "\t" + obj.getKey() + "\t" + obj.getValue());
        }

    }
}
