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

        if (s.charAt(idx) == '0') {
            return 0;
        }

        if (memo[idx] != -1) {
            return memo[idx];
        }

        int way = dfs(idx + 1, s);

        if (idx + 2 <= s.length() && 
                (s.charAt(idx) == '1' || s.charAt(idx) <= '2' && s.charAt(idx + 1) <= '6')) {
            way += dfs(idx + 2, s);
        }

        return memo[idx] = way;
    }
}
