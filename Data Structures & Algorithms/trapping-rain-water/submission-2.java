class Solution {
    public int trap(int[] height) {
        
        int total = 0;
        int length = height.length - 1;
        int left = 0;
        int right = length;
        int leftMax = height[left];
        int rightMax = height[right];

        while(left < right) {
            if(leftMax < rightMax) {
                left += 1;
                leftMax = Math.max(leftMax, height[left]);
                total += leftMax - height[left];
            } else {
                right -= 1;
                rightMax = Math.max(rightMax, height[right]);
                total += rightMax - height[right];
            }
        }

        return total;
    }
}
