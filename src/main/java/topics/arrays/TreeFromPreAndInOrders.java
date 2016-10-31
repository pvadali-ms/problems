package topics.arrays;


import leetcode.utility.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PV029500 on 10/25/2016.
 */
/*
    store the inorder in a map as there are no duplicates.
 */
public class TreeFromPreAndInOrders {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++)
            m.put(inorder[i], i);
        return helper(0, 0, inorder.length - 1, preorder, inorder, m);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preOrder, int[] inOrder, Map<Integer, Integer> m) {

        if(preStart > preOrder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preStart]);
        int iIndex = m.get(root.val);
        root.left = helper(preStart + 1, inStart, iIndex - 1, preOrder, inOrder, m);
        root.right = helper(preStart + iIndex - inStart + 1, iIndex + 1, inEnd, preOrder, inOrder, m);
        return root;
    }
}
