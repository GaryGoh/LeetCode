package AWS.CodePractive;

/**
 * Created by mgao on 2017/3/29.
 */
public class MergedKSortedList {
    /**
     * Definition for singly-linked list.
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length < 1) return null;

            ListNode result = lists[0];
            ListNode tmpList;
            for (int i = 1; i < lists.length; i++) {
                while (result.next != null && lists[i].next != null) {
                    if (lists[i].val <= result.val) {
                        tmpList = lists[i].next;
                        result.val ^= lists[i].val;
                        lists[i].val ^= result.val;
                        result.val ^= lists[i].val;
                        result.next = lists[i];
                        lists[i].next = result.next;
                        lists[i] = tmpList;
                    } else {
                        result = result.next;
                    }
                }

                if (result.next == null) {
                    while (lists[i] != null) {
                        result.next = lists[i];
                        lists[i] = lists[i].next;
                        result = result.next;
                    }
                }
            }

            return result;
        }
    }
}
