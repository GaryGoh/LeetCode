package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * Note:
 * <p>
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */

public class SingleNumberIII {

    /**
     * using hashmap to store the occurence, and store the val == 1 to res;
     */
    public int[] singleNumber1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new int[]{};
        }
        int[] res = new int[2];
        int idx = 0;
        Map<Integer, Integer> track = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = track.getOrDefault(nums[i], 0);
            track.put(nums[i], val + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.get(nums[i]) == 1) {
                res[idx++] = nums[i];
            }
        }
        return res;
    }


    /**
     * 1. xor to cal the val, which is the different bits in of 2 values.
     * 2. find a bit and xor the val, to get 1 of the 2 values.
     * <p>
     * <p>
     * 合并：A | B
     * 交集：A & B
     * 减法：A & ~B
     * 取反：ALL_BITS ^ A or ~A
     * 设置某一位为1：A |= 1 << bit
     * 清除某一位为0：A &= ~(1 << bit)
     * 判断某一位是否为1：(A & 1 << bit) != 0
     * 抽取最后一位bit位：A&-A or A&~(A-1) or x^(x&(x-1))
     * 清除最后一位bit位：A & (A-1)
     * Get all 1-bits ~0 ????
     * <p>
     * 作者：我是浪子宕桑旺波
     * 链接：https://www.jianshu.com/p/7e00102bf8ad
     * 來源：简书
     * 简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
     */
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int val = 0;
        for (int n : nums) {
            val ^= n;
        }

        System.out.println(-val);
        int mask = val & -val; //???
//        while (true) {
//            if ((mask & val) == 1) {
//                break;
//            }
//            mask <<= 1;
//        }
        for (int n : nums) {
            if ((n & mask) == 0) {
                res[0] ^= n;
            } else {
                res[1] ^= n;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] i = {1,2,1,3,2,5};
        int[] i = {2, 1, 2, 3, 4, 1};
        SingleNumberIII s = new SingleNumberIII();
        System.out.println(Arrays.toString(s.singleNumber(i)));
    }
}
