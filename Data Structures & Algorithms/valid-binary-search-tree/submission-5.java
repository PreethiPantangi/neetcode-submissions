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
        List<Integer> inOrderResult = new ArrayList<>();
        getInOrder(root, inOrderResult);
        for(int i = 1; i < inOrderResult.size(); i++) {
            if(inOrderResult.get(i) <= inOrderResult.get(i-1)) return false;
        }
        return true;
    }

    public void getInOrder(TreeNode root, List<Integer> numbers) {
        if(root == null) return;
        getInOrder(root.left, numbers);
        numbers.add(root.val);
        getInOrder(root.right, numbers);
    }
}
