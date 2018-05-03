package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * <p>
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * <p>
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 * <p>
 * Note:
 * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 * <p>
 * Follow up:
 * Could you solve it in linear time?
 */


public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k <= 1) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int i = 0; i < k; i ++) {
            queue.offer(nums[i]);
        }
        res[index++] = queue.peek();
        for (int i = k; i < nums.length; i ++) {
            queue.remove(nums[i - k]);
            queue.offer(nums[i]);
            res[index++] = queue.peek();
        }
        return res;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum s = new SlidingWindowMaximum();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(s.maxSlidingWindow(nums, k)));
    }
}
