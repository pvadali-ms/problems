package linkedin;

import leetcode.utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PV029500 on 11/26/2016.
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.
 * <p>
 * Example:
 * Given binary tree
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * Returns [4, 5, 3], [2], [1].
 */
public class FindLeavesofBinaryTree {
    //taken from http://www.programcreek.com/2014/07/leetcode-find-leaves-of-binary-tree-java/
    //the depth is measured upto most bottom a branch can get to, for example, in 1, 2, 3, 4, 5 above, 3 has no children and hence left and right return -1 for 3

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, root);
        return result;
    }

    // traverse the tree bottom-up recursively
    private int helper(List<List<Integer>> list, TreeNode root) {
        if (root == null)
            return -1;

        int left = helper(list, root.left);
        int right = helper(list, root.right);
        int curr = Math.max(left, right) + 1;

        // the first time this code is reached is when curr==0,
        //since the tree is bottom-up processed.
        if (list.size() <= curr) {
            list.add(new ArrayList<Integer>());
        }

        list.get(curr).add(root.val);

        return curr;
    }
}
