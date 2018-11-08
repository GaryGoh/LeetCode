package LeetCode;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */


public class ContainerWithMostWater {

    /**
     * use two pointers:
     * 1. init the max area
     * 2. move left pointer, when the height.left < height.right, then cal the area
     * 3. move right pointer, when the height.right < height.left, then cal the area
     * 4. if height.left == height.right, left ++, right --, cal area
     */
    public int maxArea(int[] height) {
        int area = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            area = Math.max(area, getArea(left, right, height));

            while (height[left] < height[right]) {
                left++;
                area = Math.max(area, getArea(left, right, height));
            }

            while (height[left] > height[right]) {
                right--;
                area = Math.max(area, getArea(left, right, height));
            }

            if (height[left] == height[right]) {
                left++;
                right--;
            }
        }
        return area;
    }

    private int getArea(int left, int right, int[] height) {
        return (right - left) * Math.min(height[left], height[right]);
    }

    public static void main(String[] args) {
//        int[] i = {1,8,6,2,5,4,8,3,7};
        int[] i = {1, 2, 4, 3};
        ContainerWithMostWater c = new ContainerWithMostWater();
        System.out.println(c.maxArea(i));
    }
}
