class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();

        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            hm.computeIfAbsent(new String(c), k -> new ArrayList<>()).add(s);
        }

        List<List<String>> res = new ArrayList<>();
        res.addAll(hm.values());
        return res;
    }
}
