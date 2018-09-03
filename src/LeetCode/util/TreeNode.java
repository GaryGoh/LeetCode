package LeetCode.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mgao on 2018/4/24.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    private TreeNode root;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(Integer[] xs) {
        this.root = new TreeNode(xs[0]);
        TreeNode node = this.root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int i = 1;

        while (!queue.isEmpty()) {

            if (i >= xs.length) {
                break;
            }

            TreeNode cur = queue.poll();
            if (cur == null) {
                continue;
            }

            if (i % 2 != 0) {
                if (xs[i] != null){
                    cur.left = new TreeNode(xs[i]);
                    queue.offer(cur.left);
                } else {
                    queue.offer(null);
                }
                i ++;
            }

            if (i % 2 == 0) {
                if (xs[i] != null){
                    cur.right = new TreeNode(xs[i]);
                    queue.offer(cur.right);
                } else {
                    queue.offer(null);
                }
                i ++;
            }
        }
    }

    public TreeNode getRoot() {
        return this.root;
    }

    public static List<Integer> res = new ArrayList<>();

    public static List<Integer> inorderTraverse(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left != null) {
            inorderTraverse(node.left);
        }
        res.add(node.val);
        if (node.right != null) {
            inorderTraverse(node.right);
        }
        return res;
    }

    public static List<Integer> preorderTraverse(TreeNode node) {
        if (node == null) {
            return null;
        }
        res.add(node.val);
        if (node.left != null) {
            inorderTraverse(node.left);
        }
        if (node.right != null) {
            inorderTraverse(node.right);
        }
        return res;
    }

    public static List<Integer> postorderrTraverse(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left != null) {
            inorderTraverse(node.left);
        }
        if (node.right != null) {
            inorderTraverse(node.right);
        }
        res.add(node.val);
        return res;
    }

    public static List<Integer> bfs(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            res.add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return res;
    }

    static void cleanRes() {
        res.clear();
    }
}
