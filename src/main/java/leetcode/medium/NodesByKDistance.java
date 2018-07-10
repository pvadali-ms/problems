package leetcode.medium;

import leetcode.utility.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class NodesByKDistance {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<Integer>();
        kDistantNodes(target, K, result);
        Queue<Map<TreeNode, String>> queue = new LinkedList<Map<TreeNode, String>>();
        pathHasTarget(root, target, queue);
        int currDistance = 1;
        while (currDistance <= K && queue.size() > 0) {
            Map<TreeNode, String> m = queue.poll();
            Map.Entry<TreeNode, String> it = m.entrySet().iterator().next();
            System.out.println(it.getKey().val);
            if (currDistance == K)
                result.add(it.getKey().val);
            if (Objects.equals(it.getValue(), "right")) {
                kDistantNodes(it.getKey().left, currDistance + 1, K, result);
            } else {
                kDistantNodes(it.getKey().right, currDistance + 1, K, result);
            }
            currDistance++;
        }
        return result;
    }

    private boolean pathHasTarget(TreeNode curr, TreeNode target, Queue<Map<TreeNode, String>> queue) {
        if (curr == null) return false;
        if (curr == target) {
            return true;
        }
        Map<TreeNode, String> m = new HashMap<>();
        if (pathHasTarget(curr.right, target, queue)) {
            m.put(curr, "right");
            queue.offer(m);
            return true;
        } else if (pathHasTarget(curr.left, target, queue)) {
            m.put(curr, "left");
            queue.offer(m);
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
