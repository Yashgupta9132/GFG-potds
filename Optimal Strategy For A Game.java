class Solution {
    public int maximumAmount(int arr[]) {
        int n = arr.length;
        
        int[][] dp = new int[n][n];

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                
                if (gap == 0) {
                    dp[i][j] = arr[i];
                } 
                else if (gap == 1) {
                    dp[i][j] = Math.max(arr[i], arr[j]);
                }
                else {
                    int pickLeft = arr[i] + Math.min(dp[i+2][j], dp[i+1][j-1]);
                    int pickRight = arr[j] + Math.min(dp[i+1][j-1], dp[i][j-2]);
                    dp[i][j] = Math.max(pickLeft, pickRight);
                }
            }
        }

        return dp[0][n-1];
    }
}
