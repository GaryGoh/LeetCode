package LeetCode;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 Example:

 Given array nums = [-1, 2, 1, -4], and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    /**
     * 1. sort the array.
     * 2. constrain a value and use 2 pointers to check
     *      if (diff > new diff) <- update the res and diff
     *  3. if sum < target, left ++, else right --
     */
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[3];
        int diff = Math.abs(res - target);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i ++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r] + nums[i];
                int newDiff = Math.abs(sum - target);
                if (diff > newDiff) {
                    res = sum;
                    diff = newDiff;
                }
                if (sum > target) {
                    r --;
                } else if (sum < target){
                    l ++;
                } else {
                    return target;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] i = {-1, 2, 1, -4};
        int k = 1;
        ThreeSumClosest t = new ThreeSumClosest();
        System.out.println(t.threeSumClosest(i, k));
    }
}
