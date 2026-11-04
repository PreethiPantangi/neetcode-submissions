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

    int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeHelper(root);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index = 0;
        return deserializeHelper(data.split(","));
    }

    private String serializeHelper(TreeNode root) {
        if(root == null) return "null,";
        return root.val + "," + serializeHelper(root.left) + serializeHelper(root.right);
    }

    private TreeNode deserializeHelper(String[] values) {
        String value = values[index];
        index += 1;

        if(value.equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = deserializeHelper(values);
        root.right = deserializeHelper(values);
        return root;
    }
}
