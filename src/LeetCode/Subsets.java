package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0 || nums == null) {
            return res;
        }
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, 0, new boolean[nums.length]);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> curRes, int[] nums, int index, boolean[] used) {
//        if (index >= nums.length) {
//            return;
//        }
        if (curRes.size() <= nums.length) {
            res.add(new ArrayList<>(curRes));
        }

//        if (!used[index]) {
//            if (index != 0 && nums[index] == nums[index - 1] && !used[index - 1]) return;
//            curRes.add(nums[index]);
//            used[index] = true;
//            helper(res, curRes, nums, index + 1, used);
//            curRes.remove(curRes.size() - 1);
//            used[index] = false;
//            helper(res, curRes, nums, index + 1, used);
//        }

        for (int i = index; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && !used[i - 1] && nums[i] == nums[i - 1]) {
                continue;
            }
            curRes.add(nums[i]);
            used[i] = true;
            helper(res, curRes, nums, i + 1, used);
            curRes.remove(curRes.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Subsets s = new Subsets();
        int nums[] = {1, 2, 2};
        System.out.println(s.subsets(nums));
    }
}
