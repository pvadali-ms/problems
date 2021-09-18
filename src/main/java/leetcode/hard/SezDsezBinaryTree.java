package leetcode.hard;

import leetcode.utility.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by PV029500 on 9/28/2016.
 */
public class SezDsezBinaryTree {

    String delimiter = "";

    public String serialize(TreeNode node) {
        StringBuilder data = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                data.append(delimiter).append("null");
                continue;
            }
            queue.add(temp.left);
            queue.add(temp.right);
            data.append(delimiter).append(String.valueOf(temp.val));
            delimiter = ",";
        }
        return data.toString();
    }

    public TreeNode deSerialize(String data) {
        if (data == null || data.length() == 0 || data.equals("null")) return null;
        String[] arr = data.split(",");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            if (queue.poll() == null) continue;
            TreeNode temp = queue.poll();
            if (arr[i].equals("null")) {
                temp.left = null;
                queue.add(null);
            } else {
                temp.left = new TreeNode(Integer.valueOf(arr[i]));
                queue.add(temp.left);
            }
            i++;
            if (arr[i].equals("null")) {
                temp.right = null;
                queue.add(null);
            } else {
                temp.right = new TreeNode(Integer.valueOf(arr[i]));
                queue.add(temp.right);
            }
            i++;
        }
        return root;
    }
}
