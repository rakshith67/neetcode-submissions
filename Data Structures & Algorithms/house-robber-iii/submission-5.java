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
    public int rob(TreeNode root) {
        Robbed result = dfs(root);
        return Math.max(result.exclude, result.include);
    }

    private Robbed dfs(TreeNode root) {
        if (root == null) {
            return new Robbed(0, 0);
        }
        Robbed left = dfs(root.left);
        Robbed right = dfs(root.right);

        int include = left.exclude + right.exclude + root.val;
        int exclude = Math.max(left.include, left.exclude) + Math.max(right.exclude, right.include);

        return new Robbed(exclude, include);
    }

    class Robbed {
        int exclude;
        int include;

        public Robbed(int exclude, int include) {
            this.exclude = exclude;
            this.include = include;
        }
    }
}