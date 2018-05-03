package LeetCode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.List;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * Example 2:
 * <p>
 * Input:
 * s = "wordgoodstudentgoodword",
 * words = ["word","student"]
 * Output: []
 */

public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> map = new HashMap();
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        int head, tail;
        int len = words.length;
        int slen = words[0].length();

        for (int i = 0; i < s.length() - len * slen; i ++) {

        }
        return null;
    }

    public static void main(String[] args) {
        SubstringwithConcatenationofAllWords s = new SubstringwithConcatenationofAllWords();
        String str = "barfoothefoobarman";
        String[] words = {"word","stu"};
        s.findSubstring(str, words);
    }
}
