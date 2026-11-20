class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> coursesMap = new HashMap<>();

        for(int[] prereq: prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];
            coursesMap.putIfAbsent(course, new ArrayList<>());
            coursesMap.get(course).add(prerequisite);
        }

        int[] visited = new int[numCourses+1];
        for(int course = 0; course < numCourses; course++) {
            if(!coursePossible(course, visited, coursesMap)) return false;
        }
        return true;
    }

    private boolean coursePossible(int course, int[] visited, Map<Integer, List<Integer>> coursesMap) {

        if(visited[course] == 1) return false;
        if(visited[course] == 2) return true;

        visited[course] = 1;
        List<Integer> courses = coursesMap.getOrDefault(course, new ArrayList<>());

        for(int i = 0; i < courses.size(); i++) {
            if(!coursePossible(courses.get(i), visited, coursesMap)) return false;
        }
        visited[course] = 2;
        return true;
    }
}
