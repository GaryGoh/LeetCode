package LeetCode;


import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * <p>
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * <p>
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * <p>
 * Example:
 * <p>
 * Input:
 * "abccccdd"
 * <p>
 * Output:
 * 7
 * <p>
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * <p>
 * <p>
 * To find the longest palindrome from the string s, we can only reduce the characters that has odd times of occurrences.
 * And keep the c of longest odd times of occurrences, then sum up the even occurrences.
 * <p>
 * 1. use hashmap or 128 arry
 * 2. sum up the occurrences
 * 3. if the occurrences is odd numbers, then get the max one.
 * 4. sum up all even occurrences.
 * <p>
 * corner case:
 * 1. only 1 even
 * 2. only 1 odd
 * 3. even times of odd -> aaabbb
 */

public class LongestPalindrome {
    /**
     * HashMap solution
     */
    public int longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            int value;
            if (map.containsKey(c)) {
                value = map.get(c) / 2 * 2;
                res += value;
                if (res % 2 == 0 && map.get(c) % 2 == 1) {
                    res++;
                }
                map.remove(c);
            }
        }
        return res;
    }


    /**
     * how to improve it
     * <p>
     * use 128 array instead of hashmap
     */
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] map = new int[128];
        int res = 0;

        for (char c : s.toCharArray()) {
            map[c]++;
        }

        for (int i = 0; i < 128; i++) {
            int val = map[i] / 2 * 2;
            res += val;
            if (res % 2 == 0 && map[i] % 2 != 0) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        String s = "acbccdcd";
        Assert.assertEquals(7, l.longestPalindrome(s));

        String s1 = "ccc";
        Assert.assertEquals(3, l.longestPalindrome(s1));

        String s2 = "bb";
        Assert.assertEquals(2, l.longestPalindrome(s2));

//        String s3 = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
//        Assert.assertEquals(983, l.longestPalindrome(s3));

        String s4 = "wartestinwhether";
        String s41 = "wwarrinhheeesttt";
        Assert.assertEquals(11, l.longestPalindrome(s41));

    }

}
