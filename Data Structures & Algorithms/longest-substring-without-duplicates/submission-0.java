class Solution {
    public int lengthOfLongestSubstring(String s) { // abcabcbb
        if(s.length() == 0) return 0;
        int result = 0;
        Set<Character> sett = new HashSet<>();
        int i = 0;
        int j = 0;
        while(j < s.length()) { // 3 < 8
            if(sett.contains(s.charAt(j))) { // a
                sett.remove(s.charAt(i)); // {b,c}
                i += 1; // 1
            } else {
                sett.add(s.charAt(j)); // {a, b, c}
                result = Math.max(result, (j - i + 1)); // 3
                j += 1; // 3
            }
        }
        return result;
    }
}

