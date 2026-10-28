class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
        // Target = 3
        int left = 0; // 0
        int right = matrix.length - 1; // 2

        while(left <= right) { // 2  >= 0 && 0 < 3
            int mid = left + (right - left) / 2; // 1
            int val = search(matrix[mid], target); // [10,11,16,20], 3 
            System.out.println("value = " + val);
            if(val == 2) return true;
            else if(val == -1) right = mid - 1;
            else left = mid + 1;
        }
        return false;        
    }

    /**
    * 0 -> Not found
    * -1 -> less
    * 1 -> more
    * 2 -> found
    */
    public int search(int[] nums, int target) { // [10,11,16,20], 3
        int left = 0; // 0
        int right = nums.length - 1; // 3
        int mid = left + (right - left)/2; // -1
        while(left <= right) { // -1 >= 0 && 0 < 4
            mid = left + (right - left)/2; // 0
            if(nums[mid] == target) { // 10 = 3; NO
                return 2;
            } else {
                if(nums[mid] < target) { // 10 < 3
                    left = mid + 1;
                } else {
                    right = mid - 1; // -1
                }
            }
        }
        if(nums[0] > target) return -1;
        return 1;
    }


}
