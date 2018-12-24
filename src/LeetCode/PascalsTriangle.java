package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <p>
 * Input: 5
 * Output:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 *
 * questions:
 * 1. how big of numRows?
 *
 * corner case:
 * 1. k <= 0; return null;
 */

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; i ++) {
            List<Integer> curLevel = new ArrayList<>();
            for (int j = 0; j < i; j ++) {
                if (j == 0 || j == i - 1) {
                    curLevel.add(1);
                } else {
                    int preLeft = res.get(i - 2).get(j - 1);
                    int preRight = res.get(i - 2).get(j);
                    curLevel.add(preLeft + preRight);
                }
            }
            res.add(curLevel);
        }
        return res;
    }

    public static void main(String[] args) {
        PascalsTriangle p = new PascalsTriangle();
        int k = 0;
        System.out.println(p.generate(k));
    }
}
