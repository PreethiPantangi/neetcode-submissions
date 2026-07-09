class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(0, nums.length - 1, nums, target);
    }

    private int binarySearch(int low, int high, int[] nums, int target) {
        if(low > high) return -1;

        int mid = low + (high - low)/2;
        if(nums[mid] == target) {
            return mid;
        } 
        if(nums[mid] < target) {
            return binarySearch(mid+1, high, nums, target);
        } else {
            return binarySearch(low, mid-1, nums, target);
        }
    }
}
