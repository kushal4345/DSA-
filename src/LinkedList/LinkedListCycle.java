package LinkedList;

public class LinkedListCycle {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        boolean check = false;

        // Creating nodes
        Node a = new Node(10);
        Node b = new Node(-4);
        Node c = new Node(9);
        Node d = new Node(8);

        // Linking nodes
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b; // Creates a cycle here

        // Floyd’s Cycle Detection Algorithm
        Node slow = a;
        Node fast = a; // should start both from head

        while (fast != null && fast.next != null) {
            slow = slow.next;           // move by 1
            fast = fast.next.next;      // move by 2

            if (slow == fast) {
                check = true;
                break;
            }
        }

        System.out.println(check); // should print true
    }
}

