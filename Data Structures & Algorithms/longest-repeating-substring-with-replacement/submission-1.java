class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int maxFreq = 0;
        int left = 0;
        int[] freq = new int[26];

        for (int right = 0; right < s.length(); right++) {
            
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            int changes = (right - left + 1) - maxFreq;


            while(changes > k) {
                freq[s.charAt(left) - 'A'] -= 1;    
                left += 1;

                changes = (right - left + 1) - maxFreq;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
