package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * <p>
 * Note that the row index starts from 0.
 * <p>
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output: [1,3,3,1]
 * Follow up:
 * <p>
 * Could you optimize your algorithm to use only O(k) extra space?
 * <p>
 * quetions:
 * 1.
 * <p>
 * <p>
 * f(n, k) = f(n - 1, k - 1) + f(n - 1, k)
 * f(1,1) = 1;
 * f(2, 1) = 1;
 * f(2, 2) = 1;
 * f(3, 1) = 1;
 * f(3, 2) = 2;
 * f(3, 3) = 1;
 * <p>
 * algorithm.
 * use a list, and added itself element to increase the length to get the result;
 * <p>
 * nth row, has n elements
 * 1. initial n elements of 1
 * 2. a[i] = a[i] + a[i - 1], where i != 0 or n - 1;
 * 3. it must loop from back, otherwise a[i] will be override by last calculation.
 */

public class PascalsTriangleII {
    /**
     * nth row, has n elements
     * 1. initial n elements of 1
     * 2. a[i] = a[i] + a[i - 1], where i != 0 or n - 1;
     * 3. it must loop from back, otherwise a[i] will be override by last calculation.
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i <= rowIndex + 1; i++) {
            res.add(1);
            for (int j = i - 1; j >= 0; j--) {
                if (j != 0 && j != i - 1) {
                    res.set(j, res.get(j) + res.get(j - 1));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PascalsTriangleII p = new PascalsTriangleII();
        int k = 3;
        System.out.println(p.getRow(k));
    }
}
