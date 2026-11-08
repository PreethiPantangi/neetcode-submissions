class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            while(left < right && !isAlphaNumeric(s.charAt(left))) {
                left += 1;
            }

            while(right > left && !isAlphaNumeric(s.charAt(right))) {
                right -= 1;
            }

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left += 1;
            right -= 1;
        }
        return true;
    }

    private boolean isAlphaNumeric(Character ch) {
        return (ch >= 'A' && ch <= 'Z') ||
               (ch >= 'a' && ch <= 'z') ||
               (ch >= '0' && ch <= '9');
    }
}
