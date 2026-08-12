class Solution {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];

        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            if (find(edge[0]) == find(edge[1])) {
                return edge;
            }

            union(edge[0], edge[1]);
        }

        return new int[] {};
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        parent[rootA] = rootB;
    }
}
