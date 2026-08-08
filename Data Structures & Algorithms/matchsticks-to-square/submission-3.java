class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int n : matchsticks) {
            sum += n;
        }

        if (sum % 4 != 0) return false;

        int target = sum / 4;

        for (int n : matchsticks) {
            if (n > target) return false;
        }

        int[] sides = new int[4];
        return dfs(0, sides, matchsticks, target);
    }

    private boolean dfs(int i, int[] sides, int[] matchsticks, int target) {
        if (i == matchsticks.length) {
            return true;
        }

        for (int j = 0; j < 4; j++) {
            if (sides[j] + matchsticks[i] <= target) {
                sides[j] += matchsticks[i];

                if (dfs(i + 1, sides, matchsticks, target)) {
                    return true;
                }

                sides[j] -= matchsticks[i];
            }

            if (sides[j] == 0) break;
        }

        return false;
    }
}