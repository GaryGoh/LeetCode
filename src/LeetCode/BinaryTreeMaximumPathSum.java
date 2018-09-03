package LeetCode;

import LeetCode.util.TreeNode;

/**
 * Given a non-empty binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

 Example 1:

 Input: [1,2,3]

 1
 / \
 2   3

 Output: 6
 Example 2:

 Input: [-10,9,20,null,null,15,7]

 -10
 / \
 9  20
 /  \
 15   7

 Output: 42 Le

 1. post order traverse
    a. calculating each node with the max value of subtree
    b. if any of child has the sum < 0, then set it to 0, in case to calculate the parents value.
    c. use a field to record the max value
 2. each recursion return the max path sum, instead of the max result. The max result needs to be stored outside the recursion.


 */
public class BinaryTreeMaximumPathSum {
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxNodeSum(root);
        return max;
    }

    private int maxNodeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, maxNodeSum(root.left));
        int right = Math.max(0, maxNodeSum(root.right));
        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum b = new BinaryTreeMaximumPathSum();
        Integer[] i1 = {1,2,3};
        Integer[] i2 = {-10,9,20,null,null,15,7};
        TreeNode t = new TreeNode(i2).getRoot();
//        System.out.println(TreeNode.bfs(t));
        System.out.println(b.maxPathSum(t));
    }
}
