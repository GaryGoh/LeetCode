package LeetCode;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * <p>
 * Example:
 * Given a binary tree
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 *
 *
 * questions.
 * 1. does diameter mean, the longest distance between two nodes? and assume each weight of the edge is 1.
 *
 * 2. how to approve that the longest distance between two nodes, must at least from the most left node
 *
 *
 * algorithm.
 *  1. if the diameter crosses root, then it is the solution
 *  2. if not, then recursively 1. util find the solution
 *
 *
 *
 * algorithm2: (post-order)
 * 1. recursively cal and compare the max and current level max left + max right
 */


import LeetCode.util.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class DiameterofBinaryTree {

    int max = 0;
    /**
     * O(n^2)
     */
    public int diameterOfBinaryTree1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = maxDeep(root.left) + maxDeep(root.right);
        return Math.max(res, Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }

    /**
     * O(n)
     */
    private int maxDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDeep(root.left), maxDeep(root.right)) + 1;
    }


    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
//        TreeNode t6 = new TreeNode(6);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
//        t3.right = t6;

        DiameterofBinaryTree d = new DiameterofBinaryTree();
        System.out.println(d.diameterOfBinaryTree(t1));
    }
}
