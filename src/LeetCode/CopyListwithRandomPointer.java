package LeetCode;

import LeetCode.util.RandomListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
        res.random = (head.random == null) ? null : map.get(head.random);
        return res;
    }

    public static void main(String[] args) {
//        RandomListNode n1 = new RandomListNode(-1);
//        RandomListNode n2 = new RandomListNode(-2);
//        n1.random = n2;
//        n1.next = n2;
//        n2.random = n1;
//
//        CopyListwithRandomPointer c = new CopyListwithRandomPointer();
//        RandomListNode res = c.copyRandomList(n1);
//        while (res != null) {
//            System.out.print(res.label + ",");
//            res = res.next;
//        }

        CopyListwithRandomPointer c = new CopyListwithRandomPointer();
//        RandomListNode n1 = new RandomListNode(1);
//        RandomListNode n2 = new RandomListNode(2);
//        RandomListNode n3 = new RandomListNode(3);
//
//        n1.next = n2;
//        n1.random = n1;
//        n2.next = n3;
//        n2.random = n3;
//        n3.random = n3;
//


        HashMap<Double, Double> map = new HashMap();
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode head = n1;
        Random r = new Random();
        for (int i = 0; i < 8000; i ++) {
            RandomListNode next = new RandomListNode(r.nextInt(9999) - 1);
            n1.next = next;
            n1 = next;
        }

        for (int i = 0; i < 20; i ++) {
            RandomListNode res = c.copyRandomList(head);
            System.out.println(res);
        }
//        while (res != null) {
//            System.out.println("Lable: " + res.label);
//            if (res.next != null) {
//                System.out.println("Next: " + res.next.label);
//            }
//            if (res.random != null) {
//                System.out.println("Random: " + res.random.label);
//            }
//            res = res.next;
//            System.out.println("-----------------------------");
//        }
    }
}
