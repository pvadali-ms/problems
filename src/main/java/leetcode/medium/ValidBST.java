package leetcode.medium;

import leetcode.utility.TreeNode;

/**
 * Created by PV029500 on 10/8/2016.
 */
public class ValidBST {

    public boolean validBST(TreeNode treeNode) {
        return validBSTHelper(treeNode, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean validBSTHelper(TreeNode treeNode, long maxVal, long minVal) {
        if (treeNode == null) return true;
        if (treeNode.val <= minVal || treeNode.val >= maxVal) return false;
        return validBSTHelper(treeNode.left, treeNode.val, minVal) && validBSTHelper(treeNode.right, maxVal, treeNode.val);
    }

}
