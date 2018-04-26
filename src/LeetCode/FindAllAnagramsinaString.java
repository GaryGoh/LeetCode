package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 *
 *
 */
public class FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p) {
        int head = 0;
        int tail = p.length();
        boolean anagram = false;
        List<Integer> res = new ArrayList();

        for (; head < s.length() && tail <= s.length(); head ++, tail ++) {
            anagram = true;
            List<String> pattern = new ArrayList(Arrays.asList(p.split("")));
            String cur;
            for (int j = head; j < tail; j ++) {
                if (!pattern.contains(cur = s.substring(j,j + 1))) {
                    anagram = false;
                    break;
                } else {
                    pattern.remove(cur);
                }
            }
            if (anagram) {
                res.add(head);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindAllAnagramsinaString f = new FindAllAnagramsinaString();
        String s = "";
        String p = "";
        System.out.println(f.findAnagrams(s, p));
    }
}
