package linkedin;

import leetcode.utility.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by PV029500 on 11/26/2016.
 */
public class BinaryTreeZigZagTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) return result;
        queue.offer(root);
        boolean zigzag = true;

        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<Integer>();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode treeNode = queue.poll();
                if (zigzag) {
                    tmp.add(treeNode.val);
                } else {
                    tmp.add(0, treeNode.val);
                }
                if (treeNode.left != null) queue.add(treeNode.left);
                if (treeNode.right != null) queue.add(treeNode.right);
            }
            zigzag = !zigzag;
            result.add(tmp);
        }

        return result;
    }

    //recursive

    public List<List<Integer>> zigzagLevelOrderRecurse(TreeNode root) {
        List<List<Integer>> sol = new ArrayList<List<Integer>>();
        travel(root, sol, 0);
        return sol;
    }

    private void travel(TreeNode curr, List<List<Integer>> sol, int level) {
        if (curr == null) return;

        if (sol.size() <= level) {
            sol.add(new LinkedList<Integer>());
        }

        List<Integer> collection = sol.get(level);
        if (level % 2 == 0) collection.add(curr.val);
        else collection.add(0, curr.val);

        travel(curr.left, sol, level + 1);
        travel(curr.right, sol, level + 1);
    }
}
