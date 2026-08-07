class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, 0, new ArrayList<>(), candidates, target);
        return res;
    }

    private void dfs(int i, int sum, List<Integer> path, int[] candidates, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        if (sum > target || i == candidates.length) {
            return;
        }
        
        path.add(candidates[i]);
        dfs(i + 1, sum + candidates[i], path, candidates, target);
        path.remove(path.size() - 1);


        while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
            i++;
        }

        dfs(i + 1, sum, path, candidates, target);
    }
}
