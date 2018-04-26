package google.BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mgao on 2018/3/8.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x) {
        val = x;
    }
}

public class BinaryTreePaths {
    public List<String>  binaryTreePaths (TreeNode node) {
        List<String> res = new ArrayList();
        if (node == null) {
            return res;
        }
        traverseBTPaths(res, node, "");
        return res;
    }

    private void traverseBTPaths (List res, TreeNode root, String path) {

        if (root.left == null && root.right == null) {
            res.add(path + root.val);
        }

        if (root.left != null) {
            traverseBTPaths(res, root.left, path + root.val + "->");
        }

        if (root.right != null) {
            traverseBTPaths(res, root.right, path + root.val + "->");
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.right = new TreeNode(3);
        BinaryTreePaths bt = new BinaryTreePaths();
        System.out.print(bt.binaryTreePaths(root));
    }

}
