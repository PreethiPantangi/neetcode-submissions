class Solution {
    public boolean isPalindrome(String s) {
        String str = constructString(s);
        int i = 0;
        int j = str.length() - 1;
        while(i != j && i < j) {
            if(Character.toLowerCase(str.charAt(i)) == Character.toLowerCase(str.charAt(j))) {
                i += 1;
                j -= 1;
            } else {
                return false;
            }
        }
        return true;
    }

    private String constructString(String s) {
        String result = "";
        for(int i = 0; i < s.length(); i++) {
            int ascii = (int) s.charAt(i);
            if((ascii >= 48 && ascii <= 57) || (ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122)) {
                result += s.charAt(i);
            }
        }
        return result;
    }
}
