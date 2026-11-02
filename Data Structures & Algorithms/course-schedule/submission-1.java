class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseMapping = new HashMap<>();
        
        for(int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][1];
            int prereq = prerequisites[i][0];
            courseMapping.computeIfAbsent(course, k -> new ArrayList<>()).add(prereq);
        }

        int[] visited = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, courseMapping, visited)) return false;
        }
        return true;
    }

    public boolean dfs(int course, Map<Integer, List<Integer>> courseMapping, int[] visited) {
        if(visited[course] == 1) return false; //cycle
        if(visited[course] == 2) return true; // full path visit for this course is done

        visited[course] = 1;
        List<Integer> courses = courseMapping.getOrDefault(course, new ArrayList<>());
        for(int i = 0; i < courses.size(); i++) {
            if(!dfs(courses.get(i), courseMapping, visited)) {
                return false;
            }
        }
        visited[course] = 2;
        return true;
    }
}
