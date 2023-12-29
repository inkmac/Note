package LinkedList;

import java.util.Iterator;

public class DoublyCircleLinkedList implements Iterable<Integer>{
    private final Node sentinel;    //既是head也是tail

    public DoublyCircleLinkedList() {
        sentinel = new Node(null, 666, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(int value) {
        Node a = sentinel;      // a,b是node两端的节点
        Node b = sentinel.next;
        Node node = new Node(a, value, b);
        a.next = node;
        b.pre = node;
    }

    public void addLast(int value) {
        Node a = sentinel.pre;
        Node b = sentinel;
        Node node = new Node(a, value, b);
        a.next = node;
        b.pre = node;
    }

    public void removeFirst() {
        Node removed = sentinel.next;
        if (removed == sentinel) {
            throw new NullPointerException("No Node Found");
        }
        Node next = removed.next;
        sentinel.next = next;
        next.pre = sentinel;
        removed.pre = null;
        removed.next = null;
    }

    public void removeLast() {
        Node removed = sentinel.pre;
        if (removed == sentinel) {
            throw new NullPointerException("No Node Found");
        }
        Node pre = removed.pre;
        pre.next = sentinel;
        sentinel.pre = pre;
        removed.pre = null;
        removed.next = null;
    }

    private Node findValue(int value) {
        Node ptr = sentinel.next;
        while (ptr != sentinel) {
            if (ptr.value == value)
                return ptr;
            ptr = ptr.next;
        }
        throw new IllegalArgumentException("Value Not Found~");
    }

    public void removeValue(int value) {
        Node removed = findValue(value);
        Node pre = removed.pre;
        Node next = removed.next;
        pre.next = next;
        next.pre = pre;
        removed.pre = null;
        removed.next = null;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node ptr = sentinel.next;
            @Override
            public boolean hasNext() {
                return ptr != sentinel;
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
        Node pre;
        int value;
        Node next;

        public Node(Node pre, int value, Node next) {
            this.pre = pre;
            this.value = value;
            this.next = next;
        }
    }
}

//class test {
//    public static void main(String[] args) {
//        DoublyCircleLinkedList integers = new DoublyCircleLinkedList();
//        integers.addLast(0);
//        integers.addLast(1);
//        integers.addLast(2);
//        integers.addLast(3);
//        integers.addLast(4);
//
//        for (Integer integer : integers) {
//            System.out.print(integer + " ");
//        }
//    }
//}