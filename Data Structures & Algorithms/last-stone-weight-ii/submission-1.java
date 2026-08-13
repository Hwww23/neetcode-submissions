class Solution {
    int[][] memo;
    int sum = 0;

    public int lastStoneWeightII(int[] stones) {
        for (int s : stones) {
            sum += s;
        }

        int target = sum / 2;
        memo = new int[stones.length][target + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        return dfs(0, 0, target, stones);
    }

    private int dfs(int i, int currSum, int target, int[] stones) {
        if (i == stones.length || currSum >= target) {
            return Math.abs(sum - currSum * 2);
        }

        if (memo[i][currSum] != -1) {
            return memo[i][currSum];
        }

        return memo[i][currSum] = Math.min(dfs(i + 1, currSum, target, stones), 
                                    dfs(i + 1, currSum + stones[i], target, stones));
    }
}