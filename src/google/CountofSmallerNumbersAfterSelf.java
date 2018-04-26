package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mgao on 2018/4/4.
 */
public class CountofSmallerNumbersAfterSelf {
    public List<Integer> countSmaller1(int[] nums) {
        if (nums.length < 1) { return new ArrayList();}
        int len = nums.length;
        int prev = nums[len - 1];
        nums[len - 1] = 0;

        for (int i = len - 2; i >= 0; i --) {
            if (nums[i] > prev) {
                prev = nums[i];
                nums[i] = nums[i + 1] + 1;
            } else {
                prev = nums[i];
                nums[i] = nums[i + 1];
            }
        }
        return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }

    public List<Integer> countSmaller2(int[] nums) {
        List<Integer> res = new ArrayList();
        if (nums.length < 1) { return new ArrayList();}
        for (int i = 0; i < nums.length - 1; i ++) {
            int r = 0;
            for (int j = i + 1; j < nums.length; j ++) {
                if (nums[i] > nums[j]) {
                    r++;
                }
            }
            res.add(r);
        }
        res.add(0);
        return res;
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> sortedList = new ArrayList();
        List<Integer> res = new ArrayList();
        for (int i = nums.length - 1; i >= 0; i --) {
            int index = findIndex(sortedList , nums[i]);
            res.add(index);
            sortedList.add(index, nums[i]);
        }
        Collections.reverse(res);
        return res;
    }

    private int findIndex(List<Integer> list, int target) {
        int len, mid;
        if ((len = list.size()) < 1) { return len;}
        int start = 0;
        int end = len - 1;
        if (list.get(start) > target) {return 0;}
        if (list.get(end) < target) {return len;}
        for (mid = (start + end) / 2; start < end; ) {
            if (list.get(mid) == target) {
                return mid;
            }
            else if (list.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return (start > end)? len: end;
    }



    public static void main(String[] args) {
        CountofSmallerNumbersAfterSelf c = new CountofSmallerNumbersAfterSelf();
        int[] t = {-1, -1};
        System.out.println(c.countSmaller(t));
    }
}
