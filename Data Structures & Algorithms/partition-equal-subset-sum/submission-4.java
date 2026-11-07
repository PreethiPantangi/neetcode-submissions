class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        if(sum % 2 !=  0) return false;
        Boolean[][] memo = new Boolean[nums.length][sum/2+1];
        return isSubsetPresent(nums, 0, sum/2, memo);
    }

    private boolean isSubsetPresent(int[] nums, int index, int target, Boolean[][] memo) {

        if(index == nums.length) return target == 0;
        if(target < 0) return false;

        if(memo[index][target] != null) return memo[index][target];

        memo[index][target] = isSubsetPresent(nums, index + 1, target - nums[index], memo) || isSubsetPresent(nums, index + 1, target, memo);

        return memo[index][target];
    }
}
