package Queue;
import java.util.Iterator;

class LinkedListQueue<E> implements Queue<E>, Iterable<E>{
    private final Node<E> head = new Node<>(null ,null);  //head是一个哨兵, tail不是
    private Node<E> tail = head;
    private int size;
    private int capacity = 10;

    {   //构造器相同的语句抽取到代码块中
        tail.next = head;
    }

    public LinkedListQueue() {}

    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean offer(E value) {
        if (isFull())
            return false;
        Node<E> node = new Node<>(value, head);
        tail.next = node;   //TODO
        tail = node;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty())
            return null;
        Node<E> node = head.next;
        head.next = node.next;
        if (node == tail)   //第一个node是tail的时候, 需要删除后将tail重新指向
            tail = head;
        size--;
        return node.value;
    }

    @Override
    public E peek() {
        if (isEmpty())
            return null;
        Node<E> node = head.next;
        return node.value;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> ptr = head.next;
            @Override
            public boolean hasNext() {
                return ptr != head;  //到头就停
            }

            @Override
            public E next() {
                E temp = ptr.value;
                ptr = ptr.next;
                return temp;
            }
        };
    }

    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

}
