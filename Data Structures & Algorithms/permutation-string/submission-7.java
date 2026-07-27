class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> window = new HashMap<>(need);

        int l = 0;
        for (int r = 0; r < s2.length(); r++) {
            if (window.get(s2.charAt(r)) == null) {
                window = new HashMap<>(need);
                l = r + 1;
                continue;
            } 

            while (window.get(s2.charAt(r)) == 0) {
                window.put(s2.charAt(l), window.get(s2.charAt(l)) + 1);
                l++;
            }

            window.put(s2.charAt(r), window.get(s2.charAt(r)) - 1);

            if (r - l + 1 == s1.length()) return true;
        }

        return false;
    }
}
