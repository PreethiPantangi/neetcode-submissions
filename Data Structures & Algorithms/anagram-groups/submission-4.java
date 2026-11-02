class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            
            int[] strFreq = new int[26];
            for(Character ch: strs[i].toCharArray()) {
                strFreq[ch - 'a'] += 1;
            }
            map.computeIfAbsent(Arrays.toString(strFreq), k -> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

}
