package LeetCode;

public class Ex21 {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode result = new ListNode(-1);
        ListNode temp = result;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            temp = temp.next;
        }

        while (list1 != null) {
            temp.next = new ListNode(list1.val);
            list1 = list1.next;
            temp = temp.next;
        }

        while (list2 != null) {
            temp.next = new ListNode(list2.val);
            list2 = list2.next;
            temp = temp.next;
        }

        return result.next;
    }

    public static void main(String[] args) {
//        ListNode listA1 = new ListNode(1);
        ListNode listA12 = new ListNode(2);
//        ListNode listA124 = new ListNode(4);
//        listA1.next = listA12;
//        listA12.next = listA124;

        ListNode listB1 = new ListNode(1);
//        ListNode listB13 = new ListNode(3);
//        ListNode listB134 = new ListNode(4);
//        listB1.next = listB13;
//        listB13.next = listB134;

        ListNode merge = mergeTwoLists(listA12, listB1);
    }
}
