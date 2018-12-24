package LeetCode;

import LeetCode.util.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example:
 * <p>
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 * <p>
 * questions:
 * 1. singly linked list or double linked list?
 * 2. does the linked list include cycle(s)?
 * <p>
 * corner case:
 * 1. list = null, return null
 * 2. the node is the tail, then current = null
 * 3. head is the value
 * 4. all these values.
 * <p>
 * algorithm:
 * traverse linked list, if find the node, then replace the current node with next node.
 * node <- node.next
 * <p>
 * key point:
 * <p>
 * 1. remove head
 * 2. general remove
 * 3. remove tail
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveLinkedListElements {
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(val - 1);
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;

        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next: head;
    }

    public static void main(String[] args) {
        RemoveLinkedListElements r = new RemoveLinkedListElements();
        ListNode l1 = new ListNode(6);
        ListNode l2 = new ListNode(6);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(6);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        System.out.println(r.removeElements(l1, 6).toString());
    }
}
