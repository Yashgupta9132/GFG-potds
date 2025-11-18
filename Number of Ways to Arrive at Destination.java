class Solution {
    static class Pair {
        int node;
        long dist;
        Pair(int n, long d) { node = n; dist = d; }
    }

    public int countPaths(int V, int[][] edges) {
        int mod = (int)1_000_000_007;

        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1], t = e[2];
            adj.get(u).add(new Pair(v, t));
            adj.get(v).add(new Pair(u, t));
        }

        long[] dist = new long[V];
        long[] ways = new long[V];

        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> Long.compare(a.dist, b.dist)
        );
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int node = cur.node;
            long d = cur.dist;

            if (d > dist[node]) continue;

            for (Pair nei : adj.get(node)) {
                long newDist = d + nei.dist;

                if (newDist < dist[nei.node]) {
                    dist[nei.node] = newDist;
                    ways[nei.node] = ways[node];
                    pq.add(new Pair(nei.node, newDist));
                }
                else if (newDist == dist[nei.node]) {
                    ways[nei.node] = (ways[nei.node] + ways[node]) % mod;
                }
            }
        }

        return (int)(ways[V - 1] % mod);
    }
}
