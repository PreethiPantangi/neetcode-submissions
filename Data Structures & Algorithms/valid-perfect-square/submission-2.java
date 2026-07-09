class Solution {
    public boolean isPerfectSquare(int num) {
        long low = 1;
        long high = num;
        while(low <= high) {
            long mid = low + (high - low) / 2;
            long prod = mid * mid;
            if (prod > num) high = mid - 1;
            else if (prod < num) low = mid + 1;
            else return true;
        }
        return false;
    }
}