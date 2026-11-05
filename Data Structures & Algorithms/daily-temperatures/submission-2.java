class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] answers = new int[len];

        for(int i = 0; i < len; i++) {
            int currTemp = temperatures[i];
            int days = 0;
            for(int j = i; j < len; j++) {
                if(temperatures[j] > currTemp) {
                    answers[i] = j - i;
                    break;
                }
            }
        }
        return answers;
    }
}
