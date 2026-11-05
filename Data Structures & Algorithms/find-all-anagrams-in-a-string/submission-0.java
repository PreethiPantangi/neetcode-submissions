class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        int[] pFreq = new int[26];
        for(Character ch : p.toCharArray()) {
            pFreq[ch - 'a'] += 1;
        }

        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < s.length(); j++) {
                if(j - i + 1 == p.length()) {
                    int[] sFreq = new int[26];
                    String subString = s.substring(i,j+1);
                    for(Character ch : subString.toCharArray()) {
                        sFreq[ch - 'a'] += 1;
                    }
                    if(Arrays.toString(pFreq).equals(Arrays.toString(sFreq))) {
                        result.add(i);
                    }
                }                
            }
        }
        return result;
    }
}
