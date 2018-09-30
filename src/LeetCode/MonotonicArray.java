package LeetCode;

import org.junit.Assert;

/**
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * <p>
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 * <p>
 * Return true if and only if the given array A is monotonic.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,2,3]
 * Output: true
 * Example 2:
 * <p>
 * Input: [6,5,4,4]
 * Output: true
 * Example 3:
 * <p>
 * Input: [1,3,2]
 * Output: false
 * Example 4:
 * <p>
 * Input: [1,2,4,5]
 * Output: true
 * Example 5:
 * <p>
 * Input: [1,1,1]
 * Output: true
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 */

public class MonotonicArray {

    public boolean isMonotonic(int[] A) {
        if (A.length < 3) {
            return true;
        }

        boolean isInit = true;
        boolean isAsc = true;
        for (int i = 1; i < A.length; i ++) {
            if (A[i] == A[i - 1]) continue;
            boolean tmp = A[i] > A[i - 1];
            if (isInit) {
                isAsc = tmp;
                isInit = false;
                continue;
            } else {
                if (isAsc == tmp) {
                    continue;
                }
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] i = {6,5,4,4};
        MonotonicArray m = new MonotonicArray();
//        Assert.assertEquals(true, m.isMonotonic(new int[]{1,2,2,3}));
        Assert.assertEquals(true, m.isMonotonic(new int[]{6,5,4,4}));
        Assert.assertEquals(false, m.isMonotonic(new int[]{1,3,2}));
        Assert.assertEquals(true, m.isMonotonic(new int[]{1,2,4,5}));
        Assert.assertEquals(true, m.isMonotonic(new int[]{1,1,1}));
        Assert.assertEquals(true, m.isMonotonic(new int[]{1,1,0}));
        Assert.assertEquals(false, m.isMonotonic(new int[]{11,11,9,4,3,3,3,1,-1,-1,3,3,3,5,5,5}));
//

        System.out.println(m.isMonotonic(i));
    }
}
