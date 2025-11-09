class Solution {
    public int chocolatePickup(int[][] mat) {
        int n = mat.length;
        int NEG_INF = -1000000000;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = NEG_INF;
        dp[0][0] = mat[0][0] == -1 ? NEG_INF : mat[0][0];

        for (int k = 1; k <= 2 * (n - 1); k++) {
            int[][] newDP = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    newDP[i][j] = NEG_INF;
            for (int r1 = 0; r1 < n; r1++) {
                int c1 = k - r1;
                if (c1 < 0 || c1 >= n) continue;
                if (mat[r1][c1] == -1) continue;
                for (int r2 = 0; r2 < n; r2++) {
                    int c2 = k - r2;
                    if (c2 < 0 || c2 >= n) continue;
                    if (mat[r2][c2] == -1) continue;
                    int maxPrev = NEG_INF;
                    if (r1 > 0 && r2 > 0) 
                        maxPrev = Math.max(maxPrev, dp[r1 - 1][r2 - 1]);
                    if (r1 > 0) 
                        maxPrev = Math.max(maxPrev, dp[r1 - 1][r2]);
                    if (r2 > 0)
                        maxPrev = Math.max(maxPrev, dp[r1][r2 - 1]);
                    maxPrev = Math.max(maxPrev, dp[r1][r2]);
                    if (maxPrev == NEG_INF) continue;
                    int chocolates = mat[r1][c1];
                    if (r1 != r2 || c1 != c2)
                        chocolates += mat[r2][c2];
                    newDP[r1][r2] = Math.max(newDP[r1][r2], maxPrev + chocolates);
                }
            }
            dp = newDP;
        }
        return Math.max(0, dp[n - 1][n - 1]);
    }
}
