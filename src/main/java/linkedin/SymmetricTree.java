package linkedin;

import leetcode.utility.TreeNode;

/**
 * Created by PV029500 on 11/27/2016.
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {

        return root == null || help(root.right, root.left);

    }

    public boolean help(TreeNode leftSubtree, TreeNode rightSubtree) {
        if (leftSubtree == null || rightSubtree == null) return leftSubtree == rightSubtree;
        return (leftSubtree.val == rightSubtree.val && help(leftSubtree.right, rightSubtree.left) && help(leftSubtree.left, rightSubtree.right));
    }
}
