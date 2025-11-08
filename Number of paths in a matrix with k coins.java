class Solution {
    public int numberOfPath(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        int[][][] dp = new int[n][m][k + 1];

        int startCoins = mat[0][0];
        if (startCoins <= k) dp[0][0][startCoins] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int sum = 0; sum <= k; sum++) {
                    if (i == 0 && j == 0) continue;

                    int coin = mat[i][j];
                    if (sum - coin < 0) continue;

                    int ways = 0;

                    if (i > 0) {
                        ways += dp[i - 1][j][sum - coin];
                    }

                    if (j > 0) {
                        ways += dp[i][j - 1][sum - coin];
                    }

                    dp[i][j][sum] = ways;
                }
            }
        }

        return dp[n - 1][m - 1][k];
    }
}
