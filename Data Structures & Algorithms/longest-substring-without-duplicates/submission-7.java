class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int max = 0;

        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        while(j < s.length()) {

            while(set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i += 1;
            }

            set.add(s.charAt(j));
            max = Math.max(max, j - i + 1);
            j += 1;
        }
        return max;
    }
}
