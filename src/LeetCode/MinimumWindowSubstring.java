package LeetCode;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * Example:
 * <p>
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 * <p>
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 *
 */

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        // set up the character map and store the occurrence
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int from = 0;
        int len = t.length();
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if ((map[s.charAt(i)] --) > 0) {
                len--;
            }
            while (len == 0) {
                if (i - j + 1 < min) {
                    min = i - j + 1;
                    from = j;
                }
                if (++map[s.charAt(j++)] > 0) {
                    len ++;
                }
            }
        }
        return (min == Integer.MAX_VALUE) ? "" : s.substring(from, from + min);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        System.out.println(m.minWindow(s, t));
    }
}
