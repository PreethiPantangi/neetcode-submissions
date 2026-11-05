class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        if(pLen == 0) return new ArrayList<>();
        

        int[] pFreq = new int[26];
        for(Character ch : p.toCharArray()) {
            pFreq[ch - 'a'] += 1;
        }

        List<Integer> result = new ArrayList<>();
        int left = 0;
        for(int right = 0; right < s.length(); right++) {

            if(right - left + 1 > pLen) {
                left += 1;
            }

            if(right - left + 1 == pLen) {
                int[] sFreq = new int[26];
                String subString = s.substring(left, right + 1);
                for(Character ch : subString.toCharArray()) {
                    sFreq[ch - 'a'] += 1;
                }
                if(Arrays.toString(pFreq).equals(Arrays.toString(sFreq))) {
                    result.add(left);
                }
            }

        }
        return result;
    }
}
