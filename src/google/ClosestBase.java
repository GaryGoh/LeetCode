package google;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mgao on 2018/4/9.
 */
public class ClosestBase {

    private Set<int[]> asteriodLocatoin = new HashSet();

    /**
     * Given a matrix with the numbers of asteroids, and return the coordinate of base.
     *
     * @param matrix the universe matrix.
     * @return the coordinate of the base.
     */
    public int[] findClosestBase(int[][] matrix) {
        int[] res = new int[2];
        int[][] resMatrix = new int[matrix.length][matrix[0].length];
        // look up and store the asteroid location.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE) {
                    asteriodLocatoin.add(new int[]{i, j});
                }
            }
        }

        for (int[] e : asteriodLocatoin) {
            matrix[e[0]][e[1]] = 0;
            addMatrix(resMatrix, bFSUpdateMatrix(matrix, e));
        }
        System.out.println(Arrays.deepToString(resMatrix));
        return res;
    }

    private int[][] bFSUpdateMatrix(int[][] matrix, int[] root) {
        ArrayDeque<int[]> queue = new ArrayDeque();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int[] e : asteriodLocatoin) {
            visited[e[0]][e[1]] = true;
        }
//        matrix[root[0]][root[1]] = 0;
        queue.offer(root);
        while (queue.size() != 0) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            if (matrix[x][y] < Integer.MAX_VALUE && matrix[x][y] != Integer.MIN_VALUE && cur != root) { // MIN represents the debris; MAX represents the asteroids.
                matrix[x][y] = matrix[cur[2]][cur[3]] + 1;
                visited[x][y] = true;
            }
            for (int[] child : findAdjNodesWithParent(x, y, matrix[0].length, matrix.length)) {
                if (!visited[child[0]][child[1]]) {
                    queue.offer(child);
                }
            }
        }
        return matrix;
    }

    private Set<int[]> findAdjNodesWithParent(int x, int y, int width, int height) {
        HashSet<int[]> adjNodes = new HashSet();
        int[] m = {-1, 1};
        int rx, ry;
        for (int i : m) {
            if ((rx = x + i) >= 0 && rx + 1 <= height) {
                adjNodes.add(new int[]{rx, y, x, y});
            }
        }

        for (int i : m) {
            if ((ry = y + i) >= 0 && ry + 1 <= width) {
                adjNodes.add(new int[]{x, ry, x, y});
            }
        }
        return adjNodes;
    }

    private int[][] addMatrix(int[][] res, int[][] matrix) {
        for (int i = 0; i < res.length; i ++) {
            for (int j = 0; j < res[0].length; j ++) {
                res[i][j] += matrix[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ClosestBase c = new ClosestBase();
//        Set<int[]> r = c.findAdjNodes(1, 1, 5, 5);
        int[][] t = new int[][]{{0, 0, 0, Integer.MAX_VALUE, 0}, {0, Integer.MAX_VALUE, 0, 0, 0}, {0, 0, 0, 0, Integer.MAX_VALUE}};
        System.out.println(Arrays.deepToString(t));
//        r.forEach(e -> System.out.println(e[0] + "," + e[1]));
        c.findClosestBase(t);
    }
}
