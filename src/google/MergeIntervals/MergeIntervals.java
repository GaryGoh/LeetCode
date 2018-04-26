package google.MergeIntervals;

import java.util.*;

/**
 * Created by mgao on 2018/3/8.
 */

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}


public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        LinkedList<Interval> res = new LinkedList();

        if (intervals.size() == 0) {
            return res;
        }

        intervals.sort((Interval a, Interval b) -> a.start - b.start);
        res.push(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            Interval prior= res.pop();
            Interval current = intervals.get(i);

            // combine overlapping intervals
            if (prior.end >= current .start) {
                res.push(new Interval(prior.start, (prior.end > current.end)? prior.end : current.end));
            } else {
                res.push(prior);
                res.push(current);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        List<Interval> t = new ArrayList<>();
//        t.add(new Interval(1,3));
//        t.add(new Interval(2,6));
//        t.add(new Interval(8,10));
//        t.add(new Interval(15,18));
        MergeIntervals m = new MergeIntervals();
        List<Interval> res = m.merge(t);
        for (Interval i : res) {
            System.out.print("[" + i.start + "," + i.end + "]");
        }
    }
}
