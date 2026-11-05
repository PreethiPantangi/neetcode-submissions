class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int result = Integer.MIN_VALUE;
        while(j < s.length()) {

            while(set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i += 1;
            }

            result = Math.max(result, j - i + 1);
            set.add(s.charAt(j));
            j += 1;
        }
        return result;
    }
}
