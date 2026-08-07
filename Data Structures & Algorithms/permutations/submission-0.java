class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        dfs(0, new ArrayList<>(), nums);
        return res;
    }

    private void dfs(int i, List<Integer> path, int[] nums) {
        if (i == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            path.add(nums[i]);
            dfs(i + 1, path, nums);
            swap(nums, i, j);
            path.remove(path.size() - 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
