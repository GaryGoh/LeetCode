package LeetCode;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 *
 * corner case:
 *  1. null -> null, "" -> ""
 *  2. how long of the size of the input string. would it exceed to the size of memory?
 *
 */

public class ReverseWordsinaStringIII {
    /**
     *  1.split by " "
     *  2. reverse each element, add to string builder
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        String[] ss = s.split(" ");
        for (String se : ss) {
            char[] cs = se.toCharArray();
            reverse(cs);
            sb.append(cs);
            sb.append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    private void reverse(char[] cs) {
        int len = cs.length;
        char tmp;
        for(int i = 0; i < len / 2; i ++) {
            tmp = cs[i];
            cs[i] = cs[len - i - 1];
            cs[len - i - 1] = tmp;
        }
    }

    public static void main(String[] args) {
        ReverseWordsinaStringIII r = new ReverseWordsinaStringIII();
        String s = "Let's take LeetCode contest";
//        Collections.reverse(Arrays.asList(s.toCharArray()));
//        System.out.println(s);
        System.out.println(r.reverseWords(s));
    }
}
