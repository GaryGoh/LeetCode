package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

 Note: The input string may contain letters other than the parentheses ( and ).

 Example 1:

 Input: "()())()"
 Output: ["()()()", "(())()"]
 Example 2:

 Input: "(a)())()"
 Output: ["(a)()()", "(a())()"]
 Example 3:

 Input: ")("
 Output: [""]

 1. to check the parentheses are valid or not, using a stack to push the open brackets, and check the close brackets.
        a. if incoming is open , push to stack
        b. if incoming is close, poll the stack and place the pair to tmp string.
            b.1 if stack doesn't have matched bracket, append the tmp string to curRes string builder.
                b.1.2 empty tmp
                b.1.3 count the number of close in invalid list, if it reach to the threshold, then break and return.
        b. if incoming is non-parentheses, then store to non-paratheses tmp string, once find the valid parentheses, add it between the pair brackets.

 2. using the back tracking to list all possible results.
    stop condition <- when reach out to the threshold or index == s.length.
    constant back tracking
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        if (s.isEmpty() || s == null) {
            return res;
        }
        int threshold = getThreshold(s);
//        helper(res, new StringBuilder(), s.toCharArray(),stack, threshold, 0, 0);
        helper2(res, new StringBuilder(), s.toCharArray(), threshold, 0);
        return res;
    }

    private void helper(List<String> res, StringBuilder sb, char[] chars, Stack<Character> stack, int threshold, int curThresohld, int i) {
        if (curThresohld > threshold) {
            return;
        }

        if (i == chars.length - 1) {
            res.add(sb.toString());
            return;
        }

        char c = chars[i];
        StringBuilder tmpSb = new StringBuilder();
        if (c != ')') {
            stack.push(c);
            helper(res, sb, chars, stack, threshold, curThresohld, i + 1);
        } else {
            tmpSb.insert(0, c);
            while (!stack.isEmpty()) {
                char cur = stack.pop();
                if (cur != '('  && cur != ')') {
                    tmpSb.insert(0, cur);
                }
                if (cur == '(') {
                    tmpSb.insert(0,cur);
                    sb.append(tmpSb);
//                    sb.setLength(sb.length() - tmpSb.length());
                }
            }
            curThresohld ++;
            helper(res, sb, chars, stack, threshold, curThresohld, i + 1);
        }
    }

    private void helper2(List<String> res, StringBuilder sb, char[] chars, int threshold, int i) {
        if (sb.length() == chars.length) {
            if (isValidParentheses(sb.toString())) {
                res.add(sb.toString());
            }
            return;
        }

        sb.append(chars[i]);
        helper2(res, sb, chars, threshold, i + 1);
        if (!isValidParentheses(sb.toString())) {
            sb.setLength(sb.length() - 1);
            helper2(res, sb, chars, threshold, i + 1);
        }
    }

    private boolean isValidParentheses(String s) {
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                res ++;
            } else if (c == ')') {
                res --;
            }
            if (res < 0) {
                return false;
            }
        }
        return res == 0;
    }

    private int getThreshold(String s) {
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                res --;
            } else if (c == ')') {
                res ++;
            }
        }
        return Math.abs(res);
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses r = new RemoveInvalidParentheses();
        String s = "()())()";
        System.out.println(r.removeInvalidParentheses(s));
    }
}
