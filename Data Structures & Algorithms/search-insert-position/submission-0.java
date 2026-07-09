class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(0, nums.length, nums, target);
    }

    private int binarySearch(int left, int right, int[] nums, int target) {
        if(left >= right) {
            return left;
        }

        int mid = left + (right - left) / 2;

        if(nums[mid] < target) {
            return binarySearch(mid+1, right, nums, target);
        } else {
            return binarySearch(left, mid, nums, target);
        }
    }
}