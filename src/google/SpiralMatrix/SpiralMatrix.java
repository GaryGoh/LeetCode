package google.SpiralMatrix;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by mgao on 2018/3/22.
 */
public class SpiralMatrix {
    private enum Status {RIGHT, DOWN, LEFT, UP}

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList();
        }

        List<Integer> res = new ArrayList();
        Status status = Status.RIGHT;
        int i = 0;
        int j = 0;
        int width = matrix[0].length;
        int high = matrix.length;
        int total = width * high;
        res.add(matrix[0][0]);
        matrix[0][0] = Integer.MAX_VALUE;

        // start from (0,0) and move right
        while (res.size() < total) {

            if (status == Status.RIGHT) {

                if ((j + 1 >= width || matrix[i][j + 1] == Integer.MAX_VALUE) && matrix[i + 1][j] != Integer.MAX_VALUE) {
                    status = Status.DOWN;
                } else {
                    j ++;
                    res.add(matrix[i][j]);
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }

            else if (status == Status.DOWN) {
                if ((i + 1 >= high || matrix[i + 1][j] == Integer.MAX_VALUE) && matrix[i][j - 1] != Integer.MAX_VALUE) {
                    status = Status.LEFT;
                } else {
                    i ++;
                    res.add(matrix[i][j]);
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }

            else if (status == Status.LEFT) {
                if ((j - 1 < 0 || matrix[i][j - 1] == Integer.MAX_VALUE) && matrix[i - 1][j] != Integer.MAX_VALUE) {
                    status = Status.UP;
                } else {
                    j --;
                    res.add(matrix[i][j]);
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }

            else if (status == Status.UP) {
                if ((i - 1 < 0 || matrix[i - 1][j] == Integer.MAX_VALUE) && matrix[i][j + 1] != Integer.MAX_VALUE)  {
                    status = Status.RIGHT;
                } else {
                    i --;
                    res.add(matrix[i][j]);
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[][] m = {{1,2,3}, {4,5,6}, {7,8,9}};
//        int[][] m = null;
//        SpiralMatrix s = new SpiralMatrix();
//        System.out.println(s.spiralOrder(m));
        System.out.println(0x7FFFFFFF);
        System.out.println(0xFFFFFFFF);

        
        System.out.println();
        System.out.println(Integer.MAX_VALUE & 0x7FFFFFFF);
        System.out.println(Integer.MIN_VALUE & 0x7FFFFFFF);
        System.out.println((Integer.MAX_VALUE + 1) & 0x7FFFFFFF);
        System.out.println((Integer.MIN_VALUE - 1) & 0x7FFFFFFF);

    }
}
