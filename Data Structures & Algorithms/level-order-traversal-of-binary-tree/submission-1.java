/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<NodeLevel> queue = new ArrayDeque<>();
        queue.offer(new NodeLevel(root, 0));
        while (!queue.isEmpty()) {
            NodeLevel polled = queue.poll();
            if (polled.level == list.size()) {
                list.add(new ArrayList<>());
            }
            list.get(polled.level).add(polled.value.val);
            if (polled.value.left != null) {
                queue.add(new NodeLevel(polled.value.left, polled.level + 1));
            }
            if (polled.value.right != null) {
                queue.add(new NodeLevel(polled.value.right, polled.level + 1));
            }
        }
        return list;
    }

    private void fillLevelOrder(TreeNode root, List<List<Integer>> list, int level) {
        if (root == null) {
            return;
        }
        if (level == list.size()) {
            list.add(new ArrayList<>());
        }
        fillLevelOrder(root.left, list, level + 1);
        list.get(level).add(root.val);
        fillLevelOrder(root.right, list, level + 1);
    }
}

class NodeLevel {
    TreeNode value;
    int level;

    public NodeLevel(TreeNode value, int level) {
        this.value = value;
        this.level = level;
    }
}
