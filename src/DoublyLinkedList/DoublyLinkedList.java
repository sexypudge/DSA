package DoublyLinkedList;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    static class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
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

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            tail = newNode;
            head = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }

        length ++;
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        }

        if (length == 1) {
            Node temp = head;
            tail = null;
            head = null;
            length --;
            return temp;
        }

        Node newTail = tail.prev;
        newTail.next = null;

        tail.prev = null;
        Node temp = tail;
        tail = newTail;
        length --;
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        length ++;
    }

    public Node removeFirst() {
        if (length == 0) {
            return null;
        }

        if (length == 1) {
            Node temp = head;
            tail = null;
            head = null;
            length --;
            return temp;
        }

        Node newHead = head.next;
        newHead.prev = null;
        Node temp = head;
        head = newHead;
        length --;
        return temp;
    }

    public static void main(String[] args) {

        DoublyLinkedList myDLL = new DoublyLinkedList(7);

        myDLL.getHead();
        myDLL.getTail();
        myDLL.getLength();

        System.out.println("\nDoubly Linked List:");
        myDLL.printList();
    }
}
