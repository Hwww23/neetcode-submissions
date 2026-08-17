class Solution {
    HashMap<String, HashMap<String, Double>> hm;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        hm = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double w = values[i];

            hm.computeIfAbsent(u, k -> new HashMap<>()).put(v, w);
            hm.computeIfAbsent(v, k -> new HashMap<>()).put(u, 1.0 / w);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), 1.0, new HashSet<>());
        }

        return res;
    }

    private double dfs(String start, String end, double curr, HashSet<String> visited) {
        if (!hm.containsKey(start) || !hm.containsKey(end)) {
            return -1;
        }

        if (start.equals(end)) {
            return curr;
        }

        visited.add(start);

        for (String nei : hm.get(start).keySet()) {
            if (visited.contains(nei)) continue;

            double res = dfs(nei, end, curr * hm.get(start).get(nei), visited);

            if (res != -1) {
                return res;
            }
        }

        return -1;
    }
}