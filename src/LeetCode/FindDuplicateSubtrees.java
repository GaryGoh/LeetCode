package LeetCode;

import LeetCode.util.Expression;
import LeetCode.util.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 * <p>
 * Two trees are duplicate if they have the same structure with same node values.
 * <p>
 * Example 1:
 * <p>
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   2   4
 *     /
 *     4
 * The following are two duplicate subtrees:
 * <p>
 * 2
 * /
 * 4
 * <p>
 * and
 * <p>
 * 4
 * <p>
 * Therefore, you need to return above trees' root in the form of a list.
 * <p>
 * 1. loop the tree, and store all tree in the hashset, if duplicate, put to res
 * O(n), where n = # of nodes
 */
public class FindDuplicateSubtrees {

    static int atomicNum = 1;
    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(4);

        t0.left = t1;
        t0.right = t2;

        t1.left = t3;

        t2.left = t4;
        t2.right = t5;

        t4.left = t6;

        FindDuplicateSubtrees f = new FindDuplicateSubtrees();
        List<TreeNode> r = f.findDuplicateSubtrees(t0);
        for (TreeNode node : r) {
            System.out.println(treeToList(node));
        }
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null || (root.left == null && root.right == null)) {
            return res;
        }
        HashMap<TreeNode, Integer> nodeNumbering = new HashMap<>();
        HashMap<String, Integer> expressionNumbering = new HashMap<>();
        HashMap<Integer, Integer> dupTable = new HashMap<>();
        int val;
        traverseTree(root, nodeNumbering, expressionNumbering);
        for (Map.Entry<TreeNode, Integer> e : nodeNumbering.entrySet()) {
            if ((val = dupTable.getOrDefault(e.getValue(), 1)) == 2) {
                res.add(e.getKey());
            }
            dupTable.put(e.getValue(), val + 1);
        }
        return res;
    }

    private int traverseTree(TreeNode node,
                             HashMap<TreeNode, Integer> nodeNumbering,
                             HashMap<String, Integer> expressionNumbering) {
        if (node == null) {
            return 0;
        }

        int leftNumber = traverseTree(node.left, nodeNumbering, expressionNumbering);
        int rightNumber = traverseTree(node.right, nodeNumbering, expressionNumbering);

        String expression = String.valueOf(node.val) + String.valueOf(leftNumber) +  String.valueOf(rightNumber);
        Integer expressionNum = expressionNumbering.get(expression);

        if (expressionNum == null) {
            expressionNum = atomicNum;
            atomicNum ++;
            expressionNumbering.put(expression, expressionNum);
        }
        nodeNumbering.put(node, expressionNum);
        return expressionNum;
    }

    private static void getRes(TreeNode node, HashMap<TreeNode, Integer> nodeNumbering, List<Integer> ref, List<TreeNode> res) {
        if (ref.contains(nodeNumbering.get(node))) {
            res.add(node);
        }
        ref.add(nodeNumbering.get(node));
        if (node.left != null) {
            getRes(node.left, nodeNumbering, ref, res);
        }

        if (node.right != null) {
            getRes(node.right, nodeNumbering, ref, res);
        }
    }

    private static List<Integer> treeToList(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        bfs(node, res);
        return res;
    }

    private static TreeNode bfs(TreeNode node, List<Integer> res) {
        if (node != null) {
            res.add(node.val);
        }
        if (node.left != null) {
            bfs(node.left, res);
        }
        if (node.right != null) {
            bfs(node.right, res);
        }
        return node;
    }

}
