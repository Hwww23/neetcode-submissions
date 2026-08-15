class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        int prefix = 0;
        int total = 0;

        for (int n : nums) {
            prefix += n;

            if (hm.get(prefix - k) != null) {
                total += hm.get(prefix - k);
            }

            hm.put(prefix, hm.getOrDefault(prefix, 0) + 1);
        }

        return total;
    }
}