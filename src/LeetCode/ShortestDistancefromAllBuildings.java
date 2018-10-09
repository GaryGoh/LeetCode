package LeetCode;

import java.util.*;

/**
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
 * <p>
 * Each 0 marks an empty land which you can pass by freely.
 * Each 1 marks a building which you cannot pass through.
 * Each 2 marks an obstacle which you cannot pass through.
 * Example:
 * <p>
 * Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 * <p>
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * <p>
 * Output: 7
 * <p>
 * Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
 * the point (1,2) is an ideal empty land to build a house, as the total
 * travel distance of 3+3+1=7 is minimal. So return 7.
 * Note:
 * There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
 * <p>
 * 1. find all building location
 * 2. BFS buildings, and update the min distance to each free spaces, and add its original value.
 * 3. find the smallest sum at last building bfs
 */
public class ShortestDistancefromAllBuildings {
    int[] rMove = {-1, 0, 1, 0};
    int[] cMove = {0, -1, 0, 1};

    public int shortestDistance2(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int res = Integer.MAX_VALUE;
        int numBuildings = 0;
        int[][] nums = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] *= -1;
                if (grid[i][j] == -1) {
                    numBuildings++;
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == -1) {
                    bfsUpdateDist2(grid, i, j, nums);
                    System.out.println(Arrays.deepToString(grid));
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0 && nums[i][j] == numBuildings) {
                    res = Math.min(grid[i][j], res);
                }
            }
        }
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    private void bfsUpdateDist(int[][] grid, int row, int column, int[][] nums) {
        Queue<int[]> queue = new LinkedList();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dists = new int[m][n];
        queue.add(new int[]{row, column});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curColumn = cur[1];
            for (int i = 0; i < 4; i++) {
                int newRow = curRow + rMove[i];
                int newColumn = curColumn + cMove[i];
                if (isSafe(grid, newRow, newColumn, m, n, visited)) {
                    int priorDist = 0;
                    if (dists[curRow][curColumn] > 0) {
                        priorDist = dists[curRow][curColumn];
                    }
                    dists[newRow][newColumn] = priorDist + 1;
                    grid[newRow][newColumn] += dists[newRow][newColumn];
                    nums[newRow][newColumn]++;
                    visited[newRow][newColumn] = true;
                    queue.add(new int[]{newRow, newColumn});
                }
            }
        }
    }

    private void bfsUpdateDist2(int[][] grid, int row, int column, int[][] nums) {
        Queue<int[]> queue = new LinkedList();
        int m = grid.length;
        int n = grid[0].length;
        int level = 0;
        boolean[][] visited = new boolean[m][n];
        queue.add(new int[]{row, column});

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int s = 0; s < size; s++) {
                int[] cur = queue.poll();
                int curRow = cur[0];
                int curColumn = cur[1];
                for (int i = 0; i < 4; i++) {
                    int newRow = curRow + rMove[i];
                    int newColumn = curColumn + cMove[i];
                    if (isSafe(grid, newRow, newColumn, m, n, visited)) {
                        if (grid[newRow][newColumn] >= 0) {
                            grid[newRow][newColumn] += level;
                            nums[newRow][newColumn]++;
                            visited[newRow][newColumn] = true;
                            queue.add(new int[]{newRow, newColumn});
                        }
                    }
                }
            }
        }
    }

    private boolean isSafe(int[][] gird, int x, int y, int m, int n, boolean[][] visited) {
        if (x < 0 || x > m - 1 || y < 0 || y > n - 1 || visited[x][y] || gird[x][y] < 0) {
            return false;
        }
        return true;
    }

    /**
     * This approach is using couting the distance as level when doing the bfs. store the steps to dist[][],
     * instead of changing the values in grid[][].
     * <p>
     * After calculating the dist. find the min value.
     */

    public int shortestDistance(int[][] grid) {
        int res = Integer.MAX_VALUE;
        int numBuildings = 0;
        int[][] nums = new int[grid.length][grid[0].length];
        int[][] dists = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    numBuildings++;
                    bfs(grid, i, j, nums, dists, 1);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && nums[i][j] == numBuildings) {
                    res = Math.min(dists[i][j], res);
                }
            }
        }
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    private void bfs(int[][] grid, int x, int y, int[][] nums, int[][] dists, int level) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int curX = cur[0];
                int curY = cur[1];
                for (int k = 0; k < 4; k++) {
                    int newX = curX + rMove[k];
                    int newY = curY + cMove[k];
                    if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length && !visited[newX][newY] && grid[newX][newY] == 0) {
                        dists[newX][newY] += level;
                        nums[newX][newY]++;
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
            level++;
        }
    }

    public static void main(String[] args) {
        ShortestDistancefromAllBuildings s = new ShortestDistancefromAllBuildings();
//        int[][] i = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        int[][] i = {{0,2,1},{1,0,2},{0,1,0}};
//        System.out.println(s.shortestDistance(i));

        String[] s1 = {"a", "b"};
        String[] s2 = s1;
        System.out.println(s2[0]);

        List<String> list = new ArrayList();
        String s3 = "a";
        String s4 = "b";
        list.add(s3);
        list.add(s4);
        System.out.println(list);

        list.remove(s4);
        list.add(0, s4);
        System.out.println(list);
    }
}
