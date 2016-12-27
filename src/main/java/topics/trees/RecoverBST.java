package topics.trees;

import leetcode.utility.TreeNode;

/**
 * Created by PV029500 on 10/26/2016.
 */
/*
    go to far left and store the root in prevElement, check for root.val <= prevElement
 */
public class RecoverBST {

    TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {

        traverse(root);

        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    public void traverse(TreeNode root) {
        if (root == null)
            return;
        traverse(root.left);

        if(firstElement == null && prevElement.val >= root.val)
            firstElement = prevElement;

        if(firstElement != null && prevElement.val >= root.val)
            secondElement = root;

        prevElement = root;
        traverse(root.right);
    }
}
