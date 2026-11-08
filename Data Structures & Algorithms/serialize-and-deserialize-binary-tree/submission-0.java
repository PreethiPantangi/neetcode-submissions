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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeHelper(root);
    }

    private String serializeHelper(TreeNode root) {
        if(root == null) return "null";

        return root.val + "," + serializeHelper(root.left) + "," + serializeHelper(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));

        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {
        String str = queue.poll();
        
        if(str.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);
        return root;
    }
}
