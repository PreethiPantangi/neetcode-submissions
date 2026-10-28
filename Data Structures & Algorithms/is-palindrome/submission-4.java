class Solution {
    public boolean isPalindrome(String s) {
        String str = getAlphanumericString(s);
        int i = 0; 
        int j = str.length()-1;
        while(i != j && i < str.length() && j >= 0) {
            if(str.charAt(i) == str.charAt(j)) {
                i += 1;
                j -= 1;
            } else {
                return false;
            }
        }
        return true;
    }

    public String getAlphanumericString(String s) {
        String str = "";
        for(int i = 0; i < s.length(); i++) {
            int ascii = (int) s.charAt(i);
            if( (ascii >= 48 && ascii <= 57) || (ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122) ) {
                str += Character.toLowerCase(s.charAt(i));
            }
        }
        return str;
    }
}
