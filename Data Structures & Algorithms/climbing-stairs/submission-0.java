class Solution {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        return getWays(n, map);
    }

    private int getWays(int n, HashMap<Integer, Integer> map) {
        if(n < 0) return 0;
        if(n == 0) return 1;

        if(map.containsKey(n)) return map.get(n);

        int ways = getWays(n-1, map) + getWays(n-2, map);
        map.put(n, ways);
        return ways;
    }
}
