class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs.length == 0) return result;
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            String str = strs[i];
            String sortedStr = Arrays.stream(str.split("")).
                                sorted().
                                collect(Collectors.joining(""));
            map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }
        for(Map.Entry<String, List<String>> entry: map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
