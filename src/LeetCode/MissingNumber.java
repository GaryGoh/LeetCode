package LeetCode;


import java.util.Arrays;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */

public class MissingNumber {
    /**
     * As the range is from 1..n; and the missing number is replaced by 0.
     * So init the res as 0, and xor the nums[i] and i, the duplicate ones is 0, and the missing one (i ^ nums[i] = 0 ^ i = i)
     *
     * return the res when the loop is done.
     */
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i] ^ (i + 1);
        }
        return res;
    }
}
