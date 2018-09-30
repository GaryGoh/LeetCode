package LeetCode;

import java.util.Arrays;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [3,1,3,4,2]
 * Output: 3
 * Note:
 * <p>
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */

public class FindtheDuplicateNumber {
    /**
     * 1. sort the array
     * 2. compare the cur and pre, if ==, then return
     */
    public int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i - 1] == nums[i]) {
                return nums[i];
            }
        }
        return -1;
    }

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[slow];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int fast2 = 0;
        while (slow != fast2) {
            slow = nums[slow];
            fast2 = nums[fast2];
        }
        return slow;
    }


    public static void main(String[] args) {
        FindtheDuplicateNumber f = new FindtheDuplicateNumber();
//        int[] i = {3,1,3,4,2};
//        int[] i = {1,3,4,2,2};
        int[] i = {4,6,5,1,3,2,5,7};
        System.out.println(f.findDuplicate(i));
    }
}
