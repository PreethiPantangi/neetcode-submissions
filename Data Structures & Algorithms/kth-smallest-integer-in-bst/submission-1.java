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

    private List<Integer> numbers = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        getInOrder(root);
        return numbers.get(k-1);
    }

    private void getInOrder(TreeNode root) {
        if(root == null) return;

        getInOrder(root.left);
        numbers.add(root.val);
        getInOrder(root.right);
    }
}
