# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        temp = ListNode()
        rootNode = temp
        while list1 and list2:
            if list1.val < list2.val:
                rootNode.next = list1
                list1 = list1.next
            else:
                rootNode.next = list2
                list2 = list2.next
            rootNode = rootNode.next
        if list1:
            rootNode.next = list1
        if list2:
            rootNode.next = list2
        return temp.next