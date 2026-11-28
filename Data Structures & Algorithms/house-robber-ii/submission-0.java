class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;

        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int[] housesOne = new int[n - 1];
        int[] housesTwo = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            housesOne[i] = nums[i];
            housesTwo[i] = nums[i + 1];
        }

        int[] memo1 = new int[n - 1];
        int[] memo2 = new int[n - 1];

        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);

        int one = dp(housesOne, n - 2, memo1);
        int two = dp(housesTwo, n - 2, memo2);

        return Math.max(one, two);
    }

    private int dp(int[] nums, int index, int[] memo) {

        if(index < 0) return 0;
        if(memo[index] != -1) return memo[index];

        int notTake = dp(nums, index-1, memo);
        int take = nums[index] + dp(nums, index-2, memo);

        memo[index] = Math.max(take, notTake);
        return memo[index];
    }

}
