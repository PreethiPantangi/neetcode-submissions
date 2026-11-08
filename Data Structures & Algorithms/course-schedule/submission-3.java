class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int[] prerequisite: prerequisites) {
            map.computeIfAbsent(prerequisite[0], k -> new ArrayList<>()).add(prerequisite[1]);
        }

        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(!isValid(map, visited, i)) return false;
        }
        return true;
    }

    private boolean isValid(Map<Integer, List<Integer>> map, int[] visited, int course) {

        if(visited[course] == 1) return false;
        if(visited[course] == 2) return true;

        visited[course] = 1;
        List<Integer> courses = map.getOrDefault(course, new ArrayList<>());
        for(int i = 0; i < courses.size(); i++) {
            if(!isValid(map, visited, courses.get(i))) return false;
        }
        visited[course] = 2;
        return true;
    }
}
