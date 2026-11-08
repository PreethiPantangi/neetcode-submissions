class Solution {
    public int maxArea(int[] heights) {
        int water = 0;
        int left = 0;
        int right = heights.length - 1;

        while(left < right && right > 0 && left < heights.length - 1) {

            water = Math.max(water, (right- left) * Math.min(heights[left], heights[right]));
            if(heights[left] < heights[right]) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        return water;
    }
}
