class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return climb(n, memo);
    }

    public int climb(int n, int[] memo) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;

        if(memo[n] != -1) return memo[n];
        memo[n] = climb(n-2, memo) + climb(n-1, memo);
        return memo[n];
    }
}
