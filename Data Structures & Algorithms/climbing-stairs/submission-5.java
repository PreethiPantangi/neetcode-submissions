class Solution {
    public int climbStairs(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int prevPrev = 1;
        int prev = 2;
        for(int i = 3; i < n+1; i++) { // i = 3
            int curr = prev + prevPrev; // 2 + 1 = 3
            prevPrev = prev; // 2
            prev = curr; // 3            
        }
        return prev;
    }
}
