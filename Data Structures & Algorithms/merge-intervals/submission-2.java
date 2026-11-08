class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            int[] lastInterval = result.get(result.size() - 1);
            int start = lastInterval[0];
            int end = lastInterval[1];
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if(currentStart <= end) {
                result.get(result.size() - 1)[1] = Math.max(currentEnd, end);
            } else {
                result.add(new int[]{currentStart, currentEnd});
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
