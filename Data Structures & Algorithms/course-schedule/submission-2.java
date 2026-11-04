class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseMapping = new HashMap<>();
        for(int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            courseMapping.computeIfAbsent(course, k -> new ArrayList<>()).add(prereq);
        }

        int[] visited = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, courseMapping, visited)) return false;
        }
        return true;
    }

    public boolean dfs(int course, Map<Integer, List<Integer>> courseMapping, int[] visited) {

        if(visited[course] == 1) return false;
        if(visited[course] == 2) return true;

        visited[course] = 1;
        List<Integer> prereqs = courseMapping.getOrDefault(course, new ArrayList<>());
        for(int i = 0; i < prereqs.size(); i++) {
            if(!dfs(prereqs.get(i), courseMapping, visited)) return false;
        }
        visited[course] = 2;
        return true;
    }

    
}
