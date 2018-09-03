package LeetCode;

import LeetCode.util.TreeNode;

import java.util.Arrays;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 Example:

 Given the sorted array: [-10,-3,0,5,9],

 One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

 0
 / \
 -3   9
 /   /
 -10  5
 */
public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(0, nums.length - 1, nums);
    }

    private TreeNode helper(int left, int right, int[] nums) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(left, mid - 1, nums);
        root.right = helper(mid + 1, right, nums);
        return root;
    }

    public static void main(String[] args) {
        ConvertSortedArraytoBinarySearchTree c = new ConvertSortedArraytoBinarySearchTree();
        int[] i = {-10,-3,0,5,9};
        TreeNode node = c.sortedArrayToBST(i);
        System.out.println(TreeNode.bfs(node));
    }
}
