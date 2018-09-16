package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a m x n 2D grid initialized with these three possible values.
 * <p>
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 * <p>
 * Example:
 * <p>
 * Given the 2D grid:
 * <p>
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 * 0  -1 INF INF
 * After running your function, the 2D grid should be:
 * <p>
 * 3  -1   0   1
 * 2   2   1  -1
 * 1  -1   2  -1
 * 0  -1   3   4
 * <p>
 * <p>
 * 1. BFS from each gate
 * 2. each time in the BFS, will need two extract 2d arrays to record visited, and the distance of current BFS
 */

public class WallsandGates {
    int[] rMove = {-1, 0, 1, 0};
    int[] cMove = {0, -1, 0, 1};

    public void wallsAndGates1(int[][] rooms) {
        if (rooms == null || rooms[0].length == 0) {
            return;
        }

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] <= 0) {
                    rooms[i][j]--;
                }
            }
        }

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == -1) {
                    bfsCalDistance(rooms, i, j);
                }
            }
        }

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] < 0) {
                    rooms[i][j]++;
                }
            }
        }
    }

    private void bfsCalDistance(int[][] rooms, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dists = new int[rooms.length][rooms[0].length];
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int newX = curX + rMove[i];
                int newY = curY + cMove[i];
                if (isSafe(rooms, newX, newY, visited)) {
                    int dist = 0;
                    if (rooms[curX][curY] >= 0) {
                        dist = dists[curX][curY];
                    }
                    dists[newX][newY] += dist + 1;
                    rooms[newX][newY] = Math.min(dists[newX][newY], rooms[newX][newY]);
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }

        }
    }

    private boolean isSafe(int[][] rooms, int x, int y, boolean[][] visited) {
        if (x < 0 || x > rooms.length - 1 || y < 0 || y > rooms[0].length - 1 || visited[x][y] || rooms[x][y] == -1 || rooms[x][y] == -2) {
            return false;
        }
        return true;
    }

    public void wallsAndGates2(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    helper(rooms,i, j,0);
                }
            }
        }
    }

    private void helper(int[][] rooms, int x, int y, int val) {
        if (x < 0 || x > rooms.length - 1 || y < 0 || y > rooms[0].length - 1 || rooms[x][y] < val) {
            return;
        }
        rooms[x][y] = val;
        helper(rooms, x - 1, y, val + 1);
        helper(rooms, x + 1, y, val + 1);
        helper(rooms, x, y - 1, val + 1);
        helper(rooms, x, y + 1, val + 1);
    }

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i ++) {
            for (int j = 0; j < rooms[0].length; j ++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            for (int k = 0; k < 4; k ++) {
                int newX = curX + rMove[k];
                int newY = curY + cMove[k];
                if (newX < 0 || newY < 0 || newX > rooms.length - 1 || newY > rooms[0].length - 1 || rooms[newX][newY] < rooms[curX][curY]  + 1) {
                    continue;
                }
                rooms[newX][newY] = rooms[curX][curY] + 1;
                queue.offer(new int[]{newX, newY});
            }
        }
    }

    public static void main(String[] args) {
        WallsandGates w = new WallsandGates();
        int[][] i = {{2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}};
//        int[][] i = null;
        w.wallsAndGates(i);
        System.out.println(Arrays.deepToString(i));

    }

}
