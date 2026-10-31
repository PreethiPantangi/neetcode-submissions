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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, List<TreeNode>> map = new HashMap<>();
        ancestorMap(root, new ArrayList<>(), map);
        
        List<TreeNode> pAncestors = map.get(p);
        List<TreeNode> qAncestors = map.get(q);

        TreeNode result = root;
        int len = Math.min(pAncestors.size(), qAncestors.size());

        for(int i = 0; i < len; i++) {
            if(pAncestors.get(i) == qAncestors.get(i)) {
                result = pAncestors.get(i);
            } else {
                break;
            }
        }

        return result;
    }

    public void ancestorMap(TreeNode root, List<TreeNode> ancestors, HashMap<TreeNode, List<TreeNode>> map) {

        if(root == null) return;

        List<TreeNode> currentPath = new ArrayList<>(ancestors);
        currentPath.add(root);
        map.put(root, currentPath);

        ancestorMap(root.left, currentPath, map);
        ancestorMap(root.right, currentPath, map);
    }
}
