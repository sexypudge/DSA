package LinkedList;

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

        Node temp = head;
        head = head.next;
        temp.next = null;
        length --;

        if (length == 0) {
            tail = null;
        }
        return temp;

//        if (length == 0) {
//            return null;
//        }
//        Node first = null;
//        if (length == 1) {
//            first = head;
//            head = null;
//            tail = null;
//        } else {
//            first = new Node(head.value);
//            head = head.next;
//        }
//
//        length --;
//        return first;
    }

    public Node get(int index) {

        if (index < 0 || index >= length) {
            return null;
        }

        int start = 0;
        Node temp = head;

        while (temp.next != null) {
            if (start == index) {
                return temp;
            }
            temp = temp.next;
            start ++;
        }

        return temp;

        // if the index is less than 0 or greater than or equal to the length of the linked list, return null
//        if (index < 0 || index >= length) return null;
        // start at the head of the linked list
//        Node temp = head;
        // traverse the linked list until the desired node is reached
//        for(int i = 0; i < index; i++) {
//            temp = temp.next;
//        }
        // return the pointer to the node at the desired index
//        return temp;
    }

    public boolean set(int index, int value) {
        if (index < 0 || index >= length) {
            return false;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        temp.value = value;
        return true;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length ) {
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

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(temp.value);
        newNode.next = temp.next;

        temp.value = value;
        temp.next = newNode;

        length ++;

        // If the index is in the middle, insert the node
        // Create the new node
//        Node newNode = new Node(value);

        // Get a pointer to the node at the previous index
//        Node temp = get(index - 1);

        // Insert the new node by updating the next pointers
//        newNode.next = temp.next;
//        temp.next = newNode;

        // Update the length of the list
//        length++;

        // Return true to indicate successful insertion
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length ) {
            return null;
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == length - 1 ) {
            return removeLast();
        }

        Node prev = get(index - 1);
        Node toRemoved = prev.next;

        prev.next = toRemoved.next;
        toRemoved.next = null;
        length --;
        return toRemoved;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;

        Node after = temp.next;
        Node before = null;

         for (int i = 0; i < length; i ++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public static void main(String[] args) {

        LinkedList myLinkedList = new LinkedList(4);
        myLinkedList.makeEmpty();
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.reverse();
//        myLinkedList.insert(2, 9);
//        myLinkedList.removeFirst();
//        myLinkedList.removeLast();
//        myLinkedList.prepend(4);

        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();

        System.out.println("\nLinked List:");
        myLinkedList.printList();
    }
}
