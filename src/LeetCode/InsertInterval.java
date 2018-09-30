package LeetCode;

import LeetCode.util.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 * <p>
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */

public class InsertInterval {

    /**
     * 1. looping the list until cur.start < pre.end && post.end > cur.end
     *       if cur.end > post.start, -> pre.start - post.end
     *
     *  2. if List is null or size == 0, return newInterval
     *  3. if newInterval == null, return intervals
     *  4. if both null, return []
     *
     *  [1, 3] , [6, 9]
     *    [2,  5]
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();

        if ((intervals == null || intervals.size() == 0) && newInterval != null) {
            res.add(newInterval);
            return res;
        }

        if (newInterval == null && intervals != null) {
            return intervals;
        }

        if (newInterval == null && intervals == null) {
            return res;
        }

        int idx = 0;
        while (idx < intervals.size() && newInterval.start > intervals.get(idx).end) {
            res.add(intervals.get(idx++));
        }

        while(idx < intervals.size() && newInterval.end >= intervals.get(idx).start) {
            newInterval.start = Math.min(newInterval.start, intervals.get(idx).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(idx).end);
            idx ++;
        }
        res.add(newInterval);

        while(idx < intervals.size()) {
            res.add(intervals.get(idx++));
        }
        return res;
    }

    public static void main(String[] args) {
        InsertInterval i = new InsertInterval();
        Interval i1 = new Interval(1, 5);
//        Interval i2 = new Interval(6, 9);
        Interval i3 = new Interval(6, 8);
//        Interval i4 = new Interval(15, 18);

        List<Interval> is = new ArrayList<>();
        is.add(i1);
//        is.add(i2);

        is = i.insert(is, i3);
        for (Interval ii : is) {
            System.out.println("start:" + ii.start + " -- " + "end: " + ii.end);
        }
    }
}
