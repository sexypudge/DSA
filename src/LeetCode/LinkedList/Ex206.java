package LeetCode.LinkedList;

public class Ex206 {
    public ListNode reverseList(ListNode head) {
		ListNode before = null;
        ListNode current = head;
        ListNode after;

        while (current != null) {
            after = current.next;
            current.next = before;
            before = current;
            current = after;
        }

        return before;
    }
}
