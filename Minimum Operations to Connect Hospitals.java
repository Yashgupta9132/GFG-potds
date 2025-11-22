class Solution {
    public int minConnect(int V, int[][] edges) {
        // DSU initialization
        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;

        int extra = 0; 

        for (int[] e : edges) {
            int u = find(parent, e[0]);
            int v = find(parent, e[1]);

            if (u == v) {
                extra++; 
            } else {
                union(parent, rank, u, v);
            }
        }

        int components = 0;
        for (int i = 0; i < V; i++) {
            if (parent[i] == i) components++;
        }

        int required = components - 1;
        return extra >= required ? required : -1;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    private void union(int[] parent, int[] rank, int x, int y) {
        if (rank[x] < rank[y]) {
            parent[x] = y;
        } else if (rank[y] < rank[x]) {
            parent[y] = x;
        } else {
            parent[y] = x;
            rank[x]++;
        }
    }
}
