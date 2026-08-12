class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();

        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);

            for (int nei : graph.get(curr)) {
                indegree[nei]--;

                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        if (res.size() != numCourses) {
            return new int[] {};
        }

        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}
