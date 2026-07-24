class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> hm = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double w = values[i];

            hm.computeIfAbsent(u, k -> new HashMap<>()).put(v, w);
            hm.computeIfAbsent(v, k -> new HashMap<>()).put(u, 1.0 / w);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            res[i] = dfs(start, end, 1.0, hm, new HashSet<>());
        }

        return res;
    }

    private double dfs(String start, String end, double curr, HashMap<String, HashMap<String, Double>> hm,
        HashSet<String> visited) {
        if (!hm.containsKey(start) || !hm.containsKey(end)) {
            return -1.0;
        }

        if (start.equals(end)) {
            return curr;
        }

        visited.add(start);

        for (String nei : hm.get(start).keySet()) {
            if (visited.contains(nei)) continue;

            double ans = dfs(nei, end, curr * hm.get(start).get(nei), hm, visited);

            if (ans != -1) {
                return ans;
            }
        }

        return -1;
    }
}