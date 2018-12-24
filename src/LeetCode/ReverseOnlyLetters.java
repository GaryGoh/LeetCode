package LeetCode;

import org.junit.Assert;

/**
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "ab-cd"
 * Output: "dc-ba"
 * Example 2:
 * <p>
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * Example 3:
 * <p>
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 *
 *
 * use two pointer, head and tail both locate to the char letter, then swap them
 * if meet any non-char letter, then move forward to middle point.
 *
 * corner case:
 * 1. null, "" -> return S
 * 2. all non-char, -----   -> if head >= tail, return
 */

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }

        int head = 0;
        int tail = S.length() - 1;
        char[] cs = S.toCharArray();

        while (head < tail) {
            while (!isCharLetter(cs[head]) && head < tail) {
                head ++;
            }

            while (!isCharLetter(cs[tail]) && head < tail) {
                tail --;
            }

            if (head >= tail) {
                break;
            }
            swap(cs, head, tail);
            head++;
            tail--;
        }
        return String.valueOf(cs);
    }

    private boolean isCharLetter(char c) {
        if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
            return true;
        }
        return false;
    }

    private void swap(char[] cs, int a, int b) {
        char tmp = cs[a];
        cs[a] = cs[b];
        cs[b] = tmp;
    }

    public static void main(String[] args) {
        ReverseOnlyLetters r = new ReverseOnlyLetters();
        String s1 = "ab-cd";
        Assert.assertEquals("dc-ba", r.reverseOnlyLetters(s1));

        String s2 = "a-bC-dEf-ghIj";
        Assert.assertEquals("j-Ih-gfE-dCba", r.reverseOnlyLetters(s2));

        String s3 = "Test1ng-Leet=code-Q!";
        Assert.assertEquals("Qedo1ct-eeLg=ntse-T!", r.reverseOnlyLetters(s3));

        System.out.println(r.reverseOnlyLetters("7_28]"));
    }
}
