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
    private List<Integer> result = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        getInOrder(root);
        for(int i = 1; i < result.size(); i++) {
            if(result.get(i-1) >= result.get(i)) return false;
        }
        return true;
    }

    private void getInOrder(TreeNode root) {

        if(root == null) return;
        getInOrder(root.left);
        result.add(root.val);
        getInOrder(root.right);
    }
}
