package Useless;
import java.util.*;

@SuppressWarnings({"all"})

//Collection接口有两个重要的子接口 CollectionFramework.List CollectionFramework.List.Set , 他们的子类实现都是单例集合(每次只能放一个元素)

/*
add 添加单个元素
remove 删除指定元素/索引
contains 查找元素是否存在 true/false
size 获取元素的个数
isEmpty 判断集合是否为空
clear 清空集合

addAll 将一个集合中的所有元素添加到另一个集合
containsAll 判断一个集合是否包含另一个集合的所有元素
removeAll 删除该集合中另一个集合的所有元素
 */


public class Collection_ {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("jack");
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

        ArrayList list2 = new ArrayList();
        list2.add("bob");
        list2.add(true);
        list.addAll(list2);
        System.out.println("list=" + list);

        System.out.println(list.containsAll(list2));

        list.removeAll(list2);
        System.out.println("list=" + list);

    }
}

