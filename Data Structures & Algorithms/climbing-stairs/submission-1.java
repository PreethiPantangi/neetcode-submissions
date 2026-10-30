class Solution {
    public int climbStairs(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int[] memory = new int[n+1];
        memory[0] = 0;
        memory[1] = 1;
        memory[2] = 2;
        int index = 3;
        while(index != n+1) {
            memory[index] = memory[index-2] + memory[index-1];
            index += 1;
        }
        return memory[n];
    }
}
