
class Solution {

    public int lengthOfLIS(int[] nums) {
        int[][] memo = new int[nums.length][nums.length+1];
        for(int[] row: memo) {
            Arrays.fill(row, -1);
        }
        return dfs(nums, 0, -1, memo);
    }

    private int dfs(int[] nums, int i, int j, int[][] memo) {

        if(i == nums.length) return 0;

        if(memo[i][j+1] != -1) return memo[i][j+1];

        int len = dfs(nums, i+1, j, memo);
        if(j == -1 || nums[j] < nums[i]) {
            len = Math.max(len, 1+dfs(nums, i+1, i, memo));
        }
        memo[i][j+1] = len;
        return len;
    }
}