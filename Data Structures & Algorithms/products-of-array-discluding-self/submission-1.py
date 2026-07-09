class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        product = 1
        zeroCount = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                product *= nums[i]
            else:
                zeroCount += 1
        
        if zeroCount > 1:
            return [0] * len(nums)

        for i in range(len(nums)):
            if zeroCount > 0:
                nums[i] = product if (nums[i] == 0) else 0
            else:
                nums[i] = product // nums[i]
        return nums

