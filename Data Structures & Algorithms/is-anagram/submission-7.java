class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] nums = new int[26];
        for(int i = 0; i < s.length(); i++) {
            nums[(int) s.charAt(i) - 'a'] += 1;
            nums[(int) t.charAt(i) - 'a'] -= 1;
        }
        for(int i = 0; i < 26; i++) {
            if(nums[i] < 0) return false;
        }
        return true;
    }
}
