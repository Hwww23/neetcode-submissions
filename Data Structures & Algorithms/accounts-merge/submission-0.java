class Solution {
    int[] parent;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> emailNode = new HashMap<>();
        HashMap<String, String> emailName = new HashMap<>();
        int idx = 0;
        for (List<String> acc : accounts) {
            String name = acc.get(0);

            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);

                if (!emailNode.containsKey(email))
                emailName.put(email, name);
                emailNode.put(email, idx++);
            }
        }

        parent = new int[idx];
        for (int i = 0; i < idx; i++) {
            parent[i] = i;
        }


        for (List<String> acc : accounts) {
            int a = emailNode.get(acc.get(1));

            for (int i = 2; i < acc.size(); i++) {
                int b = emailNode.get(acc.get(i));
                
                if (find(a) != find(b)){
                    union(a, b);
                }
            }
        }

        HashMap<Integer, List<String>> group = new HashMap<>();
        for (String email : emailNode.keySet()) {
            int root = find(emailNode.get(email));

            group.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> emails : group.values()) {
            Collections.sort(emails);
            String name = emailName.get(emails.get(0));

            List<String> ans = new ArrayList<>();
            ans.add(name);
            ans.addAll(emails);
            res.add(ans);
        }

        return res;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        parent[rootB] = rootA;
    }
}