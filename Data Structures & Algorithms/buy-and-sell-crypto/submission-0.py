class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        result = 0
        for buyDay in range(len(prices)):
            for sellDay in range(buyDay+1, len(prices)):
                if prices[sellDay] - prices[buyDay] > result:
                    result = max(result, prices[sellDay] - prices[buyDay])
        return result 