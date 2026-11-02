class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for(int j = i; j < s.length(); j++) {
                Character ch = s.charAt(j);
                if(set.contains(ch)) break;
                set.add(ch);
                max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }
}
