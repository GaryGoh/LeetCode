package LeetCode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 * <p>
 * Each element in the result must be unique.
 * The result can be in any order.
 */


public class IntersectionofTwoArrays {
    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet();
        HashSet<Integer> tmp = IntStream.of(nums1).boxed().collect(Collectors.toCollection(HashSet::new));
        for (int i : nums2) {
            if (tmp.contains(i)) {
                res.add(i);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        int max = Integer.MIN_VALUE;
        int idx = 0;

        for (int i : nums1) {
            if (i > max) max = i;
        }

        for (int i : nums2) {
            if (i > max) max = i;
        }

        int[] track = new int[max + 1];
        for (int i : nums1) {
            if (track[i] == 0) {
                track[i] ++;
            }
        }

        for (int i : nums2) {
            if (track[i] == 1) {
                track[i] ++;
                nums1[idx++] = i;
            }
        }
        return Arrays.copyOf(nums1, idx);
    }

    public static void main(String[] args) {
        int[] i1 = {4,7,9,7,6,7};
        int[] i2 = {5,0,0,6,1,6,2,2,4};

        IntersectionofTwoArrays in = new IntersectionofTwoArrays();
        int[] res = in.intersection(i1, i2);
        System.out.println(Arrays.toString(res));
    }
}
