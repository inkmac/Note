package LinkedList;
import java.util.Iterator;
import java.util.LinkedList;

public class SinglyLinkedList implements Iterable<Integer> {
    private Node head;      //head就指向第一个数据

    public void addFirst(int value) {
        head = new Node(value, head);   //将数据插在head前面
    }

    private Node findLast() {
        if (head == null)   //处理空链表的情况
            return null;

        Node ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        return ptr;
    }

    public void addLast(int value) {
        Node last = findLast();
        if (last == null) {
            addFirst(value);   //若为空链表, 直接添加
            return;
        }
        last.next = new Node(value, null);
    }

    private Node findNode(int index) {
        int i = 0;
        for (Node ptr = head; ptr != null; ptr = ptr.next, i++) {
            if (i == index)
                return ptr;
        }
        throw new IllegalArgumentException("Index Not Found");
    }

    public int get(int index) {
        Node node = findNode(index);
        return node.value;
    }

    public void insert(int index, int value) {
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node pre = findNode(index - 1);  //找到上一个节点
        pre.next = new Node(value, pre.next);  //插入新节点
    }

    public void removeFirst() {
        if (head == null)
            throw new IllegalArgumentException("Null List");
        head = head.next;
    }

    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }
        Node pre = findNode(index - 1);
        Node removed = pre.next;
        if (removed == null) {
            throw new IllegalArgumentException();
        }
        pre.next = removed.next;
        removed.next = null;
    }

    public void iterate() {
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.value + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node ptr = head;
            @Override
            public boolean hasNext() {
                return ptr != null;
            }

            @Override
            public Integer next() {
                int value = ptr.value;
                ptr = ptr.next;
                return value;
            }
        };
    }

    private static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}



//class test1 {
//    public static void main(String[] args) {
//        SinglyLinkedList SLL = new SinglyLinkedList();
//        SLL.addFirst(1);
//        SLL.addLast(2);
//        SLL.addLast(3);
//        SLL.addLast(4);
//        SLL.insert(0, 5);
//        SLL.remove(1);
//
//        for (Integer next : SLL) {
//            System.out.print(next + " ");
//        }
//
//
//        LinkedList<Object> objects = new LinkedList<>();
//    }
//}