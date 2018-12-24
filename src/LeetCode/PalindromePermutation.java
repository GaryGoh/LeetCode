package LeetCode;


import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: "code"
 * Output: false
 * Example 2:
 * <p>
 * Input: "aab"
 * Output: true
 * Example 3:
 * <p>
 * Input: "carerac"
 * Output: true
 *
 * 1. check if each element only occur even number of times.
 * 2. at most 1 element can occur the odd number of times
 *
 * 1. hashmap to store the element.
 * 2. check the occurrences of each element
 * 3. maxOdd = 0, if loop to end, maxOdd > 1 then return false;
 */

public class PalindromePermutation {
    public boolean canPermutePalindrome1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxOdd = 0;
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                int times = map.get(c);
                // if even then maxOdd + 1, -1 otherwise;
                if (times % 2 == 0) {
                    maxOdd ++;
                } else {
                    maxOdd --;
                }
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
                maxOdd ++;
            }
        }
        return maxOdd < 2;
    }


    /**
     * how to improve?
     *
     * instead using hashmap, using array, with length of 128.
     * Because ASCII code only have 128 operators
     *
     * to check if the permucation of palindrome, can use the same strategy of above.
     *
     * loop s.toCharArray(), and store to 128 array; if array-> value % 2 == 0, maxOdd +1, -1 otherwise.
     */
    public boolean canPermutePalindrome(String s) {
        int[] table = new int[128];
        int maxOdd = 0;
        for (char c : s.toCharArray()) {
            if (table[c] % 2 == 0) {
                maxOdd ++;
            } else {
                maxOdd --;
            }
            table[c] ++;
        }
        return maxOdd < 2;
    }

    public static void main(String[] args) {
        PalindromePermutation p = new PalindromePermutation();
        String s1 = "code";
        String s2 = "aab";
        String s3 = "carerac";
        Assert.assertFalse(p.canPermutePalindrome(s1));
        Assert.assertTrue(p.canPermutePalindrome(s2));
        Assert.assertTrue(p.canPermutePalindrome(s3));

    }
}
