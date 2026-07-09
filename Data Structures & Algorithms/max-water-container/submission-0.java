class Solution {
    public int maxArea(int[] heights) {
        int result = 0; // 0 
        int i = 0; // 0 
        int j = heights.length - 1; // 7
        while(i != j && i < j) { // 1 != 5 && 1 < 5
            int water = (j - i) * Math.min(heights[i], heights[j]); // 4 * 7 = 28
            if(water > result) result = water; // 15 > 36; result = 36
            if(heights[i] < heights[j]) i += 1; // i = 1
            else j -= 1; // j = 5
        }
        return result;
    }
}
