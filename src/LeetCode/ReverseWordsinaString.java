package LeetCode;

/**
 * Given an input string, reverse the string word by word.
 * <p>
 * Example:
 * <p>
 * Input: "the sky is blue",
 * Output: "blue is sky the".
 * Note:
 * <p>
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 * Follow up: For C programmers, try to solve it in-place in O(1) space.
 *
 * questions.
 * how if " " handle? return  " " or "";
 *
 */

public class ReverseWordsinaString {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        String[] ss = s.split(" ");
        for (int i = ss.length - 1; i >= 0; i --) {
            if (ss[i].length() > 0) {
                sb.append(ss[i]);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = " 1";
        ReverseWordsinaString r = new ReverseWordsinaString();
        System.out.println(r.reverseWords(s));
    }
}
