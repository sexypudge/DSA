package LeetCode.LinkedList;

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

    public static ListNode mergeTwoListsTest(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1); // node giả
        ListNode head = dummy; // node giả

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                dummy.next = list1;
                list1 = list1.next;
            } else {
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }

        // Chỉ cần nối phần còn lại (không cần dùng 2 while)
        if (list1 != null) dummy.next = list1;
        if (list2 != null) dummy.next = list2;

        return head.next;
    }

    /**
     * Input: list1 = [1,2,4], list2 = [1,3,4]
     * Output: [1,1,2,3,4,4]
     *   1(L2)-> 1(L1)> 2(L1)-> 3(L2) -> 4(L2) -> 4(L1)
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoListsRecursive(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursive(list1, list2.next);
            return list2;
        }
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
