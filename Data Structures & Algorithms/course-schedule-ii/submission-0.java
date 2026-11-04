class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseMapping = new HashMap<>();
        for(int[] prerequisite: prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            courseMapping.computeIfAbsent(course, k -> new ArrayList<>()).add(prereq);
        }

        int[] visited = new int[numCourses];
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            if(!courseOrder(i, courseMapping, result, visited)) return new int[0];
        }
        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public boolean courseOrder(int course, Map<Integer, List<Integer>> courseMapping, List<Integer> result, int[] visited) {

        if(visited[course] == 1) return false;
        if(visited[course] == 2) return true;

        visited[course] = 1;
        List<Integer> courses = courseMapping.getOrDefault(course, new ArrayList<>());
        for(int i = 0; i < courses.size(); i++) {
            if(!courseOrder(courses.get(i), courseMapping, result, visited)) return false;
        }

        visited[course] = 2;
        result.add(course);
        return true;
    }
}
