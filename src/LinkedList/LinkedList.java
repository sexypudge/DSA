package LinkedList;

public class LinkedList {
// CREATE CLASS VARIABLES, NODE CLASS, AND CONSTRUCTOR HERE //
    //                                                          //
    //                                                          //
    //                                                          //
    //                                                          //
    //////////////////////////////////////////////////////////////
    Node head;
    Node tail;
    int length;

    public LinkedList(int value) {
        Node newNode = new Node(value, null);

        head = newNode;

        tail = newNode;

        length = 1;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }
    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);

       if (length == 0) {
           head = newNode;
           tail = newNode;
       } else {
           tail.next = newNode;
           tail = newNode;
       }

       length ++;
    }

    public Node removeLast() {
       if (length == 0) {
           return null;
       }

       Node newLast = head;
       Node last = head;

       while (last.next != null) {
           newLast = last;
           last = last.next;
       }

       tail = newLast;
       tail.next = null;
       length --;

       if (length == 0) {
           tail = null;
           head = null;
       }
       return last;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        length ++;
    }

    public Node removeFirst() {
        if (length == 0) {
            return null;
        }
        Node first = null;
        if (length == 1) {
            first = head;
            head = null;
            tail = null;
        } else {
            first = new Node(head.value);
            head = head.next;
        }

        length --;
        return first;
    }

    public static void main(String[] args) {

        LinkedList myLinkedList = new LinkedList(4);
        myLinkedList.makeEmpty();
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);

        myLinkedList.removeLast();
        myLinkedList.prepend(4);

        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();

        System.out.println("\nLinked List:");
        myLinkedList.printList();
    }
}
