class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        dfs(0, new ArrayList<>(), nums);
        return res;
    }

    private void dfs(int i, List<Integer> path, int[] nums) {
        if (i == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        dfs(i + 1, path, nums);
        path.add(nums[i]);
        dfs(i + 1, path, nums);
        path.remove(path.size() - 1);
    }
}
