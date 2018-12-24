package LeetCode;


/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

 Find the minimum element.

 You may assume no duplicate exists in the array.

 Example 1:

 Input: [3,4,5,1,2]
 Output: 1

 Example 2:

 Input: [4,5,6,7,0,1,2]
 Output: 0
 */

public class FindMinimuminRotatedSortedArray {

    /**
     * binary search, if left < right, left -> mid; else mid -> right
     */
    public int findMin1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[left] < nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[0];
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        return nums[0];
    }

//    private int helper(int[] nums, int left, int right) {
//
//    }

    public static void main(String[] args) {
        FindMinimuminRotatedSortedArray f = new FindMinimuminRotatedSortedArray();
        int[] i = {1,2};
//        int[] i = {4,5,6,7,0,1,2};
        System.out.println(f.findMin(i));
    }
}
