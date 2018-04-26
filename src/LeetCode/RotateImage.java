package LeetCode;

import java.util.Arrays;

/**
 * You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Note:

 You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 Example 1:

 Given input matrix =
 [
 [1,2,3],
 [4,5,6],
 [7,8,9]
 ],

 rotate the input matrix in-place such that it becomes:
 [
 [7,4,1],
 [8,5,2],
 [9,6,3]
 ]
 Example 2:

 Given input matrix =
 [
 [ 5, 1, 9,11],
 [ 2, 4, 8,10],
 [13, 3, 6, 7],
 [15,14,12,16]
 ],

 rotate the input matrix in-place such that it becomes:
 [
 [15,13, 2, 5],
 [14, 3, 4, 1],
 [12, 6, 8, 9],
 [16, 7,10,11]
 ]

 [1,2,3],
 [4,5,6],
 [7,8,9]

 diagnoal rotate
 m[i][j] <-> m[j][i]

 [1,4,7],
 [2,5,8],
 [3,6,9]

 vertical rotate
 m[i][j] <-> m[i][len - j]
 [7,4,1],
 [8,5,2],
 [9,6,3]
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int len = matrix[0].length;
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = i; j < len; j ++) {
                if (i != j) {
                    matrix[i][j] ^= matrix[j][i];
                    matrix[j][i] ^= matrix[i][j];
                    matrix[i][j] ^= matrix[j][i];
                }
            }
        }

        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < len / 2; j ++) {
                matrix[i][j] ^= matrix[i][len - 1 - j];
                matrix[i][len - 1 - j] ^= matrix[i][j];
                matrix[i][j] ^= matrix[i][len - 1 - j];
            }
        }
    }

    public static void main(String[] args) {
        RotateImage r = new RotateImage();
        int[][] m = {{1,2,3}, {4,5,6}, {7,8,9}};
        r.rotate(m);
        System.out.println(Arrays.deepToString(m));
    }
}
