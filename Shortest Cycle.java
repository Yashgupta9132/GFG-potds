import java.util.*;

class Solution {
    public int shortCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int ans = Integer.MAX_VALUE;

        for (int start = 0; start < V; start++) {
            Queue<Integer> q = new LinkedList<>();
            int[] dist = new int[V];
            int[] parent = new int[V];
            
            Arrays.fill(dist, -1);
            Arrays.fill(parent, -1);

            q.offer(start);
            dist[start] = 0;

            while (!q.isEmpty()) {
                int u = q.poll();

                for (int v : adj.get(u)) {
                    if (dist[v] == -1) {  
                        // unvisited
                        dist[v] = dist[u] + 1;
                        parent[v] = u;
                        q.offer(v);

                    } else if (parent[u] != v) {
                        int cycleLen = dist[u] + dist[v] + 1;
                        ans = Math.min(ans, cycleLen);
                    }
                }
            }
        }

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}
