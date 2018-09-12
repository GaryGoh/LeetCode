package LeetCode;

import LeetCode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 *
 * 1. BFS to traverse the binary tree.
 * 2. each time make the number of nodes in next level.
 * 3. input above number of nodes as a list, and add to the head of the res list.
 */

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        int level = 1;
        List<Integer> curRes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int tmpLevel = 0;

        queue.add(root);
        while (true) {
            TreeNode cur = queue.poll();

            // add current level result.
            if (level == 0) {
                res.add(0, new ArrayList<>(curRes));
                curRes.clear();
                level = tmpLevel;
                tmpLevel = 0;
            }

            if (cur == null) {
                break;
            }

            if (level > 0) {
                curRes.add(cur.val);
                level--;
            }

            // add next level nodes to queue and update the value of level.
            if (cur.left != null) {
                tmpLevel++;
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                tmpLevel++;
                queue.offer(cur.right);
            }
        }
        return res;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmpRes = new ArrayList();
            for (int level = size; level > 0; level --) {
                TreeNode node = queue.poll();
                tmpRes.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(0, tmpRes);
        }
        return res;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversalII b = new BinaryTreeLevelOrderTraversalII();
        Integer[] i = {3,9,20,null,null,15,7};
        TreeNode t = new TreeNode(i);
//        System.out.println(TreeNode.bfs(t.getRoot()));
        System.out.println(b.levelOrderBottom(t.getRoot()));
    }
}
