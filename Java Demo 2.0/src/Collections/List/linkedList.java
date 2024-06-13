package Collections.List;
import java.util.LinkedList;

// LinkedList 方法基本和Arraylist相同
// 多了addFirst, addLast; removeFirst, removeLast方法
class linkedList {
    public static void main(String[] args) {
        LinkedList<Object> list = new LinkedList<>();
        list.add(100);   //加到最后一个元素
        list.add(200);
        list.addLast(200);
        list.add("bob");
        System.out.println("LinkedList=" + list);

        list.remove();
        System.out.println("LinkedList=" + list);

        list.set(1,400);
        System.out.println("LinkedList=" + list);

    }
}


/* LinkedList的add()底层源码

1. 执行add(),返回一个boolean类型用于判断是否添加成功
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

2.linkLast()方法
    void linkLast(E e) {
            final Node<E> l = last;
            final Node<E> newNode = new Node<>(l, e, null);
            last = newNode;
            if (l == null)
                first = newNode;
            else
                l.next = newNode;
            size++;
            modCount++;
        }

    先记录一下原来最后一个元素的编号l, 然后再创建新的元素并且与前后元素串起来,然后赋给last,成为新的最后一个元素
    然后到了if判断: 如果l不存在(add前是个空list),就将这个新元素赋给first
                  如果l存在(add前不为空), 就将这个新元素赋给l.next, 这样就串起来
 */


/* LinkedList的removeFirst()底层源码

    private E unlinkFirst(Node<E> f) {
            // assert f == first && f != null;
            final E element = f.item;
            final Node<E> next = f.next;
            f.item = null;
            f.next = null; // help GC
            first = next;
            if (next == null)
                last = null;
            else
                next.prev = null;
            size--;
            modCount++;
            return element;
        }
 */





