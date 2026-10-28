class Solution {
    public int maxArea(int[] heights) {
        int result = -1;
        int i = 0;
        int j = heights.length - 1;
        while(i < j && j > 0 && i < heights.length - 1) {
            result = Math.max(result, (j - i) * Math.min(heights[i], heights[j]));
            if(heights[i] < heights[j]) i += 1;
            else j -= 1;
        }
        return result;
    }
}
