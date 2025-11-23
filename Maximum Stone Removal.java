class Solution {
    public int maxRemove(int[][] stones) {
        int n = stones.length;
        int offset = 10001;

        DSU dsu = new DSU(20005);

        Set<Integer> seen = new HashSet<>();

        for (int[] stone : stones) {
            int r = stone[0];
            int c = stone[1] + offset;
            dsu.union(r, c);
            seen.add(r);
            seen.add(c);
        }

        int components = 0;
        for (int x : seen) {
            if (dsu.find(x) == x) {
                components++;
            }
        }

        return n - components;
    }

    class DSU {
        int[] parent, rank;
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return;

            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pb] < rank[pa]) parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
        }
    }
}
