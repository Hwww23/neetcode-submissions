class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int[] memo = new int[nums.length];
        int[] parents = new int[nums.length];
        Arrays.fill(memo, 1);
        Arrays.fill(parents, -1);
        int maxLen = 1;
        int maxIdx = 0;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (memo[j] + 1 > memo[i]) {
                        memo[i] = memo[j] + 1;
                        parents[i] = j;
                    }
                }
            }

            if (memo[i] > maxLen) {
                maxLen = memo[i];
                maxIdx = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        while (maxIdx != -1) {
            res.add(nums[maxIdx]);
            maxIdx = parents[maxIdx];
        }

        Collections.reverse(res);
        return res;
    }
}