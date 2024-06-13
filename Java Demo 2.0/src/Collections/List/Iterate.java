package Collections.List;
import java.util.*;

//总之, 所有遍历的方法都不太适合 需要遍历的同时又有对元素进行修改
//如果不仅元素被修改了, 同时还要遍历, 就用CopyOnWriteArrayList集合


//允许你在遍历集合时进行安全的删除, 且只能够用iterator.remove(), 但该方法与CopyOnWriteArrayList冲突
//由于iterator有一个ModCount和ExpectModCount, 如果不是用iterator的方法修改集合, 就会导致ModCount != ExpectModCount, 就会抛出ConcurrentModificationException异常
class Iterator_ {
    public static void main(String[] args) {
        LinkedList<Object> list = new LinkedList<>();
        list.add("bob");
        list.add(20);
        list.add(true);

        Iterator<Object> iterator = list.iterator();    //生成一个迭代器
        //快速生成while循环  itit
        //快速查看所有快捷键  ctrl + j

        while (iterator.hasNext()) {        //判断是否还有数据
            Object obj = iterator.next();      //取出元素
            System.out.print("obj=" + obj + "\t");
        }


        //迭代完一次后iterator就指向最后一个元素了,如果希望再次遍历需要重置迭代器
        iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.print("obj=" + next + "\t");
        }

    }
}



@SuppressWarnings({"all"})
//用增强for循环: 底层仍是iterator
//快捷键: iter

class EnhancedFor {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("bob");
        list.add(20);
        list.add(true);

        for (Object obj : list) {
            System.out.print("obj=" + obj + "\t");
        }
    }
}



//第三种: 普通for循环, 慎用
class Fori {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("bob");
        list.add("20");
        list.add("true");
        list.add("jack");
        list.add("steve");

        for (int i = 0; i < list.size(); i++) {
            String element = list.get(i);
            if (element.equals("20")) {
                list.remove(i);     // 直接修改集合
                i--;        // 需要减少索引!!! 往前退一个位置, 以避免list.get(i)漏掉下一个元素
            }

            if (element.equals("true")) {
                list.remove(i);
                i--;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            String element = list.get(i);
            System.out.println(element);
        }
    }
}