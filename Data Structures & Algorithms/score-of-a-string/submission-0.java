class Solution {
    public int scoreOfString(String s) {
        int result = 0;
        int i = 0;
        int j = 0;
        while(j < s.length()) {
            result += Math.abs((s.charAt(i) - '0') - (s.charAt(j) - '0'));
            i = j;
            j += 1;
        }
        return result;
    }
}