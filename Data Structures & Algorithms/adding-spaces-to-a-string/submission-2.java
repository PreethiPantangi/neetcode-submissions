class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder();
        int n = s.length();
        int j = 0;
        
        for(int i = 0; i < n; i++) {
            if(j < spaces.length && i == spaces[j]) {
                result.append(" ");
                j += 1;
            }

            result.append(s.charAt(i));
        }

        return result.toString();
    }
}
