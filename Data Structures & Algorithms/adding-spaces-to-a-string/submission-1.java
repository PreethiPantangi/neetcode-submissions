class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder();
        int addedSpacesCount = 0;
        int currentIndex = 0;

        for(int i = 0; i < spaces.length; i++) {
            int index = spaces[i];
            result.append(s.substring(currentIndex, index) + " ");
            currentIndex = index;
        }

        if(currentIndex < s.length()) {
            result.append(s.substring(currentIndex, s.length()));
        }
        return result.toString();
    }
}
