package topics.trees;

import leetcode.utility.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by PV029500 on 10/26/2016.
 */
public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int size;
        while (!queue.isEmpty() && queue.peek() != null) {
            size = queue.size();
            List<Integer> curr = new LinkedList<Integer>();
            for (int i = 0; i < size; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                curr.add(queue.poll().val);
            }
            result.add(curr);
        }
        return result;
    }
}
