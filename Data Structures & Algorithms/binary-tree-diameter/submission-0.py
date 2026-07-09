# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def diameter(self, root, result):
        if root is None:
            return 0
        leftHeight = self.diameter(root.left, result)
        rightHeight = self.diameter(root.right, result)
        result[0] = max(result[0], leftHeight + rightHeight)
        return 1 + max(leftHeight, rightHeight)

    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        result = [0]
        self.diameter(root, result)
        return result[0]