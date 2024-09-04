package LinkedList;

public class Ex1LinkedList {
    private Node head;
    private Node tail;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Ex1LinkedList(int value) {
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

    /**
     * Given: Node1 -> Node2 -> Node3 -> Node4 -> Node5 -> Node6
     * <p>
     * START LOOP
     * 	slow = Node1
     * 	fast = Node1
     * <p> ================
     *
     * 1st Iter:
     * 	if: fast = Node1 # null
     * 		fast.next = Node2 # null
     * <p>
     * 	=> slow = slow.next = Node1.next = Node2
     * 	=> fast = fast.next.next = Node1.next.next = Node3
     * <p> ================
     *
     * 2nd Iter:
     * 	if: fast = Node3 # null
     * 		fast.next = node4 # null
     *
     * 		slow = slow.next = Node2.next = Node3
     * 		fast = fast.next.next = Node3.next.next = Node5
     * <p> ================
     *
     * 3rd Iter:
     * 	if: fast = Node5 # null
     * 		fast.next = Node6 # null
     * <p>
     * 	slow = slow.next = Node3.next = Node4
     * 	fast = fast.next.next = Node5.next.next = null
     * <p> ================
     *
     * 4th Iter:
     * 	if: fast = null is true
     * <p> ===============
     * END Loop
     */
    public Node findMiddleNode() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node findMiddleNodeMySolution() {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        Node temp = head;

        int middle = 0;
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            length ++;
        }

        middle = (length) / 2;
        temp = head;
        for (int i = 1; i <= middle; i ++) {
            temp = temp.next;
        }

        return temp;
    }

    public static void main(String[] args) {

        Ex1LinkedList myLinkedList = new Ex1LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);


        System.out.println("1 -> 2 -> 3 -> 4 -> 5");
        System.out.println( "Middle Node: "+ myLinkedList.findMiddleNode().value);


        myLinkedList.append(6);


        System.out.println("===========================");
        System.out.println("1 -> 2 -> 3 -> 4 -> 5 -> 6");
        System.out.println( "Middle Node: "+ myLinkedList.findMiddleNode().value);


        /*
            EXPECTED OUTPUT:
            ----------------
            1 -> 2 -> 3 -> 4 -> 5
            Middle Node: 3
            ===========================
            1 -> 2 -> 3 -> 4 -> 5 -> 6
            Middle Node: 4

        */

    }

}
