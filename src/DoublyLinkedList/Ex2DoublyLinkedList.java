package DoublyLinkedList;

public class Ex2DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public Ex2DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nDoubly Linked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
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
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

//public void reverse() {
//        // 'current' starts at the head of the list. This is the starting point
//        // for the reversal process.
//        Node current = head;
//
//        // 'temp' is a temporary variable used for swapping nodes. It is initially
//        // set to null since we haven't started the swapping process yet.
//        Node temp = null;
//
//        // We enter a loop that will continue as long as 'current' is not null.
//        // This loop goes through each node in the list.
//        while (current != null) {
//            // Store the previous node of 'current' in 'temp'.
//            // This is needed because we will be overwriting 'current.prev' next,
//            // and we don't want to lose this reference.
//            temp = current.prev;
//
//            // The next two lines are where we swap the 'next' and 'prev' references
//            // of the 'current' node. This effectively reverses the direction of the
//            // links for 'current'.
//            current.prev = current.next; // 'prev' now points to what used to be 'next'
//            current.next = temp;         // 'next' now points to what used to be 'prev'
//
//            // Move to the next node in the original list. After the swap, the original
//            // 'next' node is now in 'current.prev', so we update 'current' to this node.
//            current = current.prev;
//        }
//
//        // After the while loop, the list is reversed, but our 'head' and 'tail' pointers
//        // are still pointing to the original head and tail. So we need to swap them.
//        temp = head;   // Store the original head in 'temp'
//        head = tail;   // Update head to be the original tail
//        tail = temp;   // Update tail to be what was originally the head
//    }

    public void reverse() {
        if (length == 0) {
            return;
        }

        Node temp = head;
        Node before;
        Node after;
        while (temp.next != null) {
            after = temp.next;
            before = temp.prev;
            temp.next = before;
            temp.prev = after;
            temp = after;
        }

        temp.next = temp.prev;
        temp.prev = null;

        temp = head;
        head = tail;
        tail = temp;
    }

    public static void main(String[] args) {

        Ex2DoublyLinkedList myDLL = new Ex2DoublyLinkedList(1);
        myDLL.append(2);
        myDLL.append(3);
        myDLL.append(4);
        myDLL.append(5);

        System.out.println("DLL before reverse:");
        myDLL.printList();

        myDLL.reverse();

        System.out.println("\nDLL after reverse:");
        myDLL.printList();


        /*
       		EXPECTED OUTPUT:
        	----------------
            DLL before reverse:
            1
            2
            3
            4
            5

            DLL after reverse:
            5
            4
            3
            2
            1

     	*/

    }
}

