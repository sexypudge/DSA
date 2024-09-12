package LeetCode.LinkedList;

public class Ex86 {

    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);;

        ListNode runner1 = head;
        ListNode temp = dummy1;
        ListNode temp2 = dummy2;

        while (runner1 != null) {
            if (runner1.val < x) {
                dummy1.next = runner1;
                dummy1 = dummy1.next;
            } else {
                dummy2.next = runner1;
                dummy2 = dummy2.next;
            }

            runner1 = runner1.next;
        }

        dummy2.next = null;
        dummy1.next = temp2.next;

        return temp.next;
    }
}
