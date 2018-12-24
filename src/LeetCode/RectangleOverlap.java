package LeetCode;


import org.junit.Assert;

/**
 * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner, and (x2, y2) are the coordinates of its top-right corner.
 * <p>
 * Two rectangles overlap if the area of their intersection is positive.  To be clear, two rectangles that only touch at the corner or edges do not overlap.
 * <p>
 * Given two (axis-aligned) rectangles, return whether they overlap.
 * <p>
 * Example 1:
 * <p>
 * Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * Output: true
 * Example 2:
 * <p>
 * Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * Output: false
 * Notes:
 * <p>
 * Both rectangles rec1 and rec2 are lists of 4 integers.
 * All coordinates in rectangles will be between -10^9 and 10^9.
 *
 * Questions:
 * 1. can this rectangle be a point?
 * 2. how if a rectangle contains the other one? (overlap?)
 * 3. how if the coincidence of two rectangles?
 *
 * corner case
 * above.
 *
 * algorithm
 * 1. as there are 5 valid cases. so we consider the invalid cases.
 *  a. x12 <= x21 (1 2)
 *  b. x11 >= x22 (2 1)
 *  c. y11 >= y22 (1 | 2)
 *  d. y12 <= y21 (2 | 1)
 *
 */


public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean case1 = rec1[2] <= rec2[0];
        boolean case2 = rec1[0] >= rec2[2];
        boolean case3 = rec1[1] >= rec2[3];
        boolean case4 = rec1[3] <= rec2[1];
        return !(case1 || case2 || case3 || case4);
    }

    public static void main(String[] args) {
        int[] r1 = {0,0,2,2};
        int[] r2 = {1,1,3,3};
        int[] r3 = {0,0,1,1};
        int[] r4 = {1,0,2,1};
        RectangleOverlap r = new RectangleOverlap();
        Assert.assertTrue(r.isRectangleOverlap(r1, r2));
        Assert.assertFalse(r.isRectangleOverlap(r3, r4));
    }
}
