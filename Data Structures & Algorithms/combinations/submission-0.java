class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        dfs(1, new ArrayList<>(), n, k);
        return res;
    }

    private void dfs(int i, List<Integer> path, int n, int k) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (i > n) {
            return;
        }

        dfs(i + 1, path, n, k);
        path.add(i);
        dfs(i + 1, path, n, k);
        path.remove(path.size() - 1);
    }
}