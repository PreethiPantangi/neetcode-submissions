class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<Integer, Boolean> memo = new HashMap<>();

        return canBreak(s, 0, wordDict, memo);

    }

    public boolean canBreak(String s, int i, List<String> wordDict, HashMap<Integer, Boolean> memo) {
        
        if(i == s.length()) return true;
        if(memo.containsKey(i)) return memo.get(i);

        for(int j = i; j < s.length(); j++) {
            String word = s.substring(i, j+1);
            if(wordDict.contains(word)) {
                if(canBreak(s, j+1, wordDict, memo)) {
                    memo.put(i, true);
                    return true;
                }
            }
        }
        memo.put(i, false);
        return false;
    }
}
