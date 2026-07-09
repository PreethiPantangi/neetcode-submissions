class Solution {
    public int arrangeCoins(int n) {
        int result = 0;
        for(int i = 1; i <= n; i++) {
            if(n-i >= 0) {
                result += 1;
                n = n - i;
            }
        }
        return result;
    }
}