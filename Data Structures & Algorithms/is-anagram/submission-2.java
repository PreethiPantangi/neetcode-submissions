class Solution {
    public boolean isAnagram(String s, String t) {
        int[] frequency = new int[26];
        Arrays.fill(frequency, 0);
        for(int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a'] += 1;
        }
        for(int i = 0; i < t.length(); i++) {
            if(frequency[t.charAt(i) - 'a'] == -1) return false;
            frequency[t.charAt(i) - 'a'] -= 1;
        }
        for(int i = 0; i < 26; i++) {
            if(frequency[i] != 0) return false;
        }
        return true;
    }
}
