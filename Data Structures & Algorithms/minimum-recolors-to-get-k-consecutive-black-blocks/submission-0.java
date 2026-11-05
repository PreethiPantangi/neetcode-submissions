class Solution {
    public int minimumRecolors(String blocks, int k) {
        int left = 0;
        int right = k-1;

        int min = Integer.MAX_VALUE;

        while(right < blocks.length()) {

            int whiteCount = getWhiteCount(blocks.substring(left, right+1));
            min = Math.min(min, whiteCount);

            left += 1;
            right += 1;

        }
        return min;
    }

    private int getWhiteCount(String str) {
        int count = 0;
        for(Character ch : str.toCharArray()) {
            if(ch == 'W') count += 1;
        }
        return count;
    }
}