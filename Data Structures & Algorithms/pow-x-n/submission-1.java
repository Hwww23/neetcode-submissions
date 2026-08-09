class Solution {
    public double myPow(double x, int n) {
        double res = dfs(x, Math.abs(n));
        return n < 0 ? 1 / res : res;
    }

    public double dfs(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double half = dfs(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
