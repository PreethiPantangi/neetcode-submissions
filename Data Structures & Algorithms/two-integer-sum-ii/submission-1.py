class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        if len(numbers) == 0:
            return[0]
        if len(numbers) == 1:
            return [1]
        if len(numbers) == 2:
            return [1,2]
        
        target_sum = 0
        left, right = 0, len(numbers) - 1

        while left < right:
            desiredTarget = numbers[left] + numbers[right]
            if desiredTarget == target:
                return [left+1, right+1]
            else:
                if desiredTarget < target:
                    left += 1
                else:
                    right -= 1
        
