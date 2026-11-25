class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        String result = "";
        Map<String, Boolean> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                String word = s.substring(i, j+1);
                if(map.containsKey(word) || isPalindrome(word)) {
                    if(j-i+1 > maxLength) {
                        result = word;
                        maxLength = j - i + 1;
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String word) {
        int i = 0;
        int j = word.length()-1;
        while(i <= j) {
            if(word.charAt(i) != word.charAt(j))  {
                return false;
            }
            i += 1;
            j -= 1;
        }
        return true;
    }
}
