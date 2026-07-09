class Solution {
    /**
     * @param {number[][]} matrix
     * @param {number} target
     * @return {boolean}
     */
    searchMatrix(matrix, target) {
        let mLeft = 0;
        let mRight = matrix.length - 1;
        
        while(mLeft <= mRight) {
            let mMid = Math.floor(mLeft + (mRight - mLeft)/2);
            let res = this.binarySearch(matrix[mMid], 0, matrix[mMid].length, target);
            if (res == "right") {
                mLeft = mMid + 1;
            } else if (res == "left") {
                mRight = mMid - 1;
            } else if (res === true) {
                return true;
            }
        }
        return false;
    }

    binarySearch(nums, left, right, target) {
        if(left > right) {
            return Math.max(...nums) < target ? "right" : "left";
        }
        let mid = Math.floor(left + (right - left)/2);

        if(nums[mid] === target) {
            return true;
        }
        if(nums[mid] < target) {
            return this.binarySearch(nums, mid + 1, right, target);
        } else {
            return this.binarySearch(nums, left, mid - 1, target);
        }
    }

}
