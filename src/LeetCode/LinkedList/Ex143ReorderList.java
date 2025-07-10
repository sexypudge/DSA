package LeetCode.LinkedList;

public class Ex143ReorderList {
    public void reorderList(ListNode head) {
        ListNode middle = middle(head);

        ListNode secondHalf = middle.next;  // lấy nửa sau bắt đầu từ middle.next
        middle.next = null;                 // tách nửa đầu ra

        // Reverse nửa sau
        ListNode reversed = reverse(secondHalf);

        // Merge 2 nua
//        mergeByMe(head, reversed);
        merge(head, reversed);
    }

    private static ListNode middle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    private static void merge(ListNode list1, ListNode list2) {
        ListNode headDummy1 = list1;

        ListNode first = list1;
        ListNode second = list2;

        while (first != null && second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;

            // Nếu tmp1 == null thì không nên gán tiếp → kết thúc luôn
            if (tmp1 == null) break;

            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }
    }

    /**
     *  Trong bài ReOrderList
     *  list2 luôn ngắn hơn hoặc bằng list1 (do tách nửa sau)
     * → Hàm này vẫn hoàn toàn hợp lệ và chạy tốt trong mọi test của bài đó
     */
    private static void merge2(ListNode list1, ListNode list2) {
        ListNode headDummy1 = list1;

        ListNode first = list1;
        ListNode second = list2;

        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }
    }


    private static void mergeByMe(ListNode list1, ListNode list2) {
        ListNode headDummy1 = list1;
        boolean isList1Turn = true;
        ListNode list1Temp;
        ListNode list2Temp;

        while (list1 != null && list2 != null) {

            if (isList1Turn) {
                list1Temp = list1.next;
                list1.next = list2;
                list1 = list1Temp;

                isList1Turn = false;
            } else {
                list2Temp = list2.next;
                list2.next = list1;
                list2 = list2Temp;

                isList1Turn = true;
            }
        }
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
//        ListNode list12 = new ListNode(2);
        ListNode list123 = new ListNode(3);

//        list1.next = list12;
//        list12.next = list123;

        ListNode list5 = new ListNode(5);
        ListNode list54 = new ListNode(4);
        ListNode list543 = new ListNode(3);
        ListNode list5432 = new ListNode(2);

        list5.next = list54;
        list54.next = list543;
        list543.next = list5432;

//        mergeByMe(list1, list5);
        merge(list1, list5);
    }
}
