package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

 Each 0 marks an empty land which you can pass by freely.
 Each 1 marks a building which you cannot pass through.
 Each 2 marks an obstacle which you cannot pass through.
 Example:

 Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]

 1 - 0 - 2 - 0 - 1
 |   |   |   |   |
 0 - 0 - 0 - 0 - 0
 |   |   |   |   |
 0 - 0 - 1 - 0 - 0

 Output: 7

 Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
 the point (1,2) is an ideal empty land to build a house, as the total
 travel distance of 3+3+1=7 is minimal. So return 7.
 Note:
 There will be at least one building. If it is not possible to build such house according to the above rules, return -1.

 1. find all building location
 2. BFS buildings, and update the min distance to each free spaces, and add its original value.
 3. find the smallest sum at last building bfs
 */
public class ShortestDistancefromAllBuildings {
    int[] rMove = {-1, 0, 1, 0};
    int[] cMove = {0, -1, 0, 1};
    public int shortestDistance(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                grid[i][j] *= -1;
            }
        }

        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == -1) {
                    bfsUpdateDist(grid, i, j);
                }
            }
        }

        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] > 0) {
                    res = Math.min(grid[i][j], res);
                }
            }
        }
        System.out.println(Arrays.deepToString(grid));
        return (res == Integer.MAX_VALUE) ? -1: res;
    }

    private void bfsUpdateDist(int[][] grid, int row, int column) {
        Queue<int[]> queue = new LinkedList();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        queue.add(new int[]{row, column});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curColumn = cur[1];
            if (isSafe(grid, curRow, curColumn, m, n, visited)) {
                continue;
            } else {
                for (int i = 0; i < 4; i ++) {
                    int newRow = curRow + rMove[i];
                    int newColumn = curColumn + cMove[i];
                    if (isSafe(grid, newRow, newColumn, m, n, visited)) {
                        grid[newRow][newColumn] += 1;
                        visited[newRow][newColumn] = true;
                        queue.add(new int[]{newRow, newColumn});
                    }
                }
            }
        }
    }

    private boolean isSafe(int [][] gird, int x, int y, int m, int n, boolean[][] visited) {
        if (x < 0 || x > m - 1 || y < 0 || y > n - 1 || visited[x][y]) {
            return false;
        } else if (gird[x][y] == -2 || gird[x][y] == -1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ShortestDistancefromAllBuildings s = new ShortestDistancefromAllBuildings();
        int[][] i = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        System.out.println(s.shortestDistance(i));
    }
}
