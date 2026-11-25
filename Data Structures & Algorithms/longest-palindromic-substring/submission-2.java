class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int index = 0;

        for(int i = 0; i < s.length(); i++) {
            
            int left = i;
            int right = i;

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    index = left;
                }
                left -= 1;
                right += 1;
            }


            left = i;
            right = i + 1;

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    index = left;
                }
                left -= 1;
                right += 1;
            }
        }
        return s.substring(index, index+maxLen);
    }

}
