class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer, Boolean> map = new HashMap<>();
        return canBreak(s, 0, wordDict, map);
    }

    public boolean canBreak(String str, int i, List<String> wordDict, Map<Integer, Boolean> map) {

        if(i == str.length()) return true;
        if(map.containsKey(i)) return map.get(i);

        for(int j = i; j < str.length(); j++) {

            String word = str.substring(i, j+1);
            if(wordDict.contains(word)) {

                if(canBreak(str, j+1, wordDict, map)) {
                    map.put(i, true);
                    return true;
                }
                
            }

        }
        map.put(i, false);
        return false;

    }

}
