class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int n : nums) {
            hs.add(n);
        }

        int max = 0;
        for (int num : hs) {
            if (hs.contains(num - 1)) {
                continue;
            }

            int curr = num;
            int len = 1;
            while (hs.contains(curr + 1)) {
                curr++;
                len++;
            }

            max = Math.max(max, len);
        }

        return max;
    }
}
