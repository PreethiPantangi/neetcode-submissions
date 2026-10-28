class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;
        int right = 0;
        while(right < s.length()) {
            Character ch = s.charAt(right);

            while(set.contains(ch)) {
                set.remove(s.charAt(left));
                left += 1;
            }
            set.add(ch);
            max = Math.max(max, right - left + 1);
            right += 1;
        }
        return max;
    }
}
