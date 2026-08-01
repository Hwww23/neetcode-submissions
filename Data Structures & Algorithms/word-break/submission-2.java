class Solution {
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length()];
        return dfs(0, s, wordDict);
    }

    private boolean dfs(int idx, String s, List<String> wordDict) {
        if (idx == s.length()) {
            return true;
        }

        if (memo[idx] != null) {
            return memo[idx];
        }

        for (String word : wordDict) {
            if (s.startsWith(word, idx) && dfs(idx + word.length(), s, wordDict)) {
                return memo[idx] = true;
            }
        }

        return memo[idx] = false;
    }
}
