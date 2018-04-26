package google.MaximumSubarray;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mgao on 2018/3/29.
 */
public class MaximumSubarray {
    public int maxSubArray1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] < nums[i - 1] + nums[i]) {
                nums[i] = nums[i - 1] + nums[i];
            }
        }
        return Arrays.stream(nums).max().getAsInt();
    }

//    public int maxSubArray(int[] nums) {
//        List<Integer> res = Arrays.stream(nums).map(a -> a * 2).collect(Collectors.toList());
////        return Arrays.stream(nums).max().getAsInt();
//        return res;
//    }

    public static void main(String[] args) {
        MaximumSubarray m = new MaximumSubarray();
        int[] i = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(m.maxSubArray1(i));
    }
}
