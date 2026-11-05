class Solution {
    public int[][] kClosest(int[][] points, int k) {

        Map<Integer, List<int[]>> map = new TreeMap<>();
        for(int i = 0; i < points.length; i++) {
            int distance = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            map.computeIfAbsent(distance, key -> new ArrayList<>()).add(points[i]);
        }

        int[][] result = new int[k][2];
        int index = 0;
        for(Map.Entry<Integer, List<int[]>> entry: map.entrySet()) {

            for (int[] point : entry.getValue()) {
                if (index == k) {
                    return result;
                }

                result[index++] = point;
            }

            if(index == k) break;
        }
        return result;
    }
}
