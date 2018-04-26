package google;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by mgao on 2018/4/4.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        // check the edge cases
        if (nums.length < 2) {	return nums.length;}
        LinkedList<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toCollection(LinkedList::new));
        Collections.sort(list);
        System.out.println(list);
        Integer e, cur;
        int maxLength = 1;
        int res = 1;
        cur = list.poll();

        while ((e = list.poll()) != null) {
            if (Math.abs(e - cur) == 1) {
                maxLength ++;
            } else if (Math.abs(e - cur) > 1){
                maxLength = 1;
            }
            if (maxLength > res){
                res = maxLength;
            }
            cur = e;
        }
        return res;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence l = new LongestConsecutiveSequence();
        int[] t = {1,2,0,1};
//        int[] t = {9,1,4,7,3,0,5,8,6};

        System.out.println(l.longestConsecutive(t));
    }
}
