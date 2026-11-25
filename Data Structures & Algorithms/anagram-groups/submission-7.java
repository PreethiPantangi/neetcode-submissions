class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs) {

            int[] charArr = new int[26];
            for(Character ch: str.toCharArray()) {
                charArr[ch - 'a'] += 1;
            }

            String word = Arrays.toString(charArr);
            map.computeIfAbsent(word, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
