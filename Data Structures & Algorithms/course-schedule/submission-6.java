class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> coursesMap = new HashMap<>();
        for(int[] prerequisite : prerequisites) {

            int course = prerequisite[0];
            int preReq = prerequisite[1];

            coursesMap.computeIfAbsent(course, k -> new ArrayList<>()).add(preReq);
        }

        int[] visited = new int[numCourses];

        for(int course = 0; course < numCourses; course++) {
            if(!canDoCourse(course, coursesMap, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean canDoCourse(int course, Map<Integer, List<Integer>> coursesMap, int[] visited) {

        if(visited[course] == 1) return false;
        if(visited[course] == 2) return true;

        visited[course] = 1;
        List<Integer> courses = coursesMap.getOrDefault(course, new ArrayList<>());
        for(int i = 0; i < courses.size(); i++) {
            if(!canDoCourse(courses.get(i), coursesMap, visited)) {
                return false;
            }
        }
        visited[course] = 2;
        return true;
    }
}
