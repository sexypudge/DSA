package LeetCode.LinkedList;

public class Ex19 {

    /**
     * #TwoPointers
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }


        ListNode runner1 = head;
        ListNode runner2 = head;

        for (int i = 0; i < n; i ++) {
            if (runner1 == null) {
                return null;
            }
            runner1 = runner1.next;
        }

        if (runner1 == null) {
            return head.next;
        }

        while (runner1.next != null) {
            runner1 = runner1.next;
            runner2 = runner2.next;
        }

        runner2.next = runner2.next.next;

        return head;
    }

    public ListNode removeNthFromEndMySolution(ListNode head, int n) {
        if (head == null) {
            return head;
        }

		ListNode runner = head;

        int length = 0;
        ListNode runner1 = head;
        ListNode runner2 = head;
        while (runner1 != null) {
            length ++;
            runner1 = runner1.next;
        }

        int targetIndex = length - n;

        for (int i = 1; i < targetIndex; i ++) {
            runner2 = runner2.next;
        }

        if (targetIndex == 0) {
            head = head.next;
            return head;
        }

        ListNode target = runner2.next;
        ListNode nextTarget =  runner2.next.next;
        target.next = null;
        runner2.next = nextTarget;
        return head;
    }
}
