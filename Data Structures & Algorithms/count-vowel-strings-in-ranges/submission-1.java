class Solution {

    class VowelDetails {
        String word;
        int position;
        boolean isVowel;

        VowelDetails(String word, int position, boolean isVowel) {
            this.word = word;
            this.position = position;
            this.isVowel = isVowel;
        }
    }

    private final List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');

    public int[] vowelStrings(String[] words, int[][] queries) {

        Map<Integer, VowelDetails> map = new HashMap<>();

        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int start = query[0];
            int end = query[1];
            int count = 0;
            for(int j = start; j <= end; j++) {
                if(map.containsKey(j)) {
                    if(map.get(j).isVowel) {
                        count += 1;
                    }
                } else {
                    boolean isVowel = checkStartAndEndForVowel(words[j]);
                    map.put(j, new VowelDetails(words[j], j, isVowel));
                    if(isVowel) {
                        count += 1;
                    }
                }
            }
            result[i] = count;
        }
        return result;
    }

    private boolean checkStartAndEndForVowel(String word) {
        Character firstLetter = word.charAt(0);
        Character lastLetter = word.charAt(word.length() - 1);
        return vowels.contains(firstLetter) && vowels.contains(lastLetter);
    }
}