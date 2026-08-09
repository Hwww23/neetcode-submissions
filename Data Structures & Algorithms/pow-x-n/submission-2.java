class Solution {
    public double myPow(double x, int n) {
        long exp = n;
        if (n < 0) {
            exp = -exp;
        }

        double res = dfs(x, exp);
        return n < 0 ? 1 / res : res;
    }

    public double dfs(double x, long n) {
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
