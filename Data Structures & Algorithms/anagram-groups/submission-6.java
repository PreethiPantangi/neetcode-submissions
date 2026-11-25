class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {

            int[] sorted = new int[26];
            for(Character ch : str.toCharArray()) {
                sorted[ch - 'a'] += 1;
            }
            String sortedWord = Arrays.toString(sorted);
            map.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
