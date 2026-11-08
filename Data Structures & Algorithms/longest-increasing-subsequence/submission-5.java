
class Solution {

    public int lengthOfLIS(int[] nums) {
        int[][] memo = new int[nums.length][nums.length+1];
        for(int[] row: memo) {
            Arrays.fill(row, -1);
        }
        return getLength(nums, 0, -1, memo);
    }

    private int getLength(int[] nums, int index, int prevIndex, int[][] memo) {
        if(index == nums.length) return 0;

        if(memo[index][prevIndex+1] != -1) return memo[index][prevIndex+1];

        int length = getLength(nums, index + 1, prevIndex, memo);
        if(prevIndex == -1 || nums[index] > nums[prevIndex]) {
            int includedLength = 1 + getLength(nums, index+1, index, memo);
            length = Math.max(length, includedLength);
        }
        memo[index][prevIndex+1] = length;
        return length;
    }
}