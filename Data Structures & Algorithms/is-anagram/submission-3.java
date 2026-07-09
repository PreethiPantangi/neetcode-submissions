class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] frequency = new int[26];
        for(int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a'] += 1;
            frequency[t.charAt(i) - 'a'] -= 1;
        }
        for(int i = 0; i < 26; i++) {
            if(frequency[i] != 0) return false;
        }
        return true;
    }
}
