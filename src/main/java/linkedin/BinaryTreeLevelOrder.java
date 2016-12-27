package linkedin;

import leetcode.utility.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by PV029500 on 11/28/2016.
 */
public class BinaryTreeLevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return  result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int size;

        while(!queue.isEmpty()) {
            size = queue.size();
            List<Integer> curr = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                curr.add(queue.poll().val);
            }
            result.add(curr);
        }
        return result;
    }

    //recursive
    public List<List<Integer>> levelOrderRecurse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return  result;
        return levelOrderRecurseHelper(root, result, new ArrayList<Integer>(), 0);
    }

    public List<List<Integer>> levelOrderRecurseHelper(TreeNode root, List<List<Integer>> result, List<Integer> curr, int depth) {

        if (result.size() <= depth) {
            curr = new ArrayList<Integer>();
            result.add(curr);
        }
        result.get(depth).add(root.val);
        if (root.left != null)
            result = levelOrderRecurseHelper(root.left, result, curr, depth + 1);
        if (root.right != null)
            result = levelOrderRecurseHelper(root.right, result, curr, depth + 1);
        return result;
    }
}
