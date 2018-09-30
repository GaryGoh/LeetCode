package LeetCode;


import java.util.ArrayList;
import java.util.List;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * <p>
 * Example:
 * <p>
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 */

public class MovingAverage {

    /**
     * Initialize your data structure here.
     */
    int[] buffer;
    int size;
    int offset;
    double sum;

    public MovingAverage(int size) {
        this.buffer = new int[size];
        this.size = 0;
        this.offset = 0;
        this.sum = 0.0;
    }

    public double next(int val) {
        if (size < buffer.length) {
            size ++;
        }
        sum -= buffer[offset];
        buffer[offset] = val;
        sum += val;
        offset = (offset + 1) % buffer.length;
        return sum / size;
    }

    //    public double next(int val) {
//        queue.add(val);
//        int size = queue.size();
//        if (queue.size() > this.size) {
//            queue = queue.subList(queue.size() - this.size, queue.size());
//            size = this.size;
//        }
//        double sum = queue.stream().reduce(0, (x, y) -> x + y);
//        return sum / size;
//    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));

    }
}
