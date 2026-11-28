class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return dp(nums, n-1, memo); // [1,1,3,3] , 3
    }

    private int dp(int[] nums, int index, int[] memo) { // [1,1,3,3] , -1

        if(index < 0) return 0;  // -1 < 0; YES
        if(memo[index] != -1) return memo[index];

        int notTake = dp(nums, index - 1, memo); // dp(3-1) => dp(2); dp(2-1) => dp(1); dp(1-1) => dp(0); dp(0-1) => dp(-1) => 0
        int take = nums[index] + dp(nums, index - 2, memo); // dp(3-2) => dp(1)
        memo[index] = Math.max(notTake, take);
        return memo[index];
    }
}
