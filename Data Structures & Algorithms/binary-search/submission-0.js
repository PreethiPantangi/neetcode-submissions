class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number}
     */
    search(nums, target) {
        return this.binarySearch(nums, 0, nums.length - 1, target);
    }
    binarySearch(nums, left, right, target) {
        if (left > right) {
            return -1;
        }
        let mid = Math.floor(left + (right - left)/2);
        if(nums[mid] == target) {
            return mid;
        }
        if(nums[mid] < target) {
            return this.binarySearch(nums, mid+1, right, target);
        } else {
            return this.binarySearch(nums, left, mid - 1, target);
        }
    }
}
