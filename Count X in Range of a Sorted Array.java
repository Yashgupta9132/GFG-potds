import java.util.ArrayList;

class Solution {
    private int lowerBound(int[] arr, int x) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int upperBound(int[] arr, int x) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int[] q : queries) {
            int l = q[0], r = q[1], x = q[2];

            int first = lowerBound(arr, x);
            int last = upperBound(arr, x) - 1;

            if (first > last) {
                result.add(0);
                continue;
            }

            int left = Math.max(first, l);
            int right = Math.min(last, r);

            if (left > right) {
                result.add(0);
            } else {
                result.add(right - left + 1);
            }
        }

        return result;
    }
}
