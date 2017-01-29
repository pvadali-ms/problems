package epi.trees;

import leetcode.utility.TreeNode;

/**
 * Created by PV029500 on 1/21/2017.
 */

/**
 * current pre will always be the current root.
 * to find the left of it, find where pre + 1 lies in inorder array
 * to find the right of it, find where pre + inIndex - inStart + 1 lies in the inorder
 * split the inorder based on inIndex found as inStart to inIndex - 1 as left subtree of current root
 * and inIndex + 1 to inEnd as right subtree of the current root
 */
public class ConstructBTFromPreAndIn {

    public class Solution {

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return helper(0, 0, inorder.length - 1, preorder, inorder);
        }

        public TreeNode helper(int pre, int inStart, int inEnd, int[] preorder, int[] inorder) {
            if (inStart > inEnd || pre > preorder.length - 1)
                return null;
            int inIndex = 0;
            TreeNode root = new TreeNode(preorder[pre]);
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == root.val)
                    inIndex = i;
            }
            root.left = helper(pre + 1, inStart, inIndex - 1, preorder, inorder);
            root.right = helper(pre + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
            return root;
        }

    }
}
