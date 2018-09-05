package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
 * <p>
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 * <p>
 * Input: S = "12345"
 * Output: ["12345"]
 * Note:
 * <p>
 * S will be a string with length at most 12.
 * S will consist only of letters or digits.
 */

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        helper(res, S.toCharArray(), 0);
        return res;
    }

    public void helper(List<String> res, char[] chars, int index) {
        if (index == chars.length) {
            String s = new String(chars);
            res.add(s);
            return;
        }
        helper(res, chars, index + 1);
        if (chars[index] >= 'a' && chars[index] <= 'z' || chars[index] >= 'A' && chars[index] <= 'Z') {
            chars[index] ^= 1 << 5;
            helper(res, chars, index + 1);
            chars[index] ^= 1 << 5;
        }
    }

    public static void main(String[] args) {
        LetterCasePermutation l = new LetterCasePermutation();
        String s = "";
        System.out.println(l.letterCasePermutation(s));
    }
}
