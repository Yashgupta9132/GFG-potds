class Solution {
    public int maxSumIS(int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
        }

        int maxSum = arr[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}
