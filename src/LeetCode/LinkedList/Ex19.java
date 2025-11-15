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

    public ListNode removeNthFromEndMySolution2(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        // Bước 1: Đếm số node
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        if (count < n) {
            return null;
        }

        // Nếu cần xóa node đầu
        int nodeToSkipIdx = count - n;
        if (nodeToSkipIdx == 0) {
            return head.next;
        }

        // Bước 2: Duyệt đến node trước node cần xóa
        int idx = 0;
        ListNode curr = head;
        while (idx < nodeToSkipIdx - 1) {
            curr = curr.next;
            idx++;
        }

        // Bước 3: Xóa node tại vị trí nodeToSkipIdx
        if (curr.next != null) {
            curr.next = curr.next.next;
        }

        return head;
    }


    public ListNode removeNthFromEnd2(ListNode head, int n) {

        ListNode dummy = new ListNode(-1);

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
