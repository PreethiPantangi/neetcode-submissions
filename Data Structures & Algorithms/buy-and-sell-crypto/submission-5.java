class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        while(right < prices.length) {
            int profit = prices[right] - prices[left]; 
            if(profit >= 0 || profit > max) {
                max = Math.max(max, profit);
            } else {
                left = right;
            }
            right += 1;
        }
        return max;
    }
}
