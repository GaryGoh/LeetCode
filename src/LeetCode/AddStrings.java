package LeetCode;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * <p>
 * questions:
 * 1.???
 * <p>
 * corner case:
 * 1. num1 == null or ""-> return num2
 * 2. num2 == null or "" -> return num1
 * 3. the first digit has a carry, so the length of res is num1.length + num2.length + 1
 * 4. num1.length != num2.length, just add the rest values to res
 * <p>
 * algorithm
 * 1. adding from last element of the string arrays.
 * 2. if more than 10, then current digit = cur - 10, and carry = 1
 * 3. cur = 2 arrays.current bottom + carry.
 * 4. using index, instead of substring, better performance
 */

public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;
        int carry = 0;
        char c1;
        char c2;

        while (idx1 >= 0 || idx2 >= 0) {
            if (idx1 >= 0) {
                c1 = num1.charAt(idx1--);
            } else {
                c1 = '0';
            }

            if (idx2 >= 0) {
                c2 = num2.charAt(idx2--);
            } else {
                c2 = '0';
            }

            int cur = c1 + c2 + carry - '0';
            if (cur > '9') {
                carry = 1;
                cur -= '9' + 1 - '0';
            } else {
                carry = 0;
            }
            res.insert(0, (char) cur);
        }
        if (carry > 0) {
            res.insert(0, '1');
        }
        return res.toString();
    }

    public static void main(String[] args) {
        AddStrings a = new AddStrings();
        String num1 = "125";
        String num2 = "77";
        System.out.println(a.addStrings(num1, num2));
    }
}
