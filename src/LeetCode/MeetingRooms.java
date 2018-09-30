package LeetCode;

import LeetCode.util.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 * <p>
 * Example 1:
 * <p>
 * Input: [[0,30],[5,10],[15,20]]
 * Output: false
 * Example 2:
 * <p>
 * Input: [[7,10],[2,4]]
 * Output: true
 */

public class MeetingRooms {

    /**
     * 1. sort the intervals by start time.
     * 2. if the start time > previous end time, return false.
     */

    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals.length < 2) {
            return true;
        }

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        for (int i = 1; i < intervals.length; i ++) {
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MeetingRooms m = new MeetingRooms();
        Interval i1 = new Interval(7, 10);
        Interval i2 = new Interval(2, 4);
        Interval[] is = {i1, i2};

        System.out.println(m.canAttendMeetings(is));

    }
}
