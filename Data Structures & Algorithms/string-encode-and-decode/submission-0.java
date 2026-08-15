class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();

        for (String s : strs) {
            res.append(s.length());
            res.append("#");
            res.append(s);
        }

        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int curr = 0;
        int i = 0;

        while (i < str.length()) {
            char c = str.charAt(i);
            
            if (Character.isDigit(c)) {
                curr = curr * 10 + (c - '0');
                i++;
            } else {
                res.add(str.substring(i + 1, i + 1 + curr));
                i = i + 1 + curr;
                curr = 0;
            }
        }

        return res;
    }
}
