class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        dfs(0, new ArrayList<>(), nums);
        return res;
    }

    private void dfs(int i, List<Integer> path, int[] nums) {
        if (i == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        HashSet<Integer> hs = new HashSet<>();

        for (int j = i; j < nums.length; j++) {
            if (hs.contains(nums[j])) continue;

            swap(nums, i, j);
            path.add(nums[i]);
            dfs(i + 1, path, nums);

            hs.add(nums[i]);

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