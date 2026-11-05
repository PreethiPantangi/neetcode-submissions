class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> result = new ArrayList<>(); // []
        
        // Intervals: [[1,5]] New Interval: [5,7]
        for(int[] interval : intervals) { // [1,5]

            if(newInterval == null || interval[1] < newInterval[0]) { // 5 < 5
                result.add(interval); // [[1,2], [3,5]]
            } else if(interval[0] > newInterval[1]) { // 5 > 5
                result.add(newInterval); // [[1,2], [3,5], [6,7]]
                result.add(interval); // [[1,2], [3,5], [6,7], [9,10]]
                newInterval = null;
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]); // [1,5]
                newInterval[1] = Math.max(newInterval[1], interval[1]); // [1,7]
            }
        }
        if(newInterval != null) result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }

}
