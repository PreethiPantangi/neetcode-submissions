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
    private List<Integer> inOrder = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        getInorder(root);
        System.out.println(inOrder);
        return isSorted(inOrder);
    }

    private void getInorder(TreeNode node) {
        if(node == null) return;
        getInorder(node.left);
        inOrder.add(node.val);
        getInorder(node.right);
    }

    private boolean isSorted(List<Integer> nums) {
        for(int i = 1; i < nums.size(); i++) {
            if(nums.get(i) <= nums.get(i-1)) return false;
        }
        return true;
    }
}
