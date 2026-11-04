class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<Integer, Boolean> memo = new HashMap<>();

        return canBreak(s, 0, wordDict, memo);

    }

    public boolean canBreak(String s, int i, List<String> wordDict, HashMap<Integer, Boolean> memo) {
        // "neetcode", 0, ["neet", "code"], {}
        if(i == s.length()) return true; // 3    == 8; NO

        if(memo.containsKey(i)) return memo.get(i); // {}

        for(int j = i; j < s.length(); j++) { // j = 3
            String word = s.substring(i, j + 1); // neet
            if(wordDict.contains(word)) { // yes
                if(canBreak(s, j+1, wordDict, memo)) { // "neetcode", 3, {}
                    memo.put(i, true);
                    return true;
                }
            }
        }

        memo.put(i, false);
        return false;

    }
}
