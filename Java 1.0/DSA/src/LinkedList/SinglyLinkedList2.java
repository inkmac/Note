package LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class SinglyLinkedList2 implements Iterable<Integer> {
    private final Node head = new Node(8080, null);      //head指向哨兵

    public void addFirst(int value) {
        insert(0, value);
    }

    private Node findLast() {
        Node ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        return ptr;
    }

    public void addLast(int value) {
        Node last = findLast();     //最差也能找到哨兵
        last.next = new Node(value, null);
    }

    private Node findNode(int index) {
        int i = -1;     //考虑哨兵
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
        Node pre = findNode(index - 1);  //找到上一个节点
        pre.next = new Node(value, pre.next);  //插入新节点
    }

    public void removeFirst() {
        remove(0);
    }

    public void remove(int index) {
        Node pre = findNode(index - 1);
        Node removed = pre.next;
        if (removed == null) {
            throw new IllegalArgumentException();
        }
        pre.next = removed.next;
        removed.next = null;
    }


    private void recursion(Node curr) {     //递归遍历
        if (curr == null) {
            System.out.println();
            return;
        }
        System.out.print(curr.value + " ");
        recursion(curr.next);
    }

    public void loop() {
        recursion(head.next);
    }

    public void iterate() {
        Node ptr = head.next;
        while (ptr != null) {
            System.out.print(ptr.value + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node ptr = head.next;
            @Override
            public boolean hasNext() {
                return ptr != null;
            }

            @Override
            public Integer next() {
                int value = ptr.value;
                ptr = ptr.next;      //ptr后移
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


//class test2 {
//    public static void main(String[] args) {
//        SinglyLinkedList2 SLL = new SinglyLinkedList2();
//        SLL.addLast(0);
//        SLL.addLast(1);
//        SLL.addLast(2);
//        SLL.addLast(3);
//        SLL.insert(0, 4);
//        SLL.remove(0);
//
//        SLL.loop();
//        SLL.iterate();
//        for (Integer next : SLL) {
//            System.out.print(next + " ");
//        }
//
//
//        LinkedList<Object> objects = new LinkedList<>();
//    }
//}