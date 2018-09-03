package LeetCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Solve it without division and in O(n).
 * <p>
 * For example, given [1,2,3,4], return [24,12,8,6].
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */


public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i <nums.length; i ++) {
            res[i] = nums[i - 1] * res[i - 1];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i --) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        ProductofArrayExceptSelf p = new ProductofArrayExceptSelf();
        int[] n = {1,2,3,4};
        System.out.println(Arrays.toString(p.productExceptSelf(n)));
    }
}
