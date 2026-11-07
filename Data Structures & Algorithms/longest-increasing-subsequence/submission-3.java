
class Solution {

    public int lengthOfLIS(int[] nums) {
        int[][] memo = new int[nums.length][nums.length+1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return getLength(nums, 0, -1, memo);
    }

    public int getLength(int[] nums, int index, int prev, int[][] memo) {

        if(index == nums.length) {
            return 0;
        }

        if(memo[index][prev + 1] != -1) return memo[index][prev + 1];
        
        int length = getLength(nums, index+1, prev, memo);
        if(prev == -1 || nums[index] > nums[prev]) {
            length = Math.max(length, 1 + getLength(nums, index + 1, index, memo));
        }
        memo[index][prev + 1] = length;
        return memo[index][prev + 1];
    }
}
