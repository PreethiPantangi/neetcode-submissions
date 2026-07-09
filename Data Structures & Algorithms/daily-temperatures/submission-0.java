class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        for(int i = 0; i < len; i++) {
            int j = i + 1;
            while(j < len && temperatures[j] <= temperatures[i]) {
                j += 1;
            }
            result[i] = (j < len) ? j - i : 0;
        }
        return result;
    }
}
