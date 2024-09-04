package Practicing;

public class LinkedList {
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
        // 1. if list is empty
        // 2. list size > 0
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
            length++;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        length++;
    }

    public Node removeLast() {
        // 1. list is empty
        // 2. list size = 1
        // 3. list size > 1
        if (length == 0) {
            return null;
        }

        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
            length--;
            return temp;
        }

        while (temp.next.next != null) {
            temp = temp.next;
        }

        tail = temp;
        Node returned = temp.next;
        temp.next = null;
        length--;
        return returned;
    }

    public void prepend(int value) {
        // 1. empty list
        // 2.
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
            length++;
            return;
        }

//        Node temp = head;
//        head = newNode;
//        head.next = temp;
        newNode.next = head;
        head = newNode;
        length++;
    }

    public Node removeFirst() {

        if (length == 0) {
            return null;
        }

        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;

        if (length == 0) {
            tail = null;
        }

        return temp;
    }

    public Node get(int index) {
        if (index > length - 1 || index < 0) {
            return null;
        }

        Node temp = head;
        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public boolean set(int index, int value) {
        // 1. out of range
        if (index < 0 || index > length) return false;

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;

        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == length - 1) {
            return removeLast();
        }

        Node prev = get(index - 1);
        Node removed = prev.next;

        prev.next = removed.next;
        length--;
        removed.next = null;
        return removed;
    }

    public void reverse() {
        if (length == 0 || length == 1) {
            return;
        }

        Node before = head;
        Node after = head.next;
        Node temp;
        for (int i = 0; i < length - 1; i++) {
            temp = after.next;
            after.next = before;
            if (i == 0) {
                before.next = null;
            }
            before = after;
            after = temp;
        }

        temp = head;
        head = tail;
        tail = temp;
    }

    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(4);
        myLinkedList.makeEmpty();
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);
        myLinkedList.append(6);
//        myLinkedList.removeFirst();
        myLinkedList.reverse();
    }

}
