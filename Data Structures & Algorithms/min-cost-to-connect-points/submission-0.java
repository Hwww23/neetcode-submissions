class Solution {
    public int minCostConnectPoints(int[][] points) {
        int[] dist = new int[points.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        boolean[] visited = new boolean[points.length];

        int total = 0;

        for (int i = 0; i < points.length; i++) {
            int minNode = -1;

            for (int j = 0; j < points.length; j++) {
                if (!visited[j] && (minNode == -1 || dist[j] < dist[minNode])) {
                    minNode = j;
                }
            }

            visited[minNode] = true;
            total += dist[minNode];

            for (int j = 0; j < points.length; j++) {
                if (!visited[j]) {
                    int newDist = Math.abs(points[j][0] - points[minNode][0])
                                + Math.abs(points[j][1] - points[minNode][1]);
                    dist[j] = Math.min(dist[j], newDist);
                }
            }
        }

        return total;
    }
}
