package topics.trees;


import leetcode.utility.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by PV029500 on 10/25/2016.
 */
public class InorderIterative {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr != null || !s.empty()) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            result.add(curr.val);
            curr = curr.right;

        }
        return result;
    }
}
