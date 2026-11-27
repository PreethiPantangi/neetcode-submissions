class Solution {
    public int findChampion(int n, int[][] edges) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[n];

        for(int[] edge: edges) {
            int strongTeam = edge[0];
            int weakTeam = edge[1];
            inDegree[weakTeam] += 1;
            map.computeIfAbsent(strongTeam, k -> new ArrayList<>()).add(weakTeam);
        }
        

        int champion = -1;
        int count = 0;

        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) {
                champion = i;
                count += 1;
            }
        }

        return count == 1 ? champion : -1;
    }
}
