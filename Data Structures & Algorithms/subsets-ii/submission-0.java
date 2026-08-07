class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, new ArrayList<>(), nums);
        return res;
    }

    private void dfs(int i, List<Integer> path, int[] nums) {
        if (i == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[i]);
        dfs(i + 1, path, nums);
        path.remove(path.size() - 1);

        while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
            i++;
        }

        dfs(i + 1, path, nums);
    }
}
