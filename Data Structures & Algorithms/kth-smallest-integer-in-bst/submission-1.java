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
    int count;
    int result = -1;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        fillKthSmallest(root);
        return result;
    }

    private void fillKthSmallest(TreeNode root) {
        if (root == null || count < 0) {
            return;
        }
        fillKthSmallest(root.left);
        count--;
        if (count == 0) {
            result = root.val;
        }
        fillKthSmallest(root.right);
    }
}
