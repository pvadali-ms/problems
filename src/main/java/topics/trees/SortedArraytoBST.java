package topics.trees;

import leetcode.utility.TreeNode;

/**
 * Created by PV029500 on 10/27/2016.
 */
public class SortedArraytoBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return recurse(nums, 0, nums.length - 1);
    }

    public TreeNode recurse(int[] nums, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            TreeNode newNode = new TreeNode(nums[mid]);
            newNode.left = recurse(nums, low, mid - 1);
            newNode.right = recurse(nums, mid + 1, high);
            return newNode;
        } else {
            return null;
        }
    }
}
