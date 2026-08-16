class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];

        if (!dfs(0, -1, graph, visited)) {
            return false;
        }

        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int i, int prev, List<List<Integer>> graph, boolean[] visited) {
        if (visited[i]) return false;

        visited[i] = true;

        for (int nei : graph.get(i)) {
            if (nei != prev && !dfs(nei, i, graph, visited)) {
                return false;
            }
        }

        return true;
    }
}
