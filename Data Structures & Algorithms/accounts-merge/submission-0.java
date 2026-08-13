class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int size = accounts.size();
        UnionFind unionFind = new UnionFind(size);
        Map<String, Integer> emailToAccount = new HashMap<>();

        for (int i = 0; i < size; i++) {
            List<String> emails = accounts.get(i);
            for (int j = 1; j < emails.size(); j++) {
                String email = emails.get(j);
                if (emailToAccount.containsKey(email)) {
                    unionFind.union(i, emailToAccount.get(email));
                } else {
                    emailToAccount.put(email, i);
                }
            }
        }

        Map<Integer, List<String>> emailGroup = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailToAccount.entrySet()) {
            String email = entry.getKey();
            int accountId = entry.getValue();
            int parent = unionFind.find(entry.getValue());
            if (!emailGroup.containsKey(parent)) {
                emailGroup.put(parent, new ArrayList<>());
            }
            emailGroup.get(parent).add(email);
        }

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<Integer, List<String>> entry : emailGroup.entrySet()) {
            Integer accountId = entry.getKey();
            List<String> current = new ArrayList<>();
            current.add(accounts.get(accountId).get(0));
            current.addAll(entry.getValue());
            result.add(current);
        }
        return result;
    }
}

class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int u) {
        int p = parent[u];
        if (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public boolean union(int u, int v) {
        int parent1 = find(u);
        int parent2 = find(v);
        if (parent1 == parent2) {
            return false;
        }
        if (rank[parent1] > rank[parent2]) {
            parent[parent2] = parent1;
            rank[parent1] += rank[parent2];
        } else {
            parent[parent1] = parent2;
            rank[parent2] += rank[parent1];
        }
        return true;
    }
}