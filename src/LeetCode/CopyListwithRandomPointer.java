package LeetCode;

import LeetCode.util.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * <p>
 * Return a deep copy of the list.
 */

public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList1(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap();
        if (head == null) {
            return null;
        }
        RandomListNode cur = head;

        while (cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }

        cur = head;
        RandomListNode res = cur;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return res;
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap();
        return dfsCopy(head, map);
    }

    private RandomListNode dfsCopy(RandomListNode head, HashMap<RandomListNode, RandomListNode> map) {
        if (head == null) {
            return null;
        }

        RandomListNode res = new RandomListNode(head.label);
        map.put(head, res);
        res.next = dfsCopy(head.next, map);
        res.random = (head.random == null)? null : map.get(head.random);
        return res;
    }

    public static void main(String[] args) {
        RandomListNode n1 = new RandomListNode(-1);
        RandomListNode n2 = new RandomListNode(-2);
        n1.random = n2;
        n1.next = n2;
        n2.random = n1;

        CopyListwithRandomPointer c = new CopyListwithRandomPointer();
        RandomListNode res = c.copyRandomList(n1);
        while (res != null) {
            System.out.print(res.label + ",");
            res = res.next;
        }
    }
}
