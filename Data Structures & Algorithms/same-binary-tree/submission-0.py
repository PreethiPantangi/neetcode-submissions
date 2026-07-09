# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque

class Solution:
    def breadthFirstSearch(self, tree1, tree2):
        if tree1 is None and tree2 is None:
            return True
        if tree1 is None or tree2 is None:
            return False
        tree1_queue = deque([tree1])
        tree2_queue = deque([tree2])

        while tree1_queue and tree2_queue:
            tree1_node = tree1_queue.popleft()
            tree2_node = tree2_queue.popleft()
            if tree1_node.val != tree2_node.val:
                return False

            if (tree1_node.left and not tree2_node.left) or (not tree1_node.left and tree2_node.left):
                return False
            if (tree1_node.right and not tree2_node.right) or (not tree1_node.right and tree2_node.right):
                return False

            if tree1_node.left:
                tree1_queue.append(tree1_node.left)
            if tree2_node.left:
                tree2_queue.append(tree2_node.left)
            if tree1_node.right:
                tree1_queue.append(tree1_node.right)
            if tree2_node.right:
                tree2_queue.append(tree2_node.right)
                
        return True

    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        return self.breadthFirstSearch(p, q)