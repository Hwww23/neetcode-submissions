class Solution {
    int[] memo;
    public int numDecodings(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dfs(0, s);
    }

    private int dfs(int idx, String s) {
        if (idx == s.length()) {
            return 1;
        }

        if (s.startsWith("0", idx)) {
            return 0;
        }

        if (memo[idx] != -1) {
            return memo[idx];
        }

        int way = dfs(idx + 1, s);

        if (idx + 2 <= s.length() && Integer.parseInt(s.substring(idx, idx + 2)) <= 26) {
            way += dfs(idx + 2, s);
        }

        return memo[idx] = way;
    }
}
