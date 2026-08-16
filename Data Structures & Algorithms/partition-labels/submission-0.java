class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), i);
        }

        int i = 0;
        int len = 0;
        int currEnd = -1;
        List<Integer> res = new ArrayList<>();

        while (i < s.length()) {
            currEnd = Math.max(currEnd, hm.get(s.charAt(i)));
            len++;

            if (i == currEnd) {
                res.add(len);
                len = 0;
            }
            i++;
        }

        return res;
    }
}
