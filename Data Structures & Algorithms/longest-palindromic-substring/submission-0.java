class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int startIdx = 0;
        boolean[][] memo = new boolean[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || memo[i + 1][j - 1])) {
                    memo[i][j] = true;

                    if (maxLen < j - i + 1) {
                        maxLen = j - i + 1;
                        startIdx = i;
                    }
                }
            }
        }

        return s.substring(startIdx, startIdx + maxLen);
    }
}
