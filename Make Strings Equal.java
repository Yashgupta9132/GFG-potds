class Solution {
    public int minCost(String s, String t, char[][] transform, int[] cost) {
        int n = s.length();
        
        int INF = (int)1e9;
        int[][] dist = new int[26][26];

        for (int i = 0; i < 26; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < transform.length; i++) {
            int u = transform[i][0] - 'a';
            int v = transform[i][1] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        long total = 0;

        for (int i = 0; i < n; i++) {
            int a = s.charAt(i) - 'a';
            int b = t.charAt(i) - 'a';

            if (a == b) continue; 

            int best = INF;

            for (int c = 0; c < 26; c++) {
                if (dist[a][c] < INF && dist[b][c] < INF) {
                    best = Math.min(best, dist[a][c] + dist[b][c]);
                }
            }

            if (best == INF) return -1; 
            total += best;
        }

        return (int)total;
    }
}
