package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.

 Example:

 Input: [1,2,3]
 Output:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 */

public class Permutations {
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (nums.length == 0 || nums == null) {
//            return res;
//        }
//        helper(res, new ArrayList<>(), nums);
//        return res;
//    }
//
//    private void helper(List<List<Integer>> res, List<Integer> curRes, int[] nums) {
//        if (curRes.size() == nums.length) {
//            res.add(new ArrayList<>(curRes));
//            return;
//        }
//
//        for (int i = 0; i < nums.length; i ++) {
//            if (curRes.contains(nums[i])) {
//                continue;
//            }
//            curRes.add(nums[i]);
//            helper(res, curRes, nums);
//            curRes.remove(curRes.size() - 1);
//        }
//    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        if (nums.length == 0) {return list;}

        helper(nums, list, 0, nums.length - 1);
        return list;
    }

    private void helper(int[] nums, List<List<Integer>> list, int left, int right) {
        if (left == right) {
            List<Integer> arr = new ArrayList<Integer>();
            for (int i : nums) arr.add(i);
            list.add(arr);
            return;
        }

        for (int i = left; i <= right; i++) {
            swap(nums, left, i);
            helper(nums, list, left + 1, right);
            swap(nums, left, i);
        }
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l]  = nums[r];
        nums[r]  = temp;
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        int[] n = {1,2,3};
        System.out.println(p.permute(n));
    }
}
