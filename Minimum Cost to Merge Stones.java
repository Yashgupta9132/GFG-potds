class Solution {
    public static int mergeStones(int[] stones, int k) {
        int n = stones.length;

        if ((n - 1) % (k - 1) != 0) 
            return -1;

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) 
            prefix[i + 1] = prefix[i] + stones[i];

        int[][] dp = new int[n][n];
        final int INF = (int)1e9;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = (i == j ? 0 : INF);

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                for (int m = i; m < j; m += (k - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j]);
                }

                if ((j - i) % (k - 1) == 0) {
                    dp[i][j] += prefix[j + 1] - prefix[i];
                }
            }
        }

        return dp[0][n - 1];
    }
}
