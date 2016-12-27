package linkedin;

import leetcode.utility.TreeNode;

/**
 * Created by PV029500 on 11/27/2016.
 */
public class MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    public int maxDepth(TreeNode node, int depth) {
        if (node == null)
            return depth;
        return Math.max(maxDepth(node.left, depth + 1), maxDepth(node.right, depth + 1));
    }
}
