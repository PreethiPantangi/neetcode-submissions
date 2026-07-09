class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        _map = {}
        for i in range(len(nums)):
            if nums[i] in _map:
                return True
            else:
                _map[nums[i]] = 1
        return False