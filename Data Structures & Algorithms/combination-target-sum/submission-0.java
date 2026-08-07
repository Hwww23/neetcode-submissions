class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        dfs(0, 0, new ArrayList<>(), nums, target);
        return res;
    }

    private void dfs(int i, int sum, List<Integer> path, int[] nums, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (sum > target || i == nums.length) {
            return;
        }

        path.add(nums[i]);
        dfs(i, sum + nums[i], path, nums, target);
        path.remove(path.size() - 1);
        dfs(i + 1, sum, path, nums, target);
    }
}
