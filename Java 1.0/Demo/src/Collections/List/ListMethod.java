package Collections.List;
import java.util.*;

/*  List方法:
add 添加单个元素, 可以指定索引位置
remove 删除指定元素/索引
set 修改索引处元素
contains 判断元素是否存在 true/false
indexOf lastIndexOf 查取元素的索引
get 获取索引处的元素
size 获取实际元素的个数

isEmpty 判断集合是否为空
clear 清空集合
subList 截取某段集合

addAll 将一个集合中的所有元素添加到另一个集合
containsAll 判断一个集合是否包含另一个集合的所有元素
removeAll 删除该集合中另一个集合的所有元素

toArray()  转换为数组
sort()  排序
 */


class List_ {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();

        list.add(0, "jack");
        list.add(10);   //有个自动装箱的过程
        list.add(true);
        System.out.println("list=" + list);

        list.remove(0);
        list.remove(Integer.valueOf(10));
        System.out.println("list=" + list);

        System.out.println(list.contains("jack"));

        System.out.println(list.size());

        System.out.println(list.isEmpty());

        list.clear();
        System.out.println("list=" + list);

        ArrayList<Object> list2 = new ArrayList<>();
        list2.add("bob");
        list2.add(true);
        list.addAll(list2);
        System.out.println("list=" + list);

        System.out.println(list.containsAll(list2));

        list.removeAll(list2);
        System.out.println("list=" + list);

        Object o = list.get(1);
        System.out.println(o);
    }
}



@SuppressWarnings({"all"})
class ListMore_ {
    public static void main(String[] args) {
        List list = new ArrayList(10);      //可以指定初始容量
        list.add("Tom");
        list.add("Jerry");
        System.out.println("list=" + list);     // 直接输出引用类型会默认调用toString, 而集合重写了该方法

        list.add(1,"POT");
        System.out.println("list=" + list);

        List list2 = new ArrayList();
        list2.add("老韩");
        list2.add("老张");
        list.addAll(1, list2);
        System.out.println("list=" + list);

        System.out.println(list.indexOf("Tom"));      //第一次出现的位置
        System.out.println(list.lastIndexOf("Tom"));       //最后一次出现的位置

        list.set(1, "BOB");
        System.out.println("list=" + list);

        //截取一段List, 左闭右开
        List returnlist = list.subList(0, 2);
        System.out.println("returnlist" + returnlist);


        Vector vector = new Vector(100,20);
    }
}
