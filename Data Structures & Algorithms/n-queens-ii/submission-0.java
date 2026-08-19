class Solution {
    boolean[] vert;
    boolean[] diagR;
    boolean[] diagL;
    int total = 0;

    public int totalNQueens(int n) {
        vert = new boolean[n];
        diagR = new boolean[2 * n];
        diagL = new boolean[2 * n];

        dfs(0, n);
        return total;
    }

    private void dfs(int i, int n) {
        if (i == n) {
            total++;
            return;
        }

        for (int j = 0; j < n; j++) {
            if (vert[j] || diagR[i - j + n - 1] || diagL[i + j]) continue;

            vert[j] = true;
            diagR[i - j + n - 1] = true;
            diagL[i + j] = true;

            dfs(i + 1, n);

            vert[j] = false;
            diagR[i - j + n - 1] = false;
            diagL[i + j] = false;
        }
    }
}
