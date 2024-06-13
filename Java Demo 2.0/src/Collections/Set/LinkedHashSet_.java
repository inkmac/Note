package Collections.Set;

import java.util.*;

/*
1.LinkedHashSet底层是一个LinkedHashMap: 数组 + 双向列表
2.LinkedList添加时候和HashSet规则基本一样(地址存放上无序),
  不过所有元素都在同一个双向链表中, 取出元素与放入顺序一致(取出有序)
 */


@SuppressWarnings({"all"})
class LinkedHashSet_ {
    public static void main(String[] args) {
        Set set = new LinkedHashSet();
        set.add("BOB");
        set.add(100);
        set.add(true);
        set.add(new String("BOB"));

        System.out.println("LinkedHashSet=" + set);
    }
}

