package google.FindAllNumbersDisappearedinanArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mgao on 2018/4/3.
 */
public class FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList();

        // initial res with non-duplicate array
        for (int i = 0; i < nums.length; i ++) {
            res.add(i + 1);
        }

        // set all index of elements in nums as -1
        for (int i = 0; i < nums.length; i ++) {
            res.set(nums[i] - 1, -1);
        }
        return res.stream().filter(r -> r > 0).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        FindAllNumbersDisappearedinanArray f = new FindAllNumbersDisappearedinanArray();
        int[] t = {4,3,2,7,8,2,3,1};
        System.out.println(f.findDisappearedNumbers(t));
    }
}
