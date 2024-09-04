package LinkedList;

public class Ex5LinkedList {

    private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Ex5LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
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
        } else {
            System.out.println("Head: " + head.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }

    // WRITE THE REMOVEDUPLICATES METHOD HERE //
    //                                        //
    //                                        //
    //                                        //
    //                                        //
    ////////////////////////////////////////////


    public void removeDuplicates() {
        // Step 1: Start at the beginning of the list.
        // Initialize `current` to point to the head node.
        // `current` will be used to navigate through the list,
        // one node at a time, starting from the head node.
        Node current = head;

        // Step 2: Check if we've reached the end of the list.
        // We loop until `current` becomes null, which means
        // we've checked all nodes for duplicates.
        while (current != null) {

            // Step 3: Set up a runner node.
            // Initialize `runner` to the `current` node.
            // We'll use `runner` to scan ahead and find duplicates
            // of the `current` node.
            Node runner = current;

            // Step 4: Loop through the remaining nodes.
            // `runner.next` will be null at the end of the list.
            while (runner.next != null) {

                // Step 5: Compare nodes.
                // Check if `runner.next` (the next node) has the
                // same value as `current`.
                if (runner.next.value == current.value) {

                    // Step 6: Remove duplicate.
                    // If we find a duplicate, we skip it by
                    // setting `runner.next` to `runner.next.next`.
                    runner.next = runner.next.next;

                    // Step 7: Update list length.
                    // We removed a node, so decrease the list length
                    // by 1 to keep it accurate.
                    length -= 1;

                } else {

                    // Step 8: Move to the next node.
                    // If the next node is not a duplicate,
                    // move `runner` to the next node to continue.
                    runner = runner.next;
                }
            }

            // Step 9: Move to the next unique node.
            // After checking all nodes for duplicates of the
            // current value, move `current` to the next node.
            current = current.next;
        }
    }

    public void removeDuplicates1() {
        Node current = head;

        while (current != null) {
            Node runner = current;

            while (runner.next != null) {
                if (runner.next.value == current.value) {
                    runner.next = runner.next.next;
                    length -= 1;
                } else {
                    runner = runner.next;
                }
            }

            current = current.next;
        }
    }

    public void removeDuplicatesMySolution() {
        Node temp = head;
        int len = 0;
        while (temp != null) {

            Node temp1 = head;

            for (int i = 0; i < len; i++) {
                if (temp1.value == temp.value) {
                    temp1.next = temp1.next.next;
                    length -= 1;
                } else {
                    temp1 = temp1.next;
                }
            }

            temp = temp.next;
            len++;
        }

    }

    public static void main(String[] args) {

        Ex5LinkedList myLinkedList = new Ex5LinkedList(1);

        myLinkedList.append(2);
        myLinkedList.append(1);


        myLinkedList.removeDuplicatesMySolution();

        myLinkedList.printList();

        /*
            EXPECTED OUTPUT:
            ----------------
            1
            2
            3
            4

        */

    }

}


