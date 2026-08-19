class Solution {
    boolean[] vert;
    boolean[] diagR;
    boolean[] diagL;
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        vert = new boolean[n];
        diagR = new boolean[2 * n];
        diagL = new boolean[2 * n];

        res = new ArrayList<>();

        dfs(0, new ArrayList<>(), n);
        return res;
    }

    private void dfs(int i, List<String> path, int n) {
        if (i == n) {
            res.add(new ArrayList<>(path));
        }

        char[] arr = new char[n];
        Arrays.fill(arr, '.');

        for (int j = 0; j < n; j++) {
            if (vert[j] || diagR[i - j + n - 1] || diagL[i + j]) continue;

            vert[j] = true;
            diagR[i - j + n - 1] = true;
            diagL[i + j] = true;

            arr[j] = 'Q';
            path.add(new String(arr));
            dfs(i + 1, path, n);
            path.remove(path.size() - 1);
            arr[j] = '.';

            vert[j] = false;
            diagR[i - j + n - 1] = false;
            diagL[i + j] = false;
        }
    }
}
