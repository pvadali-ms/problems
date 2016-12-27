package topics.trees;

import leetcode.utility.TreeNode;

/**
 * Created by PV029500 on 10/27/2016.
 */
public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        if (left == -1) return -1;

        int right = dfs(root.right);
        if (right == -1) return -1;

        if (Math.abs(right - left) > 1) return -1;
        else return Math.max(left, right) + 1;
    }
}
