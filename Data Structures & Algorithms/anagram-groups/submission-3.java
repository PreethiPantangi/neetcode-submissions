class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(strs[i]);
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
