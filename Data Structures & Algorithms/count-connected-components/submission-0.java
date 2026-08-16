class Solution {
    int[] parent;

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];

            if (find(a) != find(b)) {
                union(a, b);
            }
        }

        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hs.add(find(i));
        }

        return hs.size();
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
