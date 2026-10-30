class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();

        result.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            int[] prevInterval = result.get(result.size()-1);
            if(intervals[i][0] <= prevInterval[1]) {
                prevInterval[1] = Math.max(intervals[i][1], prevInterval[1]);
            } else {
                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
