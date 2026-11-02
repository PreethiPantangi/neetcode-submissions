class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int num: nums) {
            total += num;
        }

        if(total % 2 != 0) return false;
        Boolean[][] memo = new Boolean[nums.length][total/2 + 1];
        return isSubsetPresent(nums, 0, total/2, memo);

    }

    public boolean isSubsetPresent(int[] nums, int index, int target, Boolean[][] memo) {
        if(index == nums.length) return target == 0;
        if(target < 0) return false;

        if(memo[index][target] != null) return memo[index][target];

        memo[index][target] = isSubsetPresent(nums, index + 1, target, memo) || isSubsetPresent(nums, index + 1, target - nums[index], memo);

        return memo[index][target];
    }
}
