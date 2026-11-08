class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while(low < high) {
            int mid = low + (high - low) / 2;
            int currentNum = nums[mid];
            int rightNum = nums[high];            

            if(currentNum > rightNum) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
