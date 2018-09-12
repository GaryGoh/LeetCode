package LeetCode;

import java.util.*;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * Example:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 * <p>
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 * <p>
 * 1. if board < 3 * 3, return original board
 * 2. give 8 move steps array.
 * 3. find the 0s region
 * 3. if any move reach the border or its on the border already, then do nothing, otherwise change them to X.
 */


public class SurroundedRegions {
    int[] rMove = {0, 1, 0, -1};
    int[] cMove = {1, 0, -1, 0};

    public void solve(char[][] board) {
        if (board == null || board.length < 3 || board[0].length < 3) {
            return;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        int len = board[0].length;
        int height = board.length;

        for (int i = 0; i < len; i ++) {
            if (board[0][i] == '0') {
                dfs(board, 0, i, visited);
            }
            if (board[height - 1][i] == '0') {
                dfs(board, height - 1, i, visited);
            }
        }
        for (int i = 0; i < height; i ++) {
            if (board[i][0] == '0') {
                dfs(board, i, 0, visited);
            }
            if (board[i][len - 1] == '0') {
                dfs(board, i, len - 1, visited);
            }
        }
        for (int i = 1; i <= board.length - 1; i++) {
            for (int j = 1; j <= board[0].length - 1; j++) {
                if (!visited[i][j] && board[i][j] == '0') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int column, boolean[][] visited) {
        visited[row][column] = true;
        for (int i = 0; i < 4; i++) {
            int tmpRow = row + rMove[i];
            int tmpColumn = column + cMove[i];
            if (tmpRow < 0 || tmpRow > board.length - 1
                    || tmpColumn < 0 || tmpColumn > board[0].length - 1
                    || visited[tmpRow][tmpColumn]) {
                continue;
            }
            visited[tmpRow][tmpColumn] = true;
            if (board[tmpRow][tmpColumn] == '0') {
                dfs(board, tmpRow, tmpColumn, visited);
            }
        }
    }

    public static void main(String[] args) {
//        char[][] board = new char[][]{{'X', '0', 'X', '0', 'X', '0'},
//                                      {'0', 'X', '0', 'X', '0', 'X'},
//                                      {'X', '0', 'X', '0', 'X', '0'},
//                                      {'0', 'X', '0', 'X', '0', 'X'}};
        char[][] board = new char[][]{{'X', 'X', 'X', 'X'},
                                      {'X', '0', '0', 'X'},
                                      {'X', 'X', '0', 'X'},
                                      {'X', '0', 'X', 'X'}};
//        char[][] board = new char[][]{};
        SurroundedRegions s = new SurroundedRegions();
        s.solve(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
