class Solution {
    public int minCostPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.add(new int[]{0, 0, 0});
        dist[0][0] = 0;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int effort = cur[0];
            int r = cur[1];
            int c = cur[2];

            if (r == n-1 && c == m-1) return effort;

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int diff = Math.abs(mat[r][c] - mat[nr][nc]);
                    int newEffort = Math.max(effort, diff);

                    if (newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;
                        pq.add(new int[]{newEffort, nr, nc});
                    }
                }
            }
        }

        return 0; 
    }
}
