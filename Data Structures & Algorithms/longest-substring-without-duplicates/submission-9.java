class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;

        Set<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;
        int maxLen = 0;

        while(right < s.length()) {

            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left += 1;
            }

            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
            right += 1;
        }
        return maxLen;
    }
}
