package linkedin;

import leetcode.utility.TreeNode;

import java.util.Stack;

/**
 * Created by PV029500 on 11/26/2016.
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

 Calling next() will return the next smallest number in the BST.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
public class BSTIterator {

    Stack<TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        stack.push(root);
        while(root.left != null) {
            stack.push(root.left);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode treeNode, tempNode = null;
        if (!stack.empty()) {
            treeNode = stack.pop();
            tempNode = treeNode;
            if (treeNode.right != null) {
                treeNode = treeNode.right;
                stack.push(treeNode);
                while(treeNode.left != null) {
                    stack.push(treeNode.left);
                    treeNode = treeNode.left;
                }
            }
        }
        return tempNode.val;
    }
}
