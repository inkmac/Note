package LinkedList;

public class CycleDetection {
    public boolean hasCycle(Node head) {
        Node hare = head;
        Node tortoise = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;

            if (hare == tortoise) {
                return true;
            }
        }

        return false;
    }

    public Node Entrance(Node head) {
        Node hare = head;
        Node tortoise = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;

            if (hare == tortoise) {   //第一次相遇
                tortoise = head;
                while (true) {
                    if (hare == tortoise) {   //第二次相遇
                        return hare;
                    }
                    tortoise = tortoise.next;
                    hare = hare.next;
                }
            }
        }

        return null;
    }

    private static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        Node n12 = new Node(12, null);
        Node n11 = new Node(11, n12);
        Node n10 = new Node(10, n11);
        Node n9 = new Node(9, n10);
        Node n8 = new Node(8, n9);
        Node n7 = new Node(7, n8);
        Node n6 = new Node(6, n7);
        Node n5 = new Node(5, n6);
        Node n4 = new Node(4, n5);
        Node n3 = new Node(3, n4);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);
        n12.next = n1;

        boolean res = new CycleDetection().hasCycle(n1);
        System.out.println(res);
        Node entrance = new CycleDetection().Entrance(n1);
        System.out.println(entrance.value);
    }
}
