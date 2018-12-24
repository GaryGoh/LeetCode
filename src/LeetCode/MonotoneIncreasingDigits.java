package LeetCode;

import org.junit.Assert;

import java.util.Arrays;

/**
 * Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.
 * <p>
 * (Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)
 * <p>
 * Example 1:
 * Input: N = 10
 * Output: 9
 * Example 2:
 * Input: N = 1234
 * Output: 1234
 * Example 3:
 * Input: N = 332
 * Output: 299
 * Note: N is an integer in the range [0, 10^9].
 * <p>
 * <p>
 * questions:
 * ???
 * <p>
 * corner case:
 * 1. 0 -> 0
 * 2. 111 -> 111
 * 3. 1 -> 1
 * <p>
 * 2 3 2
 * (1) 2 2 2
 * (2) 2 9 2
 * (3) 2 9 9
 * <p>
 * 4 3 2
 * (1) 4 2 2
 * (2) 3 2 2
 * (3) 3 9 9
 * <p>
 * 4 2 3
 * (1) 3 2 3
 * (2) 3 9 9
 * <p>
 * <p>
 * 1 0
 * (1) 0 9
 * <p>
 * <p>
 * <p>
 * algorithm:
 * 1.
 */


public class MonotoneIncreasingDigits {

    /**
     * use math with O(1) space
     */
    public int monotoneIncreasingDigits1(int N) {
        int idx = -1;
        int len = Double.valueOf(Math.log10(N)).intValue() + 1;
        // back traverse and decrease the digits to monotone increase
        for (int i = 1; i < len; i++) {
            int digit = N % (int) Math.pow(10.0, (double) i) / (int) Math.pow(10.0, (double) i - 1);
            int preDigit = N % (int) Math.pow(10.0, (double) (i + 1)) / (int) Math.pow(10.0, (double) i);

            if (digit < preDigit) {
                idx = len - i + 1;
                N -= 1 * (int) Math.pow(10.0, (double)i);
            }
        }

        // traverse from the stop place, increase each of the following digit to 9
        for (; idx > 0 && idx <= len; idx ++) {
            int digit = N % (int) Math.pow(10.0, (double) len - idx + 1) / (int) Math.pow(10.0, (double) len - idx);
            int offset = 9 - digit;
            N += offset * (int) Math.pow(10.0, (double)(len - idx));

        }
        return N;
    }

    /**
     * use array with O(n) space
     */
    public int monotoneIncreasingDigits2(int N) {
        char[] ns = String.valueOf(N).toCharArray();
        int idx = ns.length;

        for (int i = ns.length - 1; i > 0; i --) {
            if (ns[i] < ns[i - 1]) {
                ns[i - 1]--;
                idx = i;
            }
        }
        Arrays.fill(ns, idx, ns.length,'9');
        return Integer.valueOf(String.valueOf(ns));
    }

    /**
     * use math with O(1) space
     */
    public int monotoneIncreasingDigits(int N) {
        int res = 0;
        return 0;
    }



    public static void main(String[] args) {
//        System.out.println(Double.valueOf(Math.log10(900)).intValue());
        MonotoneIncreasingDigits m = new MonotoneIncreasingDigits();

        int n4 = 20;
        Assert.assertEquals(19, m.monotoneIncreasingDigits(n4));

        int n = 423;
        Assert.assertEquals(399, m.monotoneIncreasingDigits(n));

        int n1 = 10;
        Assert.assertEquals(9, m.monotoneIncreasingDigits(n1));

        int n2 = 1234;
        Assert.assertEquals(1234, m.monotoneIncreasingDigits(n2));

        int n3 = 332;
        Assert.assertEquals(299, m.monotoneIncreasingDigits(n3));


    }
}
