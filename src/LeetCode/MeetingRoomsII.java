package LeetCode;

import LeetCode.util.Interval;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 * <p>
 * Example 1:
 * <p>
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 *
 *
 *  0 5 15
 *  10 20 30
 * Example 2:
 * <p>
 * Input: [[7,10],[2,4]]
 * Output: 1
 */

public class MeetingRoomsII {

    /**
     * 1. new 2 arrays to store start and end, then sort
     * 2. compare start and end, if there is 1 overlap, then res ++; and move next end to check.
     *
     */
    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        int res = 0;

        for (int i = 0; i < intervals.length; i ++ ) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);
        int idx = 0;

        for (int i = 0; i < intervals.length; i ++) {
            if (ends[idx] > starts[i]) {
                res ++;
            } else {
                idx ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MeetingRoomsII m = new MeetingRoomsII();
        Interval i1 = new Interval(7, 10);
        Interval i2 = new Interval(2, 4);
        Interval[] is = {i1, i2};

        System.out.println(m.minMeetingRooms(is));
    }
}
