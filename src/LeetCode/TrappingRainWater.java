package LeetCode;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * <p>
 * <p>
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */

public class TrappingRainWater {

    /**
     * slow-fast 2 pointers.
     * 1. use the lower one to cal the res,
     *  if (h.left > h.right):
     *      rightMax = max(rightMax, h.right);
     *      res += rightMax - h.right
     *      right --;
     *  else
     *      leftMax = max(leftMax, h.left);
     *      res += leftMax - h.left
     *
     *  loop util (left >= right)
     */
    public int trap(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {
            if (height[left] > height[right]) {
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right--];
            } else {
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left++];
            }
        }
        return res;
    }

    public int trap1(int[] height) {
        int res = 0;
        int len;
        List<Integer> helper = Arrays.stream(height).boxed().collect(Collectors.toList());
        while (helper.size() > 1) {
            while (helper.size() > 0 && helper.get(0) <= 0) {
                helper.remove(0);
            }

            while ((len = helper.size()) > 0 && helper.get(len - 1) <= 0) {
                helper.remove(len - 1);
            }
            helper = helper.stream().map(i -> i - 1).collect(Collectors.toList());
            res += helper.stream().filter(i -> i < 0).count();
        }
        return res;
    }

    public int trap2(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;

        while (left < right) {
            if (height[left] > height[right]) {
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right--];
            } else {
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();
        int[] n1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] n2 = {0, 2, 0};
        int[] n3 = {2, 0, 2};
        int[] n4 = {4, 2, 3};


//        List<Integer> helper = Arrays.stream(n).boxed().collect(Collectors.toList());
//        System.out.println(helper.get(0));
//        helper.remove(0);
//        System.out.println(helper.get(0));
//        System.out.println(t.trap(n));
        Assert.assertEquals(t.trap2(n1), t.trap(n1));
        Assert.assertEquals(t.trap2(n2), t.trap(n2));
        Assert.assertEquals(t.trap2(n3), t.trap(n3));
        Assert.assertEquals(t.trap2(n4), t.trap(n4));
    }
}
