package topics.trees;


import leetcode.utility.TreeNode;

/**
 * Created by PV029500 on 10/27/2016.
 */
public class HasPathSum {
    public class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) return false;
            if (root.left == null && root.right == null && sum - root.val == 0) return true;
            return (hasPathSum(root.right, sum - root.val) || hasPathSum(root.left, sum - root.val));
        }
    }
}
