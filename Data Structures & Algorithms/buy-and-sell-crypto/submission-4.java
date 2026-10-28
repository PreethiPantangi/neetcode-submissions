class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = left + 1;
        int max = 0;
        while(left < right && right < prices.length) {
            int profit = prices[right] - prices[left];
            System.out.println(prices[left] + " " + prices[right] + " " + profit);
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
