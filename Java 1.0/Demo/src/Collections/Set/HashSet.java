package Collections.Set;
import java.util.HashSet;
import java.util.Set;
@SuppressWarnings({"all"})


/*  HashSet底层逻辑
1.HashSet底层就是HashMap: 数组 + 单向链表
2.添加一个元素时, 会先得到hashcode, 然后转换成index   --> hashcode 确定放在哪
3.找到存储数据的table, 看这个索引位置是否有已经存放的元素
4.如果没有,直接加入
5.如果有,调用equals()判断, 如果相同就覆盖, 如果不同就添加到链表最后  --> equals 判断要不要放或者覆盖
6.jdk8中,如果一条链表元素个数达到8, 并且table表的大小达到64, 就会进行树化(红黑树),
  如果只是链表达到树化的要求,会引发表的扩容直至树化; 反之不行
 */


/* HashSet扩容机制
1.HashSet底层是HashMap, 第一次添加时候table扩容到16
2.达到临界值的时候就会扩充两倍, 临界值是 threshold = presentCapacity * loadFactor(0.75)
3.jdk8中,如果一条链表元素个数达到8, 并且table表的大小达到64, 就会进行树化(红黑树), 否则仍采用数组扩容机制
 */

class HashSet_ {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("java");
        set.add("PHP");
        set.add("java");

        set.add(new Dog("Tom"));
        set.add(new Dog("Tom"));    //hashcode和equals比较后都不同,可以加入

        set.add(new String("hsp"));
        set.add(new String("hsp"));  //加入失败, 因为String的equals判定两个String是相同元素

        System.out.println("set=" + set);

    }
}


class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" + name  +
                '}';
    }
}



/*
1. 创建HashSet, 底层实际上是HashMap
    public HashSet() {
        map = new HashMap<>();
    }

2. 执行add(),实行HashMap的put()方法, 并且返回一个Boolean类型用于判断是否添加成功
    public boolean add(E e) {       //e: "java"
        return map.put(e, PRESENT)==null;     //PRESENT = new Object();
    }

3. put()
    public V put(K key, V value) {      //key: "java"  value: Object
        return putVal(hash(key), key, value, false, true);
    }

3.1 hash(key)       //key: "java"   value: Object
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

4. putVal()
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            if (p.hash == hash &&
               ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
 */