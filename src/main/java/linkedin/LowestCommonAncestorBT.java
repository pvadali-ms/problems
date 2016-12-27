package linkedin;

import leetcode.utility.TreeNode;

/**
 * Created by PV029500 on 11/27/2016.
 */
public class LowestCommonAncestorBT {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left != null && right != null ? root : left == null ? right : left;
    }
}
