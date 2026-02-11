import java.util.Arrays;

class Solution {

    public int minCost(int[] heights, int[] cost) {
        int n = heights.length;

        long[][] arr = new long[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = heights[i];
            arr[i][1] = cost[i];
        }

        Arrays.sort(arr, (a, b) -> Long.compare(a[0], b[0]));

        long totalCost = 0;
        for (int i = 0; i < n; i++) {
            totalCost += arr[i][1];
        }

        long cumulative = 0;
        long median = 0;

        for (int i = 0; i < n; i++) {
            cumulative += arr[i][1];
            if (cumulative * 2 >= totalCost) {
                median = arr[i][0];
                break;
            }
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.abs(arr[i][0] - median) * arr[i][1];
        }

        return (int) result;  
    }
}
