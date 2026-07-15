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

    private int preorderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderIndex++]);
        int index = findIndex(root.val, inorder);
        root.left = buildTree(preorder, inorder, start, index - 1);
        root.right = buildTree(preorder, inorder, index + 1, end);
        return root;
    }

    private int findIndex(int key, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
