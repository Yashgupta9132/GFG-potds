import java.util.*;

class Solution {
    public int diameter(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int farthestNode = bfsFarthestNode(0, adj, V);

        int diameter = bfsMaxDistance(farthestNode, adj, V);

        return diameter;
    }

    private int bfsFarthestNode(int start, ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});
        visited[start] = true;

        int farthestNode = start;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int dist = curr[1];

            farthestNode = node;
            for (int neigh : adj.get(node)) {
                if (!visited[neigh]) {
                    visited[neigh] = true;
                    q.offer(new int[]{neigh, dist + 1});
                }
            }
        }
        return farthestNode;
    }

    private int bfsMaxDistance(int start, ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});
        visited[start] = true;

        int maxDist = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int dist = curr[1];
            maxDist = Math.max(maxDist, dist);

            for (int neigh : adj.get(node)) {
                if (!visited[neigh]) {
                    visited[neigh] = true;
                    q.offer(new int[]{neigh, dist + 1});
                }
            }
        }
        return maxDist;
    }
}
