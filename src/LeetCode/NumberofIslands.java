package LeetCode;

import java.util.concurrent.Callable;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:

 11110
 11010
 11000
 00000
 Answer: 1

 Example 2:

 11000
 11000
 00100
 00011
 Answer: 3
 */
public class NumberofIslands implements Callable {
    /**
     * 1. check each "1" element, which represents the island, and search from it, to check the island range.
     * 2. update "1" to "0" to represent visited.
     */
    public int numIslands(char[][] grid) {
        int res = 0;
        // edge case check
        if (grid.length == 0) {return res;}

        // go through the element and do the DFS / BFS
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == '1') {
                    //TODO: DFS or BFS
                    dfs(grid, i, j);
                    res ++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][]grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') { return;}
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    public static void main(String[] args) {
        NumberofIslands n = new NumberofIslands();
        char[][] c = new char[][] {{'1', '1','1','1','0'},{'1','1','0','1','0'},{'1', '1', '0', '0','0'}, {'0','0','0','0','0'}};
        char[][] c1 = new char[][] {{'1', '1','0','0','0'},{'1','1','0','0','0'},{'0', '0', '1', '0','0'}, {'0','0','0','1','1'}};
        System.out.println(n.numIslands(c1));
        RunTimeChecker r = new RunTimeChecker();
        r.runtimeChecker(n).run();
    }

    @Override
    public Object call() throws Exception {
        NumberofIslands n = new NumberofIslands();
        char[][] c = new char[][] {{'1', '1','1','1','0'},{'1','1','0','1','0'},{'1', '1', '0', '0','0'}, {'0','0','0','0','0'}};
        return n.numIslands(c);
    }
}
