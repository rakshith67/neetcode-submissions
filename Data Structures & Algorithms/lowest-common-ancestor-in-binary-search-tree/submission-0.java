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
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        result = null;
        fillLCA(root, p, q);
        return result;
    }

    private void fillLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || result != null) {
            return;
        }
        if (p.val < root.val && q.val < root.val) {
            fillLCA(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            fillLCA(root.right, p, q);
        } else {
            result = root;
        }        
    }
}
