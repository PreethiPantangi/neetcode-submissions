class Solution {

    class VowelDetails {
        String word;
        int position;
        boolean startsAndEndsWithVowel;

        VowelDetails(String word, int position, boolean startsAndEndsWithVowel) {
            this.word = word;
            this.position = position;
            this.startsAndEndsWithVowel = startsAndEndsWithVowel;
        }
    }

    private final List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');

    public int[] vowelStrings(String[] words, int[][] queries) {

        List<VowelDetails> details = new ArrayList<>();

        for(int i = 0; i < words.length; i++) {
            boolean isVowel = checkStartAndEndForVowel(words[i]);
            details.add(new VowelDetails(words[i], i, isVowel));
        }

        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int start = query[0];
            int end = query[1];
            int count = 0;
            for(int j = start; j <= end; j++) {
                if(details.get(j).startsAndEndsWithVowel) {
                    count += 1;
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