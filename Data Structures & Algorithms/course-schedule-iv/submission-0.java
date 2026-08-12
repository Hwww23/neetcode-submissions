class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            graph.get(pre[0]).add(pre[1]);
            indegree[pre[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        List<HashSet<Integer>> req = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            req.add(new HashSet<>());
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int nei : graph.get(curr)) {
                req.get(nei).add(curr);
                req.get(nei).addAll(req.get(curr));

                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] que : queries) {
            res.add(req.get(que[1]).contains(que[0]));
        }

        return res;
    }
}