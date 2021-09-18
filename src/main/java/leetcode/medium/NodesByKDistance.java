package leetcode.medium;

import leetcode.utility.TreeNode;

import java.util.*;

public class NodesByKDistance {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<Integer>();
        kDistantNodes(target, K, result);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        pathHasTarget(root, target, queue);
        int currDistance = 1;
        TreeNode currNode = target;
        while (currDistance <= K && queue.size() > 0) {
            TreeNode node = queue.poll();
            if (currDistance == K)
                result.add(node.val);
            if (Objects.equals(currNode, node.right)) {
                kDistantNodes(node.left, currDistance + 1, K, result);
            } else {
                kDistantNodes(node.right, currDistance + 1, K, result);
            }
            currNode = node;
            currDistance++;
        }
        return result;
    }

    private boolean pathHasTarget(TreeNode curr, TreeNode target, Queue<TreeNode> queue) {
        if (curr == null) return false;
        if (curr == target) {
            return true;
        }
        if (pathHasTarget(curr.right, target, queue) || pathHasTarget(curr.left, target, queue)) {
            queue.offer(curr);
            return true;
        }
        return false;
    }


    private void kDistantNodes(TreeNode node, int soFar, int K, List<Integer> result) {
        if (node == null) return;
        if (soFar == K) {
            result.add(node.val);
            return;
        }
        kDistantNodes(node.left, soFar + 1, K, result);
        kDistantNodes(node.right, soFar + 1, K, result);
    }

    private void kDistantNodes(TreeNode node, int soFar, List<Integer> result) {
        if (node == null) return;
        if (soFar == 0) {
            result.add(node.val);
            return;
        }
        kDistantNodes(node.left, soFar - 1, result);
        kDistantNodes(node.right, soFar - 1, result);
    }
}
