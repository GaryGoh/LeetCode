package LeetCode;

import LeetCode.util.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2
 * Output: false
 * Example 2:
 * <p>
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 * questions,
 * 1. can this linked list has cycle?
 *
 * corner case
 * 1. null -> return false?
 * 2. 1 -> 1
 *
 * algorithm.
 * 1. use a slow pointer to get the mid position
 *    slow = slow.next
 *    fast = fast.next.next
 *    until fast or fast.next == null
 * 2. reverse the rest pointer
 *      tmp <- slow.next
 *      slow.next = end
 *      end = slow
 *      slow = tmp
 * 3. head.val == end.val; until != null, otherwise return false;
 *
 * 重点！ 翻转 linkedlist
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // get the mid point
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        // reverse the later half linked list
        ListNode end = null;
        ListNode tmp = null;
        while (slow != null) {
            tmp = slow.next;
            slow.next = end;
            end = slow;
            slow = tmp;
        }

        // compare head and end
        while (end != null) {
            if (head.val != end.val) {
                return false;
            }
            head = head.next;
            end = end.next;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList p = new PalindromeLinkedList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);

        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;

        System.out.println(p.isPalindrome(n1));
    }
}
