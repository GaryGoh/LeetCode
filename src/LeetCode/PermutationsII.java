package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        if (nums.length == 0 || nums == null) {
            return res;
        }
        nextPermutation(res, new ArrayList<>(), nums, used);
        return res;
    }

    private void nextPermutation(List<List<Integer>> res, List<Integer> curRes, int[] nums, boolean[] used) {
        if (curRes.size() == nums.length) {
            res.add(new ArrayList<Integer>(curRes));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            curRes.add(nums[i]);
            nextPermutation(res, curRes, nums, used);
            curRes.remove(curRes.size() - 1);
            used[i] = false;
        }
    }

    private void swap(int a, int b) {
        a ^= b;
        b ^= a;
        a ^= b;
    }

    public static void main(String[] args) {
        PermutationsII p = new PermutationsII();
        int[] n = {1, 1, 2};
        System.out.println(p.permuteUnique(n));
    }

}
