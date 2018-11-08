package LeetCode;

/**
 * Write a function that takes a string as input and returns the string reversed.
 * <p>
 * Example 1:
 * <p>
 * Input: "hello"
 * Output: "olleh"
 * Example 2:
 * <p>
 * Input: "A man, a plan, a canal: Panama"
 * Output: "amanaP :lanac a ,nalp a ,nam A"
 */

public class ReverseString {

    /**
     * new an array and reverse to store.
     */
    public String reverseString1(String s) {
        char[] res = new char[s.length()];
        for (int i = 0; i < s.length(); i ++) {
            res[i] = s.charAt(s.length() - i - 1);
        }
        return String.valueOf(res);
    }


    /**
     * using two pointers.
     * O(n/2)
     */
    public String reverseString(String s) {
        char[] res = s.toCharArray();
        char tmp;
        int l = 0;
        int r = res.length - 1;
        while (l < r) {
            tmp = res[l];
            res[l++] = res[r];
            res[r--] = tmp;
        }
        return String.valueOf(res);
    }


    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        String s = "hello";
        System.out.println(rs.reverseString(s));
    }
}
