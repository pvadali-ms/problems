package epi.trees;

import leetcode.utility.TreeNode;

/**
 * Created by PV029500 on 1/21/2017.
 */

/**
 * Same as the other problem.
 * root.left happens only after the length of right subtree
 * length of right subtree can be found by inEnd - iIndex
 * hence root.left will be inEnd - iIndex - 1
 */
public class ConstructBTFromPostAndIn {

    public class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return helper(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
        }

        public TreeNode helper(int post, int inStart, int inEnd, int[] inorder, int[] postorder) {
            if (inStart > inEnd || post < 0)
                return null;
            TreeNode root = new TreeNode(postorder[post]);
            int inIndex = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == root.val)
                    inIndex = i;
            }

            root.right = helper(post - 1, inIndex + 1, inEnd, inorder, postorder);
            root.left = helper(post - (inEnd - inIndex) - 1, inStart, inIndex - 1, inorder, postorder);

            return root;
        }
    }
}
