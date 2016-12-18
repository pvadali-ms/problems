package topics.treesagain;

import leetcode.utility.TreeNode;

/**
 * Created by PV029500 on 12/11/2016.
 */
public class DeleteNodeInBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent = root, temp = root;
        boolean left = true;
        TreeNode target;
        while (temp != null && temp.val != key) {
            parent = temp;
            if(temp.val > key) {
                left = true;
                temp = temp.left;
            }
            else{
                left = false;
                temp = temp.right;
            }
        }

        if (temp == null) return root;
        if (temp.right == null && temp.left == null) {
            target = null;
        } else if (temp.right == null) {
            target = getHighestOnLeftSubtree(temp);
        } else {
            target = getLowestOnRightSubtree(temp);
        }
        if (target != null) {
            target.left = temp.left;
            target.right = temp.right;
        }

        if (temp == root)
            return target;
        if (left)
            parent.left = target;
        else
            parent.right = target;
        return root;
    }
    public TreeNode getHighestOnLeftSubtree(TreeNode root) {
        TreeNode parent = root;
        TreeNode temp = root.left;
        while(temp.right != null) {
            parent= temp;
            temp = temp.right;
        }
        if (parent == root) {
            parent.left = temp.left;
        } else {
            parent.right = temp.left;
        }
        return temp;
    }
    public TreeNode getLowestOnRightSubtree(TreeNode root) {
        TreeNode parent = root;
        TreeNode temp = root.right;
        while(temp.left != null) {
            parent= temp;
            temp = temp.left;
        }
        if (parent == root) {
            parent.right = temp.right;
        } else {
            parent.left = temp.right;
        }
        return temp;
    }

}
