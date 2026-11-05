class Solution {
    public int minimumRecolors(String blocks, int k) {
        int left = 0;
        int right = 0;

        int whiteCount = 0;
        int min = Integer.MAX_VALUE;

        while(right < blocks.length()) {

            if(blocks.charAt(right) == 'W') {
                whiteCount += 1;
            }

            if(right - left + 1 > k) {
                if(blocks.charAt(left) == 'W') {
                    whiteCount -=1 ;
                }
                left += 1;
            }
            if(right - left + 1 == k) {
                min = Math.min(min, whiteCount);
            }
            right += 1;
        }
        return min;
    }

}