package LeetCode;

import Practice.FindKthElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1 - 0 - 0 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * <p>
 * Output: 6
 * <p>
 * Explanation: Given three people living at (0,0), (0,4), and (2,2):
 * The point (0,2) is an ideal meeting point, as the total travel distance
 * of 2+2+2=6 is minimal. So return 6.
 */

public class BestMeetingPoint {
    public int minTotalDistance2(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        List<Integer> xs = new ArrayList<>();
        List<Integer> ys = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ys.add(i);
                }
            }
        }

        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1) {
                    xs.add(j);
                }
            }
        }

        return count2(ys) + count2(xs);
    }

    private int count2(List<Integer> ls) {
        int res = 0;
        int left = 0;
        int right = ls.size() - 1;
        while (left < right) {
            res += ls.get(right--) - ls.get(left ++);
        }
        return res;
    }


    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int[] xs = new int[grid[0].length];
        int[] ys = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    xs[j] ++;
                    ys[i] ++;
                }
            }
        }

        return count(ys) + count(xs);
    }

    private int count(int[] ls) {
        int res = 0;
        int left = 0;
        int right = ls.length - 1;
        while (true) {
            while (left < right && ls[right] == 0) right --;
            while (left < right && ls[left] == 0) left ++;
            if (left >= right) {
                break;
            }
            int min = Math.min(ls[right], ls[left]);
            res += min * (right - left);
            ls[right] -= min;
            ls[left] -= min;
        }
        return res;
    }

    public static void main(String[] args) {
        BestMeetingPoint b = new BestMeetingPoint();
        int[][] i = {{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
//        int[][] i = {{0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0}};
//        int[][] i = {{0,0,0,0,0,0,0,0,0},{0,0,0,0,1,0,0,1,0},{1,1,0,0,0,0,1,0,0},{0,0,0,1,1,1,0,0,0}};
        System.out.println(b.minTotalDistance(i));
    }
}
