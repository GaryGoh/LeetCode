package LeetCode;

import LeetCode.util.ListNode;

import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */

public class MergekSortedLists {

    /**
     * O(time) = O(nlogk)
     */

    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0 || lists == null) {
            return null;
        }

        // add lists to priority queue
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        for (ListNode l : lists) {
            if (l != null) {
                queue.offer(l);
            }
        }

        // pop element from queue and add to res
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) {
                queue.offer(cur.next);
            }
        }
        return res.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 || lists == null) {
            return null;
        }
        return sort(lists, 0, lists.length - 1);
    }

    private ListNode sort(ListNode[] lists, int low, int high) {
        if (low >= high) {
            return lists[low];
        }
        int mid = (low + high) / 2;
        ListNode l1 = sort(lists, low, mid);
        ListNode l2 = sort(lists, mid + 1, high);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }


    public static void main(String[] args) {
        MergekSortedLists m = new MergekSortedLists();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(2);
        ListNode l8 = new ListNode(6);
//        ListNode l9 = new ListNode(1);

        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        l7.next = l8;
        ListNode[] lists = {l1, null, l4, l7};

        ListNode res = m.mergeKLists(lists);
        while (res != null) {
            System.out.println(res.val + ", ");
            res = res.next;
        }

    }
}
