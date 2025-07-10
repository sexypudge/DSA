package LeetCode.LinkedList;

public class Ex206 {
    public ListNode reverseList(ListNode head) {
		ListNode previous = null;
        ListNode current = head;
        ListNode next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            System.out.println("Returning base case: " + (head != null ? head.val : "null"));
            return head;
        }

        System.out.println("Before recursion: head = " + head.val);
        ListNode newHead = reverseListRecursive(head.next);
//        System.out.println("new head = " + newHead.val);
        System.out.println("After recursion: head = " + head.val + ", head.next = " + head.next.val);

        head.next.next = head;  // đảo liên kết
        head.next = null;       // cắt liên kết cũ
        System.out.println("Reversing: " + head.val + " -> " + (head.next != null ? head.next.val : "null"));
        return newHead;         // trả về đầu mới
    }


    public ListNode reverseListTest(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode previous = null;
        ListNode current = head;
        ListNode next = head.next;

        while (next != null) {
            current.next = previous;
            previous = current;
            current = next;
            next = next.next;
        }

        current.next = previous;

        return previous;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3)));

        System.out.print("Original: ");
        printList(head);

        head = reverseListRecursive(head);

        System.out.print("Reversed: ");
        printList(head);

        System.out.println("new Head: " + head.val);
    }
}
