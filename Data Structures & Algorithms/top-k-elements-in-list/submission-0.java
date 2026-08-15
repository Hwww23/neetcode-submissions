class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int n : nums) {
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int num : hm.keySet()) {
            int freq = hm.get(num);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(num);
        }

        int[] res = new int[k];
        int i = 0;
        for (int j = bucket.length - 1; j >= 0 && i < k; j--) {
            if (bucket[j] == null) {
                continue;
            }

            for (int num : bucket[j]) {
                res[i++] = num;

                if (i == k) break;
            }
        }

        return res;
    }
}
