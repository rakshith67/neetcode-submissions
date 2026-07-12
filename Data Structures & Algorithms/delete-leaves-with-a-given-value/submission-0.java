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
    boolean isModified = false;
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode parent = new TreeNode(-1);
        parent.right = root;
        int count = 0;
        while (parent.right != null) {
            removeLeafNodes(root, parent, target, true);
            if (!isModified) {
                break;
            }
            isModified = false;
        }
        return parent.right;
    }

    private void removeLeafNodes(TreeNode root, TreeNode parent, int target, boolean isRight) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && root.val == target) {
            if (isRight) {
                parent.right = null;
            } else {
                parent.left = null;
            }
            isModified = true;
        }
        removeLeafNodes(root.left, root, target, false);
        removeLeafNodes(root.right, root, target, true);
    }
}