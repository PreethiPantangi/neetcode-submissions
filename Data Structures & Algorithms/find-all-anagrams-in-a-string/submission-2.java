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
        int[] strFreq = new int[26];
        for(int right = 0; right < s.length(); right++) {

            if(right - left + 1 > pLen) {
                strFreq[s.charAt(left) - 'a'] -= 1;
                left += 1;
            }
            strFreq[s.charAt(right) - 'a'] += 1;

            if(right - left + 1 == pLen) {
                if(Arrays.equals(pFreq, strFreq)) {
                    result.add(left);
                }
            }

        }
        return result;
    }
}
