import java.util.*;

class Solution {
    static class Pair {
        int node, wt;
        Pair(int n, int w) { node = n; wt = w; }
    }

    public int shortestPath(int V, int a, int b, int[][] edges) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1], w1 = e[2];
            graph.get(u).add(new Pair(v, w1));
            graph.get(v).add(new Pair(u, w1));
        }

        long[] distA = dijkstra(V, a, graph);
        long[] distB = dijkstra(V, b, graph);

        long ans = distA[b];

        for (int[] e : edges) {
            int u = e[0], v = e[1], w2 = e[3];

            if (distA[u] != Long.MAX_VALUE && distB[v] != Long.MAX_VALUE) {
                ans = Math.min(ans, distA[u] + w2 + distB[v]);
            }

            if (distA[v] != Long.MAX_VALUE && distB[u] != Long.MAX_VALUE) {
                ans = Math.min(ans, distA[v] + w2 + distB[u]);
            }
        }

        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }

    private long[] dijkstra(int V, int src, List<List<Pair>> graph) {
        long[] dist = new long[V];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.add(new Pair(src, 0));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int u = p.node;
            long d = p.wt;

            if (d > dist[u]) continue;

            for (Pair nbr : graph.get(u)) {
                int v = nbr.node;
                long w = nbr.wt;

                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.add(new Pair(v, (int) dist[v]));
                }
            }
        }
        return dist;
    }
}
