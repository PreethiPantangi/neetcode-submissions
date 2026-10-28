class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length - 1;
        int i = 0; 
        int j = len;
        while (i < j && j >= 0 && i < len) {
            if(nums[j] + nums[i] == target) {
                return new int[]{i+1,j+1};
            } else if (nums[j] + nums[i] < target) {
                i += 1;
            } else {
                j -= 1;
            }
        }
        return new int[]{i+1, j+1};
    }
}
