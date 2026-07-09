class Solution {
    public int mySqrt(int x) {
        int low = 1;
        int high = x;
        int result = 0;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if((long) mid * mid > x) {
                high = mid - 1;
            } else if ((long) mid * mid < x) {
                low = mid + 1;
                result = mid;
            } else {
                return mid;
            }
        }
        return result;
    }
}