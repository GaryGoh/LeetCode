package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
 * <p>
 * Example 1:
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 * Note: The length of given array won't exceed 10000.
 */

public class NextGreaterElementII {

    /**
     * 1. extend the input array
     * 2. use stack to find the next generater number, store the index
     * 3. map<index, index>
     */
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length];
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < nums.length * 2; i ++) {
            while (!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % nums.length];
            }
            if (i < nums.length) {
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            res[stack.pop()] = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        NextGreaterElementII n = new NextGreaterElementII();
//        int[] i = {100,1,11,1,120,111,123,1,-1,-100};
        int[] i = {1,2,1};

        System.out.println(Arrays.toString(n.nextGreaterElements(i)));
    }
}
