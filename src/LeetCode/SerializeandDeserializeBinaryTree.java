package LeetCode;

import LeetCode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * For example, you may serialize the following tree
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 * <p>
 * <p>
 * <p>
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 * <p>
 * Credits:
 * Special thanks to @Louis1992 for adding this problem and creating all test cases.
 * // Your Codec object will be instantiated and called as such:
 * // Codec codec = new Codec();
 * // codec.deserialize(codec.serialize(root));
 */
public class SerializeandDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize1(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList();
        StringBuilder res = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                res.append("null,");
            } else {
                res.append(cur.val + ",");
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return res.toString();
    }

    public String serialize(TreeNode root) {
        if (root != null) {
            return String.valueOf(root.val + ",") + serialize(root.left) + serialize(root.right);
        } else {
            return "null,";
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
        if (data == null || data  == "") {
            return null;
        }
        String[] s = data.split(",");
        Queue<TreeNode> queue = new LinkedList();
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        queue.offer(root);
        for (int i = 1; i < s.length; i ++) {
            TreeNode cur = queue.poll();
            if (!s[i].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(s[i]));
                queue.offer(cur.left);
            }
            if (!s[++i].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(s[i]));
                queue.offer(cur.right);
            }
        }
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] s = data.split(",");
        AtomicInteger index = new AtomicInteger(-1);
//        Integer index = new Integer(- 1);
        return dfsBuild(s, index);
    }

    private TreeNode dfsBuild(String[] data, AtomicInteger index) {
        index.incrementAndGet();
        if (data[index.get()].equals("null")) {
            return null;
        }
        TreeNode cur = new TreeNode(Integer.parseInt(data[index.get()]));
        cur.left = dfsBuild(data, index);
        cur.right = dfsBuild(data, index);
        return cur;
    }

//    private TreeNode dfsBuild(String[] data, Integer index) {
//        index ++;
//        if (data[index].equals("null")) {
//            return null;
//        }
//        TreeNode cur = new TreeNode(Integer.parseInt(data[index]));
//        cur.left = dfsBuild(data, index);
//        cur.right = dfsBuild(data, index);
//        return cur;
//    }

    public static void main(String[] args) {
        SerializeandDeserializeBinaryTree s = new SerializeandDeserializeBinaryTree();
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(3);
        TreeNode l4 = new TreeNode(4);
        TreeNode l5 = new TreeNode(5);

        l1.left = l2;
        l1.right = l3;
        l3.left = l4;
        l3.right = l5;

        String res = s.serialize(l1);
        System.out.println(res);

        TreeNode dres = s.deserialize(res);
        System.out.println(s.serialize(dres));
        System.out.println(res.equals(s.serialize(dres)));
    }
}
