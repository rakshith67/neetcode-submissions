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

public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serializePreOrder(root, builder);
        System.out.println(builder.toString());
        return builder.toString();
    }

    private void serializePreOrder(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("#,");
            return;
        }
        builder.append(root.val);
        builder.append(',');
        serializePreOrder(root.left, builder);
        serializePreOrder(root.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int[] start = new int[1];
        return buildTree(nodes, start);
    }

    private TreeNode buildTree(String[] nodes, int[] start) {
        // System.out.println(start[0]);
        if ("#".equals(nodes[start[0]])) {
            start[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(nodes[start[0]]));
        start[0]++;
        if (start[0] < nodes.length) {
            root.left = buildTree(nodes, start);
            root.right = buildTree(nodes, start);
        }
        return root;
    }
}
