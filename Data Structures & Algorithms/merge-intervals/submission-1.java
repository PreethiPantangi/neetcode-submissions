class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int lastEnd = result.get(result.size()-1)[1];
            if(start <= lastEnd) {
                result.get(result.size()-1)[1] = Math.max(lastEnd, end);
            } else {
                result.add(new int[]{start, end});
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
