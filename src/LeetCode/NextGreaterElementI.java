package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * <p>
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
 * <p>
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 * For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 * For number 1 in the first array, the next greater number for it in the second array is 3.
 * For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 * For number 2 in the first array, the next greater number for it in the second array is 3.
 * For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 * Note:
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 * <p>
 * <p>
 * 1. use a stack to maintain the search:
 * 2. if cur > pre, then keep pushing
 * 3. if cur < pre, then use a map to store the next greater element. And pull the element
 */

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        HashMap<Integer, Integer> table = new HashMap();
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                table.put(nums2[stack.pop()], nums2[i]);
            }
            stack.push(i);
        }

        for (int i = 0; i < nums1.length; i++) {
            if (table.containsKey(nums1[i])) {
                nums1[i] = table.get(nums1[i]);
            } else {
                nums1[i] = -1;
            }
        }
        return nums1;
    }

    public static void main(String[] args) {
        NextGreaterElementI n = new NextGreaterElementI();
        int[] i1 = {1,3,5,2,4};
        int[] i2 = {6,5,4,3,2,1,7};
        long t1 = System.currentTimeMillis();
        System.out.println(Arrays.toString(n.nextGreaterElement(i1, i2)));
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }
}
