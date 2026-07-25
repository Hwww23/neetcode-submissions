class Solution {
    int[] sides = new int[4];
    int target;

    public boolean makesquare(int[] matchsticks) {
        int total = 0;
        for (int m : matchsticks) {
            total += m;
        }

        if (total % 4 != 0) return false;

        target = total / 4;
        Arrays.sort(matchsticks);

        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }

        return dfs(0, matchsticks);
    }

    private boolean dfs(int idx, int[] sticks) {
        if (idx == sticks.length) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            if (sides[i] + sticks[idx] > target) continue;

            sides[i] += sticks[idx];
            if (dfs(idx + 1, sticks)) {
                return true;
            }
            sides[i] -= sticks[idx];

            if (sides[i] == 0) break;
        }

        return false;
    }
}