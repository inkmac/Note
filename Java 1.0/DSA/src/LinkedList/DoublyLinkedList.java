package LinkedList;
import java.util.Iterator;

public class DoublyLinkedList implements Iterable<Integer> {
    private final Node head;
    private final Node tail;

    public DoublyLinkedList() {
        head = new Node(null, 666, null);
        tail = new Node(null, 888, null);
        head.next = tail;
        tail.pre = head;
    }

    private Node findNode(int index) {
        int i = -1;     //考虑哨兵
        for (Node ptr = head; ptr != tail; ptr = ptr.next, i++) {
            if (i == index)
                return ptr;
        }
        throw new IllegalArgumentException("Index Not Found");
    }

    public void insert(int index, int value) {
        Node pre = findNode(index - 1);
        Node next = pre.next;
        Node node = new Node(pre, value, next);
        pre.next = node;
        next.pre = node;
    }

    public void addFirst(int value) {
        insert(0, value);
    }

    public void remove(int index) {
        Node removed = findNode(index);   //基于双向链表的一个优化
        Node pre = removed.pre;
        Node next = removed.next;
        pre.next = next;
        next.pre = pre;
        removed.pre = null;
        removed.next = null;
    }

    public void removeFirst() {
        remove(0);
    }

    public void addLast(int value) {
        Node pre = tail.pre;
        Node node = new Node(pre, value, tail);
        pre.next = node;
        tail.pre = node;
    }

    public void removeLast() {
        Node removed = tail.pre;
        if (removed == head) {
            throw new IllegalArgumentException();
        }
        Node pre = removed.pre;
        pre.next = tail;
        tail.pre = pre;
        removed.pre = null;
        removed.next = null;
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

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node ptr = head.next;
            @Override
            public boolean hasNext() {
                return ptr != tail;
            }

            @Override
            public Integer next() {
                int value = ptr.value;
                ptr = ptr.next;      //ptr后移
                return value;
            }
        };
    }
}

