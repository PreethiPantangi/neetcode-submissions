class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        for(int i = s.length()-1; i >= 0; i--) {
            if(length != 0 && (s.charAt(i) == ' ')) break;
            if(s.charAt(i) == ' ') continue;
            length += 1;
        }
        return length;
    }
}