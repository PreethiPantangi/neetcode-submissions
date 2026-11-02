class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseMapping = new HashMap<>();
        
        for(int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][1];
            int p = prerequisites[i][0];
            courseMapping.computeIfAbsent(course, k -> new ArrayList<>()).add(p);
        }

        int[] visited = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, courseMapping, visited)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int course, Map<Integer, List<Integer>> courseMapping, int[] visited) {
        if(visited[course] == 1) return false; // Cycle, meaning 
        if(visited[course] == 2) return true; // Completed course

        visited[course] = 1;
        for(int next : courseMapping.getOrDefault(course, Collections.emptyList())) {
            if(!dfs(next, courseMapping, visited)) return false;
        }
        visited[course] = 2;
        return true;
    }
}
