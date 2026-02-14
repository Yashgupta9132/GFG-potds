class Solution {

    public int minTime(int[] arr, int k) {
        int n = arr.length;

        long low = 0;
        long high = 0;

        for (int length : arr) {
            low = Math.max(low, length);
            high += length;
        }

        long answer = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canPaint(arr, k, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) answer;
    }

    private boolean canPaint(int[] arr, int k, long maxTime) {
        int painters = 1;
        long currentTime = 0;

        for (int length : arr) {

            if (currentTime + length <= maxTime) {
                currentTime += length;
            } else {
                painters++;
                currentTime = length;

                if (painters > k) {
                    return false;
                }
            }
        }

        return true;
    }
}
 
