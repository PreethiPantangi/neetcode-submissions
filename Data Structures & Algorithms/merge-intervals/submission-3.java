class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        List<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {

            int[] currentInterval = intervals[i];
            int[] previousInterval = mergedIntervals.get(mergedIntervals.size() - 1);

            int previousIntervalStart = previousInterval[0];
            int previousIntervalEnd = previousInterval[1];

            int currentIntervalStart = currentInterval[0];
            int currentIntervalEnd = currentInterval[1];

            if(currentIntervalStart <= previousIntervalEnd) {
                previousInterval[1] = Math.max(previousIntervalEnd, currentIntervalEnd);
            } else {
                mergedIntervals.add(currentInterval);
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
