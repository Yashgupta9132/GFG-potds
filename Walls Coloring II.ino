class Solution {
    int minCost(int[][] costs) {
        int n = costs.length;
        if (n == 0) return 0;
        
        int k = costs[0].length;
        if (k == 0) return -1;

        if (k == 1) {
            return n == 1 ? costs[0][0] : -1;  
        }

        int[] dp = new int[k];

        System.arraycopy(costs[0], 0, dp, 0, k);

        for (int i = 1; i < n; i++) {
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            int min1Color = -1;

            for (int c = 0; c < k; c++) {
                int val = dp[c];
                if (val < min1) {
                    min2 = min1;
                    min1 = val;
                    min1Color = c;
                } else if (val < min2) {
                    min2 = val;
                }
            }

            int[] newDP = new int[k];
            for (int c = 0; c < k; c++) {
                int bestPrev = (c == min1Color) ? min2 : min1;
                newDP[c] = costs[i][c] + bestPrev;
            }

            dp = newDP;
        }

        int result = Integer.MAX_VALUE;
        for (int c = 0; c < k; c++) {
            result = Math.min(result, dp[c]);
        }
        return result;
    }
}
