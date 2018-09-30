package LeetCode;


import LeetCode.util.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 */

public class MergeIntervals {

    /**
     * 1. sort the list by the start time.
     * 2. merge if cur.start < pre.end
     *     else idx ++
     */

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null) {
            return res;
        }

        if (intervals.size() < 2) {
            return intervals;
        }

        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        Interval pre = intervals.get(0);
        for (int i = 0; i < intervals.size(); i ++) {
            Interval cur = intervals.get(i);
            if (cur.start <= pre.end) {
                pre.end = Math.max(pre.end, cur.end);
            } else {
                res.add(pre);
                pre = cur;
            }
        }
        res.add(pre);
        return res;
    }

    public static void main(String[] args) {
        MergeIntervals m = new MergeIntervals();
        Interval i1 = new Interval(1, 3);
        Interval i2 = new Interval(2, 6);
        Interval i3 = new Interval(8, 10);
        Interval i4 = new Interval(15, 18);

//        Interval i1 = new Interval(1, 4);
//        Interval i2 = new Interval(2, 3);
        List<Interval> is = new ArrayList();
        is.add(i1);
        is.add(i2);
        is.add(i3);
        is.add(i4);

        List<Interval> res = m.merge(is);
        for (Interval i : res) {
            System.out.println("start:" + i.start + " -- " + "end: " + i.end);
        }
    }
}
