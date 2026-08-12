class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }
        
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int i, List<List<Integer>> graph, int[] visited) {
        if (visited[i] == 2) {
            return true;
        }

        if (visited[i] == 1) {
            return false;
        }

        visited[i] = 1;

        for (int nei : graph.get(i)) {
            if (!dfs(nei, graph, visited)) {
                return false;
            }
        }

        visited[i] = 2;
        return true;
    }
}
