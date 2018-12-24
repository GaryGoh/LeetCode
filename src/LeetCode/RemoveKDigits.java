package LeetCode;


import org.junit.Assert;

import java.util.LinkedList;

/**
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 * <p>
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 * <p>
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 * <p>
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 * <p>
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * <p>
 * questions.
 * 1. how do we handle "000" -> "0"?
 * 2. how if there is a leading 0 at the result?
 * <p>
 * algorithm.
 * <p>
 * 1. if meet the peek (the first element of DSC sequence)
 * 1. use stack to maintain the result
 * if ( stack.top() > incoming element), stack.pop
 * <p>
 * 2. push element from the string num
 * <p>
 * 3. if the string is all ASC, then remove last element (pop)
 * <p>
 * 4. if needs to handle leading 0, then from bottom to check.
 */

public class RemoveKDigits {
    /**
     * This is using stack to maintain the result (linkedlist)
     */
    public String removeKdigits1(String num, int k) {
        LinkedList<Character> stack = new LinkedList();
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && (stack.peek() > num.charAt(i)) && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        // remove the last element if ASC
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char c = stack.removeLast();
            if (sb.length() != 0 || c != '0') {
                sb.append(c);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    /**
     * This is using array that play as stack to maintain the result
     * <p>
     * 1. array.len must be num.length - k
     * 2. main logic is same above, when array.last element > incoming element, replace it with the incoming one.
     * 3. if array.len > num.length - k, trim to k (this ensure the largest number is remove in ordered list)
     * 4. if array.len == 0, then it means there is no element in the array (have been remove all), return 0,
     * otherwise return array <- String
     */
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() <= k) {
            return "0";
        }
        int len = num.length() - k;
        int idx = 0;
        int offset = 0;
        char[] res = new char[num.length()];

        for (int i = 0; i < num.length() && len > 0; i++) {
            char cur = num.charAt(i);
            while (k > 0 && idx > 0 && res[idx - 1] > cur) {
                k--;
                idx--;
            }
            res[idx++] = cur;
        }
        for (int i = 0; i < res.length; i ++) {
            if (res[i] == '0') {
                offset++;
            } else {
                break;
            }
        }

        return len == offset? "0": String.valueOf(res, offset, idx - k - offset);
    }

    public static void main(String[] args) {
        RemoveKDigits r = new RemoveKDigits();
        String s = "1432219";
        int k = 3;
        Assert.assertEquals("1219", r.removeKdigits(s, k));

        String s1 = "10200";
        int k1 = 1;
        Assert.assertEquals("200", r.removeKdigits(s1, k1));

        String s2 = "10";
        int k2 = 2;
        Assert.assertEquals("0", r.removeKdigits(s2, k2));

        String s4 = "10";
        int k4 = 1;
        Assert.assertEquals("0", r.removeKdigits(s4, k4));

        String s3 = "1432239";
        int k3 = 3;
        Assert.assertEquals("1223", r.removeKdigits(s3, k3));
    }
}
