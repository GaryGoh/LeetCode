package LeetCode;

import LeetCode.util.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * Note: Do not modify the linked list.
 * <p>
 * Follow up:
 * Can you solve it without using extra space?
 *
 * 3 -> 2 -> 0 -> 4 -> 3
 */

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (head == fast) {
                break;
            }
            head = head.next;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (head == fast) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
//        n4.next = n3;
//        n2.next = n3
//        n3.next = n1;
        LinkedListCycleII ls = new LinkedListCycleII();
        System.out.println(ls.detectCycle(n1).val);
    }
}
