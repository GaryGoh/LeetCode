package LeetCode;

/**
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 *
 *
 * 题目是说反转每2k个字符中的前k个字符。
 */

public class ReverseStringII {
    public String reverseStr(String s, int k) {
        if (s.length() == 1) {
            return s;
        }
        char[] res = s.toCharArray();
        int i = 1;
        int start = 0;
        while (start < s.length()) {
            helper(res, start, k);
            start = (i++) * 2 * k;
        }
        return String.valueOf(res);
    }

    private void helper(char[] res, int start, int k) {
        int l = start;
        int r = Math.min(start + k - 1, res.length - 1);
        char tmp;
        while (l < r) {
            tmp = res[l];
            res[l++] = res[r];
            res[r--] = tmp;
        }
    }

    public static void main(String[] args) {
        ReverseStringII rs = new ReverseStringII();
        String s = "ab";
        System.out.println(rs.reverseStr(s, 3));
    }
}
