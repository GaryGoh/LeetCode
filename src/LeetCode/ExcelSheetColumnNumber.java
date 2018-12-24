package LeetCode;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * Example 1:
 * <p>
 * Input: "A"
 * Output: 1
 * Example 2:
 * <p>
 * Input: "AB"
 * Output: 28
 * Example 3:
 * <p>
 * Input: "ZY"
 * Output: 701
 *
 * questions:
 * 1. how long of the String, would the String convert to int be overflow? > 2^31 - 1?
 *      if so what would be return? 0, - 1 or 2^31 - 1?
 * 2. case sensitive?
 *
 * corner case:
 * 1. s == null or length == 0; => 0
 * 2. the converted value over than 2^31 - 1;
 *
 * algorithm:
 * 1. traverse and calculat from bottom, 1 digit * (26 * i), index = len - 1 - i;
 * 2. the digit value = s.char - 'A' + 1;
 */


public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        long res = 0;
        for (int i = 0; i < len; i ++) {
            int val = s.charAt(len - 1 - i) - 'A' + 1;
            double digit = Math.pow(26, i);
            res += val * digit;
        }

        if (res > Integer.MAX_VALUE) {
            return -1;
        } else {
            return (int)res;
        }
    }
}
