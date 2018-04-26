package LeetCode;

import java.util.Arrays;

/**
 * Created by mgao on 2018/4/16.
 */
public class TwoSum2InputArrayIsSorted {
    /**
     * Since this is sorted list, so we can start linear searching from the boundary.
     * if sum < target, then head will need to move right;
     * if sum > target, then tail will need to move left;
     *
     * when left = right, that means no result is matched.
     *
     * Note, if the question say, element can be re-used, then it also needs to check left = right.
     */
    public int[] twoSum(int[] numbers, int target) {
        int head = 0;
        int tail = numbers.length - 1;
        int r = Integer.MIN_VALUE;
        while (head < tail && (r = numbers[head] + numbers[tail]) != target) {
            if (r < target) head ++;
            if (r > target) tail --;
        }
        return (r == target)? new int[]{head + 1, tail + 1} : new int[]{0, 0};
    }

    /**
     * Using binary searching to check v = target- cur, where cur is current element that is visiting.
     */
    public int[] twoSum1(int[] numbers, int target) {
        int[] res = new int[2];
        int bsRes;
        for (int i = 0; i < numbers.length; i ++) {
            if ((bsRes = bs(numbers, 0, numbers.length - 1, target - numbers[i])) != -1 && bsRes != i) {
                res[0] = i + 1;
                res[1] = bsRes + 1;
                break;
            }
        }

        return res;
    }

    private int bs(int[] numbers, int left, int right, int target) {
        int mid = (left + right) / 2;
        if (left > right) {
            return -1;
        }
        if (target > numbers[mid]) {
            return bs(numbers, mid + 1, right, target);
        } else if (target < numbers[mid]) {
            return bs(numbers, left, mid - 1, target);
        } else {
            if (mid + 1 < numbers.length && numbers[mid] == numbers[mid + 1]) {
                mid ++;
            }
            return mid;
        }
    }

    public static void main(String[] args) {
        TwoSum2InputArrayIsSorted t = new TwoSum2InputArrayIsSorted();
        int[] n = {1,2,3,4,4,9,56,90};
//        int[] n = {2,3,4};
        System.out.println(Arrays.toString(t.twoSum(n, 8)));
    }
}
