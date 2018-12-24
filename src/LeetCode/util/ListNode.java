package LeetCode.util;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode head = this;
        while (head != null) {
            sb.append(head.val + " -> ");
            head = head.next;
        }
        sb.setLength(sb.length() - 4);
        return sb.toString();
    }
}
