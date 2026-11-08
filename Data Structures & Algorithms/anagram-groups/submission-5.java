class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs) {
            int[] countFreq = new int[26];
            for(Character ch: str.toCharArray())  {
                countFreq[ch - 'a'] += 1;
            }

            String sortedStr = Arrays.toString(countFreq);

            map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
