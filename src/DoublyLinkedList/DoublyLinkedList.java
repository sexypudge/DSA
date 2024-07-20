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
        temp.next = null;
        length --;
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        Node temp = head;
        for (int i = 0; i < index; i ++) {
            temp = temp.next;
        }
        // if the index is in the first half of the list
//        if (index < length/2) {
//            // iterate through the list from the head to the index
//            for (int i = 0; i < index; i++) {
//                temp = temp.next;
//            }
//        } else {
//            // if the index is in the second half of the list
//            // initialize the temporary node with the value of the tail
//            temp = tail;
//            // iterate through the list from the tail to the index
//            for (int i = length - 1; i > index; i--) {
//                temp = temp.prev;
//            }
//        }
        // return the node at the given index
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

        Node newNode = new Node(value);
        Node prev = get(index - 1);
        newNode.next = prev.next;
        prev.next.prev = newNode;
        prev.next = newNode;

        newNode.prev = prev;

        length ++;
        return true;
    }

    public Node remove(int index) {

        if (index < 0 || index >= length) {
            return null;
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == length - 1 ) {
            return removeLast();
        }

        Node temp = get(index);
        Node prev = temp.prev;
        Node next = temp.next;
        prev.next = next;
        next.prev = prev;
        temp.prev = null;
        temp.next = null;
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
