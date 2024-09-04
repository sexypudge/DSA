package LinkedList;

import java.util.Arrays;

public class Ex3LinkedList {
    private Node head;
    private Node tail;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Ex3LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (head == null) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("\nLinked List:");
        if (head == null) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // WRITE FINDKTHFROMEND METHOD HERE //
    public Node findKthFromEnd(int k) {
        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public Node findKthFromEndMySolution(int k) {
        Node slow = head;
        Node fast = head;

        int len = 1;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            len += 2;
        }

        if (fast == null) {
            len -= 1;
        }

        int indexOfK = len - k;

        if (indexOfK < 0 ) {
            return null;
        }

        if (slow == null) {
            return null;
        }



        return slow;
    }

    public static void main(String[] args) {
        Ex3LinkedList myList = new Ex3LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);
        myList.findKthFromEnd(2);
//        System.out.println(Arrays.toString(array));
    }
}
