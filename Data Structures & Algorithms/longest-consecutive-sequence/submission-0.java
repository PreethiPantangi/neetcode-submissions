class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);

        int result = 1;
        int maxLength = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                continue;
            } else if (nums[i] == nums[i-1] + 1) {
                maxLength += 1;
            } else {
                result = Math.max(result, maxLength);
                maxLength = 1;
            }
        }
        result = Math.max(result, maxLength);
        return result;
    }
}
