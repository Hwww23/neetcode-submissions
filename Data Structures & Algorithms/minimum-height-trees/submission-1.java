class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Arrays.asList(0);

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        int[] indegree = new int[n];
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
            indegree[e[0]]++;
            indegree[e[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                q.offer(i);
            }
        }

        int rem = n;
        while (rem > 2) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                rem--;

                for (int nei : graph.get(curr)) {
                    indegree[nei]--;

                    if (indegree[nei] == 1) {
                        q.offer(nei);
                    }
                }
            }
        }

        return new ArrayList<>(q);
    }
}