class Solution {
    boolean[] memo;

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int s : stones) {
            sum += s;
        }

        int target = sum / 2;
        memo = new boolean[target + 1];
        memo[0] = true;

        for (int stone : stones) {
            for (int i = target; i >= stone; i--) {
                memo[i] |= memo[i - stone];
            }
        }

        for (int i = target; i >= 0; i--) {
            if (memo[i]) {
                return sum - 2 * i;
            }
        }

        return 0;
    }
}