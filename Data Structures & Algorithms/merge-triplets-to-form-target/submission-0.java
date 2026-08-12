class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] curr = {0, 0, 0};

        for (int[] tri : triplets) {
            if (tri[0] <= target[0] && tri[1] <= target[1] && tri[2] <= target[2]) {
                curr[0] = Math.max(curr[0], tri[0]);
                curr[1] = Math.max(curr[1], tri[1]);
                curr[2] = Math.max(curr[2], tri[2]);
            }
        }

        return curr[0] == target[0] && curr[1] == target[1] && curr[2] == target[2];
    }
}
