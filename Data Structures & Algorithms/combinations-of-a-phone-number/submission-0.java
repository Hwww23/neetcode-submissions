class Solution {
    List<String> res;
    String[] nums = new String[10];

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();

        if (digits.length() == 0) return res;
        
        nums[2] = "abc";
        nums[3] = "def";
        nums[4] = "ghi";
        nums[5] = "jkl";
        nums[6] = "mno";
        nums[7] = "pqrs";
        nums[8] = "tuv";
        nums[9] = "wxyz";

        dfs(0, new StringBuilder(), digits);
        return res;
    }

    private void dfs(int i, StringBuilder path, String digits) {
        if (i == digits.length()) {
            res.add(path.toString());
            return;
        }

        for (char c : nums[digits.charAt(i) - '0'].toCharArray()) {
            path.append(c);
            dfs(i + 1, path, digits);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
