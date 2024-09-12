package LeetCode.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class Ex160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> listNodeSet = new HashSet<>();

        ListNode runnerA = headA;
        ListNode runnerB = headB;

        while (runnerA != null) {
            listNodeSet.add(runnerA);
            runnerA = runnerA.next;
        }

        while (runnerB != null) {
            if (listNodeSet.contains(runnerB)) {
                return runnerB;
            }
            runnerB = runnerB.next;
        }
        return null;
    }

    public static ListNode getIntersectionNodeLeetCodeSolution(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }

    public static void main(String[] args) {
        ListNode listA1 = new ListNode(1);
        ListNode listA12 = new ListNode(2);
        ListNode listA124 = new ListNode(4);
        listA1.next = listA12;
        listA12.next = listA124;

//        ListNode listB1 = new ListNode(1);
        ListNode listB13 = new ListNode(3);

//        ListNode listB134 = new ListNode(4);
//        listB1.next = listB13;
        listB13.next = listA124;

        ListNode merge = getIntersectionNodeLeetCodeSolution(listA1, listB13);
    }
}
