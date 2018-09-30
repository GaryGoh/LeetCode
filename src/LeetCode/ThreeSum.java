package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        // O(nlogn)
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            findThreeSum(res, nums, i + 1, nums.length - 1, nums[i]);
        }
        return res;
    }

    private void findThreeSum(List<List<Integer>> res, int[] nums, int left, int right, int target) {
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum + target == 0) {
                List<Integer> tmp = new ArrayList();
                tmp.add(nums[left]);
                tmp.add(nums[right]);
                tmp.add(target);
                res.add(tmp);
                while (left < right && nums[left] == nums[left + 1]) left++;
                while (left < right && nums[right] == nums[right - 1]) right--;
                left++;
                right--;
            }
            else if (sum + target > 0) {
                right --;
            } else {
                left ++;
            }
        }
    }

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        int[] i = {-1, 0, 1, 2, -1, -4};
        System.out.println(t.threeSum(i));
    }
}
