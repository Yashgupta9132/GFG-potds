class Solution {
    public int maxProfit(int[][] jobs) {
        int n = jobs.length;

        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);

        int[] endTimes = new int[n];
        for (int i = 0; i < n; i++) {
            endTimes[i] = jobs[i][1];
        }

        int[] dp = new int[n];

        dp[0] = jobs[0][2];  

        for (int i = 1; i < n; i++) {
            int profit = jobs[i][2];

            int last = findLast(endTimes, jobs[i][0]);

            if (last != -1) {
                profit += dp[last];
            }

            dp[i] = Math.max(dp[i - 1], profit);
        }

        return dp[n - 1];
    }

    private int findLast(int[] endTimes, int startTime) {
        int left = 0, right = endTimes.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (endTimes[mid] <= startTime) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
