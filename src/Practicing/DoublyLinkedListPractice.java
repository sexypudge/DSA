package Practicing;

public class DoublyLinkedListPractice {
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

    public DoublyLinkedListPractice(int value) {
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
            head = newNode;
            tail = newNode;
            length = 1;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        length ++;
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        }

        if (length == 1) {
            Node temp = tail;
            tail = null;
            head = null;
            length --;
            return temp;
        }

        Node temp = tail;
        Node newTail = tail.prev;

        newTail.next = null;
        tail.prev = null;
        tail = newTail;
        length --;
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
            length = 1;
            return;
        }

        head.prev = newNode;
        newNode.next = head;
        head = newNode;
        length++;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp == null) {
            return false;
        }
        temp.value = value;
        return true;
    }

    public boolean insert(int index, int value) {
        Node newNode = new Node(value);
        if (index < 0 || index > length) {
            return false;
        }

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == length) {
            append(value);
            return true;
        }

        Node temp = get(index);
        Node prev = temp.prev;
        if (prev  != null) {
            prev.next = newNode;
            newNode.prev = prev;
        }

        newNode.next = temp;
        temp.prev = newNode;
        length ++;
        return true;
    }

    public static void main(String[] args) {
        DoublyLinkedListPractice p = new DoublyLinkedListPractice(1);
        p.append(1);
    }

}
