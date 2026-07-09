class Solution {

    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        TreeMap<Double, List<int[]>> map = new TreeMap<>();
        for(int[] point : points) {
            double dist = point[0] * point[0] + point[1] * point[1];
            map.putIfAbsent(dist, new ArrayList<>());
            map.get(dist).add(point);
        }
        int index = 0;
        for(Map.Entry<Double, List<int[]>> entry: map.entrySet())  {
            for(int[] point : entry.getValue()) {
                result[index++] = point;
                if(index == k) {
                    return result;
                }
            }
        }
        return result;
    }
}
