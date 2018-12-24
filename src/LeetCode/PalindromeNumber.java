package LeetCode;

import LeetCode.LocalTest.LeetCodeLocalTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * Output: true
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 * <p>
 * Coud you solve it without converting the integer to a string?
 *
 * question
 * how big of this integer?
 *
 * corner case.
 *
 * algorithm.
 * String:
 * 1. convert to String
 * 2. while (head != tail and head.index != tail.index) return false;
 *
 * non-String:
 * 1. adding digit from bottom
 *      digit = x % 10
 * 2. compare with x and res
 *
 * res = res * 10 + x % 10
 * x /= 10
 */


public class PalindromeNumber {
    public boolean isPalindrome1(int x) {
        char[] cs = String.valueOf(x).toCharArray();
        int tail = cs.length - 1;
        int head = 0;
        while (cs[head] == cs[tail] && head < tail) {
            head ++;
            tail --;
        }
        return head >= tail;
    }

    public boolean isPalindrome(int x) {
        int res = 0;
        int originX = x;
        while (x > 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res == originX;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        PalindromeNumber p = new PalindromeNumber();

        LeetCodeLocalTest<Integer> lt = new LeetCodeLocalTest<>(p, "isPalindrome", int.class, "isPalindrome1", int.class);
        List<Integer> testSet = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 10000; i ++) {
            testSet.add(-r.nextInt(Integer.MAX_VALUE));
            testSet.add(r.nextInt(Integer.MAX_VALUE));
        }

        long runTime = lt.runWithRuntime(testSet);
        System.out.println(runTime + "ms");
    }
}
