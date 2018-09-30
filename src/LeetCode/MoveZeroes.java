package LeetCode;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * <p>
 * <p>
 * 1. loop the array, if 0, then move right
 * 2. if right is 0, give the head and tail to record the index of 0s
 * move the next non-0 to tail, and head ++, tail ++
 * <p>
 * <p>
 * 1. prior:
 * - 0
 * - non-0
 * 2. cur:
 * - 0
 * - non-0
 */

public class MoveZeroes {
    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        Integer head, tail;
        head = (nums[0] == 0) ? 0 : null;
        tail = head;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                head = i;
                if (tail == null && nums[i - 1] != 0) {
                    tail = i;
                }
            } else {
                if (tail != null) {
                    swap(nums, tail, i);
                    if (head.equals(tail)) {
                        head = i;
                        tail = i;
                    } else {
                        tail ++;
                        head = i;
                    }
                }
            }
        }
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int tail = 0;
        while (nums[tail] != 0) tail ++;
        for (int i = tail + 1; i < nums.length; i ++) {
            if (nums[i] != 0) {
                swap(nums, i, tail);
                tail ++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        MoveZeroes m = new MoveZeroes();
        int[] i = {0, 1, 0, 0, 3,0,12};
        m.moveZeroes(i);
        System.out.println(Arrays.toString(i));
    }
}
